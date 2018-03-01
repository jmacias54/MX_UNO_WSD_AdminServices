package mx.com.amx.unotv.adminservice.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.dao.exception.HNotaDAOException;
import mx.com.amx.unotv.adminservice.mapper.TotalRowMapper;
import mx.com.amx.unotv.adminservice.model.HNota;
import mx.com.amx.unotv.adminservice.model.NNota;
import mx.com.amx.unotv.adminservice.model.request.ItemsFilterRequest;
import mx.com.amx.unotv.adminservice.model.request.ItemsRequest;
import mx.com.amx.unotv.adminservice.model.request.ItemsRequestByTitle;
import mx.com.amx.unotv.adminservice.model.response.ItemsResponse;
// TODO: Auto-generated Javadoc

/**
 * The Class HNotaDAO.
 *
 * @author Jesus A. Macias Benitez
 */
public class HNotaDAO {

	/** The logger. */
	private Logger logger = Logger.getLogger(HNotaDAO.class);

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat dateFormat_2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public Integer getNoNotas(String date) throws HNotaDAOException {

		if (date == null || date.equals("")) {
			return 0;
		}

		Integer total = 0;
		try {

			total = jdbcTemplate.queryForObject(
					"SELECT count(*) as total FROM uno_mx_h_nota  WHERE  date (FD_FECHA_PUBLICACION) = '" + date + "'",
					new TotalRowMapper());

		} catch (Exception e) {

			logger.error(" Error getNoNotas HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}

		return total;
	}

	/**
	 * Gets the list items by filter.
	 *
	 * @param ItemsFilterRequest
	 * @return List<ItemsResponse>
	 * @throws HNotaDAOException
	 */
	public List<ItemsResponse> getListItemsByFilter(ItemsFilterRequest req) throws HNotaDAOException {
		List<ItemsResponse> lista = null;
		StringBuilder query = new StringBuilder();

		int limit = req.getLimit();
		int page = req.getPage();

		if (limit == 0 || page == 0) {
			return null;
		}

		int to = limit * page;
		int from = (to - limit) + 1;

		query.append("  SELECT * FROM (SELECT @rownum:=@rownum+1 rank , q.* ");
		query.append("  FROM ( ");
		query.append("		   SELECT n.FC_ID_CONTENIDO as id  ,");
		query.append(" 		   n.FC_TITULO AS title,");
        query.append("         n.FC_DESCRIPCION as description ,");
        query.append("         n.FD_FECHA_PUBLICACION as date   ,");
        query.append("         n.FC_ID_TIPO_NOTA as typeItem,");
        query.append("         n.FC_NOMBRE  AS url_item ,");
        query.append("         n.FC_ID_ESTATUS AS status  ,");
        query.append("         n.FC_IMAGEN as image   ,");
		query.append("         categoria.FC_ID_CATEGORIA as idCategories ,");
        query.append("         seccion.FC_DESCRIPCION as descSection,");
		query.append("         seccion.FC_ID_SECCION as idSection,");
        query.append(" 		   categoria.FC_DESCRIPCION as descCategories");
		query.append(" 		   FROM  uno_mx_h_nota N      ");
		query.append(" 		   LEFT JOIN uno_mx_c_categoria categoria on N.FC_ID_CATEGORIA = categoria.FC_ID_CATEGORIA   ");
		query.append("		   LEFT JOIN uno_mx_c_seccion seccion ON categoria.FC_ID_SECCION = seccion.FC_ID_SECCION ");
		//query.append("         LEFT JOIN uno_i_h_nota_usuario nota_usuario ON N.FC_ID_CONTENIDO = nota_usuario.FC_ID_CONTENIDO   ");
		//query.append("         LEFT JOIN uno_c_usuarios usuario ON nota_usuario.FC_ID_USUARIO = usuario.FC_ID_USUARIO ");
		query.append(" 		   WHERE  1=1   ");
		
		if (req.getType().equals("categoria")) {
			query.append("     AND categoria.FC_ID_CATEGORIA = '" + req.getId() + "' ");
		}else if (req.getType().equals("seccion")) {
			query.append("     AND seccion.FC_ID_SECCION = '" + req.getId() + "' ");
		}
		
		if (req.getAuthor() != null && !req.getAuthor().equals(""))
			query.append(" 	   AND usuario.FC_NOMBRE = '" + req.getAuthor() + "' ");


		if (req.getDateFrom() != null && !req.getDateFrom().equals(""))
			query.append(" 	    AND N.FD_FECHA_PUBLICACION >= '" + req.getDateFrom() + "' ");

		if (req.getDateTo() != null && !req.getDateTo().equals(""))
			query.append("      AND N.FD_FECHA_PUBLICACION <= '" + req.getDateTo() + "' ");

		if (req.getStatus() != null && !req.getStatus().equals(""))
			query.append("      AND N.FC_ID_ESTATUS = '" + req.getStatus() + "' ");

		query.append(" ORDER BY FD_FECHA_PUBLICACION DESC ) AS q ,(SELECT @rownum:=0) num ) r  ");
		query.append(" WHERE r.rank >= " + from + " AND r.rank <= " + to + " ");
		
		
		
		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<ItemsResponse>(ItemsResponse.class));

		} catch (Exception e) {

			logger.error(" Error findById HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}

		return lista;

	}

	/**
	 * Gets the list items by title.
	 *
	 * @param ItemsRequestByTitle
	 * @return List<ItemsResponse>
	 * @throws HNotaDAOException
	 */
	public List<ItemsResponse> getListItemsByTitle(ItemsRequestByTitle req) throws HNotaDAOException {
		List<ItemsResponse> lista = null;
		StringBuilder query = new StringBuilder();

		int limit = req.getLimit();
		int page = req.getPage();

		if (limit == 0 || page == 0) {
			return null;
		}

		int to = limit * page;
		int from = (to - limit) + 1;

		query.append("  SELECT * FROM (SELECT @rownum:=@rownum+1 rank , q.* ");
		query.append("  FROM ( ");
		query.append(" 		SELECT  n.FC_ID_CONTENIDO as id  ,");
		query.append(" 		   n.FC_TITULO AS title,");
        query.append("         n.FC_DESCRIPCION as description ,");
        query.append("         n.FD_FECHA_PUBLICACION as date   ,");
        query.append("         n.FC_ID_TIPO_NOTA as typeItem,");
        query.append("         n.FC_NOMBRE  AS url_item ,");
        query.append("         n.FC_ID_ESTATUS AS status  ,");
        query.append("         n.FC_IMAGEN as image   ,");
		query.append("         categoria.FC_ID_CATEGORIA as idCategories ,");
        query.append("         seccion.FC_DESCRIPCION as descSection,");
		query.append("         seccion.FC_ID_SECCION as idSection,");
        query.append(" 		   categoria.FC_DESCRIPCION as descCategories");
		query.append(" 		   FROM  uno_mx_h_nota N      ");
		query.append(" 		   LEFT JOIN uno_mx_c_categoria categoria on N.FC_ID_CATEGORIA = categoria.FC_ID_CATEGORIA   ");
		query.append("		   LEFT JOIN uno_mx_c_seccion seccion ON categoria.FC_ID_SECCION = seccion.FC_ID_SECCION ");
		//query.append(" 		   LEFT JOIN uno_i_h_nota_usuario ihNotaUsuario ON N.FC_ID_CONTENIDO = ihNotaUsuario.FC_ID_CONTENIDO ");
		query.append(" 		   WHERE  1=1   ");
		
		if (req.getType().equals("categoria")) {
			query.append("    	AND categoria.FC_ID_CATEGORIA = '" + req.getId() + "' ");
		}else if (req.getType().equals("seccion")) {
			query.append("   	AND seccion.FC_ID_SECCION = '" + req.getId() + "' ");
		}
		
		if (req.getAuthor() != null && !req.getAuthor().equals("")) {
			query.append("   	AND ihNotaUsuario.FC_ID_CATEGORIA = '" + req.getId() + "' ");
		}

		if (req.getTitle() != null && !req.getTitle().equals(""))
			query.append(" 		AND N.FC_TITULO LIKE '%" + req.getTitle() + "%' ");

		if (req.getStatus() != null && !req.getStatus().equals(""))
			query.append(" 		AND N.FC_ID_ESTATUS = '" + req.getStatus() + "' ");

		
		query.append(" ORDER BY FD_FECHA_PUBLICACION DESC ) AS q ,(SELECT @rownum:=0) num ) r  ");
		query.append(" WHERE r.rank >= " + from + " AND r.rank <= " + to + " ");
		
		
		

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<ItemsResponse>(ItemsResponse.class));

		} catch (Exception e) {

			logger.error(" Error getListItemsByTitle HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}

		return lista;

	}

	/**
	 * Gets the list items.
	 *
	 * @param ItemsRequest
	 * @return List<ItemsResponse>
	 * @throws HNotaDAOException
	 */
	public List<ItemsResponse> getListItems(ItemsRequest req) throws HNotaDAOException {
		List<ItemsResponse> lista = null;
		StringBuilder query = new StringBuilder();

		int limit = req.getLimit();
		int page = req.getPage();

		if (limit == 0 || page == 0) {
			return null;
		}

		int to = limit * page;
		int from = (to - limit) + 1;

		query.append("  SELECT * FROM (SELECT @rownum:=@rownum+1 rank , q.* ");
		query.append("  FROM ( SELECT ");
		query.append("		   n.FC_ID_CONTENIDO as id  ,");
		query.append(" 		   n.FC_TITULO AS title,");
        query.append("         n.FC_DESCRIPCION as description ,");
        query.append("         n.FD_FECHA_PUBLICACION as date   ,");
        query.append("         n.FC_ID_TIPO_NOTA as typeItem,");
        query.append("         n.FC_NOMBRE  AS url_item ,");
        query.append("         n.FC_ID_ESTATUS AS status  ,");
        query.append("         n.FC_IMAGEN as image   ,");
		query.append("         categoria.FC_ID_CATEGORIA as idCategories ,");
        query.append("         seccion.FC_DESCRIPCION as descSection,");
		query.append("         seccion.FC_ID_SECCION as idSection,");
        query.append(" 		   categoria.FC_DESCRIPCION as descCategories");
		query.append(" 		   FROM  uno_mx_h_nota N      ");
		query.append(" 		   LEFT JOIN uno_mx_c_categoria categoria on N.FC_ID_CATEGORIA = categoria.FC_ID_CATEGORIA   ");
		query.append("		   LEFT JOIN uno_mx_c_seccion seccion ON categoria.FC_ID_SECCION = seccion.FC_ID_SECCION ");

		query.append(" 		   WHERE  1=1   ");
		
		if (req.getType().equals("categoria")) {
			query.append("    AND categoria.FC_ID_CATEGORIA = '" + req.getId() + "' ");
		}else if (req.getType().equals("seccion")) {
			query.append("    AND seccion.FC_ID_SECCION = '" + req.getId() + "' ");
		}
		
		if (req.getStatus() != null && !req.getStatus().equals(""))
			query.append(" AND N.FC_ID_ESTATUS = '" + req.getStatus() + "' ");

		query.append(" ORDER BY FD_FECHA_PUBLICACION DESC ) AS q ,(SELECT @rownum:=0) num ) r  ");
		query.append(" WHERE r.rank >= " + from + " AND r.rank <= " + to + " ");
		
		
		
		

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<ItemsResponse>(ItemsResponse.class));

		} catch (Exception e) {

			logger.error(" Error getListItems HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}

		return lista;

	}

	/**
	 * Find all HNota
	 *
	 * @return List<HNota>
	 * @throws HNotaDAOException
	 */
	public List<HNota> findAll() throws HNotaDAOException {
		List<HNota> lista = null;

		StringBuilder query = new StringBuilder();
	
		query.append("  SELECT FC_ID_CONTENIDO , ");
		query.append("  FC_ID_CATEGORIA , ");
		query.append("  FC_NOMBRE AS fcFriendlyUrl, ");
		query.append("  FC_TITULO , ");
		query.append("  FC_DESCRIPCION , ");
		query.append("  FC_ESCRIBIO , ");
		query.append("  FC_LUGAR , ");
		query.append("  FC_FUENTE , ");
		query.append("  FC_ID_TIPO_NOTA , ");
		query.append("  FC_IMAGEN_PRINCIPAL AS fcImagen , ");
		query.append("  FC_IMAGEN_PIE AS fcPieImagen, ");
		query.append("  FC_VIDEO_YOUTUBE , ");
		query.append("  FC_ID_VIDEO_CONTENT AS fcContentIdOoyala, ");
		query.append("  FC_ID_VIDEO_PLAYER  AS fcPlayerIdOoyala , ");
		query.append("  CL_GALERIA_IMAGENES AS clGaleria, ");
		query.append("  FC_INFOGRAFIA , ");
		query.append("  CL_RTF_CONTENIDO , ");
		query.append("  FD_FECHA_PUBLICACION , ");
		query.append("  FD_FECHA_MODIFICACION , ");
		query.append("  FC_TAGS , ");
		query.append("  FC_KEYWORDS , ");
		query.append("  FI_BAN_INFINITO_HOME , ");
		query.append("  FI_BAN_VIDEO_VIRAL , ");
		query.append("  FI_BAN_NO_TE_LO_PIERDAS , ");
		query.append("  FI_BAN_PATROCINIO , ");
		query.append("  FC_PATROCINIO_BACKGROUND , ");
		query.append("  FC_PATROCINIO_COLOR_TEXTO , ");
		query.append("  FC_PAIS_REGISTRO , ");
		query.append("  FC_PCODE AS fcIdPcode, ");
		query.append("  FC_PLACE_GALLERY , ");
		query.append("  FC_SOURCE_VIDEO AS fcSourceOoyala , ");
		query.append("  FC_ALTERNATE_TEXT AS fcAlternativeTextOoyala , ");
		query.append("  FC_DURATION AS fcDurationOoyala  , ");
		query.append("  FC_FILE_SIZE AS fcFileSizeOoyala ");
		query.append("  FROM uno_mx_n_nota ");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<HNota>(HNota.class));

		} catch (Exception e) {

			logger.error(" Error findAll HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}

		return lista;
	}

	/**
	 * Delete.
	 *
	 * @param String
	 *            id FC_ID_CONTENIDO
	 * @throws HNotaDAOException
	 */
	public void delete(String id) throws HNotaDAOException {

		logger.info("--- Delete  [HNotaDAO] ---- ");

		StringBuilder query = new StringBuilder();
		query.append(" DELETE FROM uno_mx_h_nota WHERE FC_ID_CONTENIDO ='" + id + "'");
		try {

			jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<HNota>(HNota.class));

		} catch (Exception e) {

			logger.error(" Error Delete HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}
	}

	/**
	 * Find by id.
	 *
	 * @param String
	 *            FC_ID_CONTENIDO
	 * @return HNota
	 * @throws HNotaDAOException
	 *             the h nota DAO exception
	 */
	public HNota findById(String id) throws HNotaDAOException {
		logger.info("--- findById  [HNotaDAO] ---- ");

		List<HNota> lista = null;

		StringBuilder query = new StringBuilder();
		query.append("  SELECT FC_ID_CONTENIDO , ");
		query.append("  FC_ID_CATEGORIA , ");
		query.append("  FC_NOMBRE AS fcFriendlyUrl, ");
		query.append("  FC_TITULO , ");
		query.append("  FC_DESCRIPCION , ");
		query.append("  FC_ESCRIBIO , ");
		query.append("  FC_LUGAR , ");
		query.append("  FC_FUENTE , ");
		query.append("  FC_ID_TIPO_NOTA , ");
		query.append("  FC_IMAGEN_PRINCIPAL AS fcImagen , ");
		query.append("  FC_IMAGEN_PIE AS fcPieImagen, ");
		query.append("  FC_VIDEO_YOUTUBE , ");
		query.append("  FC_ID_VIDEO_CONTENT AS fcContentIdOoyala, ");
		query.append("  FC_ID_VIDEO_PLAYER  AS fcPlayerIdOoyala , ");
		query.append("  CL_GALERIA_IMAGENES AS clGaleria, ");
		query.append("  FC_INFOGRAFIA , ");
		query.append("  CL_RTF_CONTENIDO , ");
		query.append("  FD_FECHA_PUBLICACION , ");
		query.append("  FD_FECHA_MODIFICACION , ");
		query.append("  FC_TAGS , ");
		query.append("  FC_KEYWORDS , ");
		query.append("  FI_BAN_INFINITO_HOME , ");
		query.append("  FI_BAN_VIDEO_VIRAL , ");
		query.append("  FI_BAN_NO_TE_LO_PIERDAS , ");
		query.append("  FI_BAN_PATROCINIO , ");
		query.append("  FC_PATROCINIO_BACKGROUND , ");
		query.append("  FC_PATROCINIO_COLOR_TEXTO , ");
		query.append("  FC_PAIS_REGISTRO , ");
		query.append("  FC_PCODE AS fcIdPcode, ");
		query.append("  FC_PLACE_GALLERY , ");
		query.append("  FC_SOURCE_VIDEO AS fcSourceOoyala , ");
		query.append("  FC_ALTERNATE_TEXT AS fcAlternativeTextOoyala , ");
		query.append("  FC_DURATION AS fcDurationOoyala  , ");
		query.append("  FC_FILE_SIZE AS fcFileSizeOoyala ");
		query.append("  FROM uno_mx_h_nota ");
		query.append("  WHERE FC_ID_CONTENIDO ='" + id + "'");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<HNota>(HNota.class));

		} catch (Exception e) {

			logger.error(" Error findById HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}

		if (lista.isEmpty() || lista == null) {
			return null;
		}

		return lista.get(0);

	}

	/**
	 * Insert.
	 *
	 * @param NNota
	 * @return int
	 * @throws HNotaDAOException
	 */
	public int insert(NNota nota) throws HNotaDAOException {

		logger.info("--- insert  [HNotaDAO] ---- ");
		
		int rows = 0;
		String empty = "";
		StringBuilder query = new StringBuilder();
		query.append(" INSERT INTO uno_mx_h_nota ");
		query.append(" (FC_ID_CONTENIDO, ");
		query.append(" FC_ID_CATEGORIA, ");
		query.append(" FC_NOMBRE, ");
		query.append(" FC_TITULO, ");
		query.append(" FC_DESCRIPCION, ");
		query.append(" FC_ESCRIBIO, ");
		query.append(" FC_LUGAR, ");
		query.append(" FC_FUENTE, ");
		query.append(" FC_ID_TIPO_NOTA, ");
		query.append(" FC_IMAGEN_PRINCIPAL, ");
		query.append(" FC_IMAGEN_PIE, ");
		query.append(" FC_VIDEO_YOUTUBE, ");
		query.append(" FC_ID_VIDEO_CONTENT, ");
		query.append(" FC_ID_VIDEO_PLAYER, ");
		query.append(" CL_GALERIA_IMAGENES, ");
		
		query.append(" CL_RTF_CONTENIDO, ");
		query.append(" FD_FECHA_PUBLICACION, ");
		query.append(" FD_FECHA_MODIFICACION, ");
		
		query.append(" FC_KEYWORDS, ");
		query.append(" FI_BAN_INFINITO_HOME, ");
		query.append(" FC_PCODE, ");
		
		query.append(" FC_PLACE_GALLERY, ");
		query.append(" FC_INFOGRAFIA, ");
		query.append(" FC_TAGS, ");
		query.append(" FI_BAN_VIDEO_VIRAL, ");
		query.append(" FI_BAN_NO_TE_LO_PIERDAS, ");
		query.append(" FI_BAN_PATROCINIO, ");
		query.append(" FI_BAN_SITEMAP, ");
		query.append(" FC_PATROCINIO_BACKGROUND, ");
		query.append(" FC_PATROCINIO_COLOR_TEXTO, ");
		
		query.append(" FC_PAIS_REGISTRO, ");
		
		query.append(" FC_SOURCE_VIDEO, ");
		query.append(" FC_ALTERNATE_TEXT, ");
		query.append(" FC_DURATION, ");
		query.append(" FC_FILE_SIZE) ");
		query.append(" VALUES ");
		query.append(" (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ");

		try {
			rows = jdbcTemplate.update(query.toString(),
					nota.getFcIdContenido(),
					nota.getFcIdCategoria(),
					nota.getFcFriendlyUrl(),
					nota.getFcTitulo(),
					nota.getFcDescripcion(),
					nota.getFcEscribio(),
					nota.getFcLugar(),
					nota.getFcFuente(),
					nota.getFcIdTipoNota(),
					nota.getFcImagen(),
					nota.getFcPieImagen(),
					nota.getFcVideoYoutube(),
					nota.getFcContentIdOoyala(),
					nota.getFcPlayerIdOoyala(),
					nota.getClGaleria(),
					nota.getClRtfContenido(),
					dateFormat.format(new Date()),
					dateFormat.format(new Date()),
					nota.getFcKeywords(),
					nota.getFiBanInfinitoHome(),
					nota.getFcIdPcode(),
					empty,
					empty,
					empty,
					0,
					0,
					0,
					0,
					empty,
					empty,
					empty,
					nota.getFcSourceOoyala(),
					nota.getFcAlternativeTextOoyala(),
					nota.getFcDurationOoyala(),
					nota.getFcFileSizeOoyala());

		} catch (Exception e) {

			logger.error(" Error al insertar HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}

		return rows;

	}

	public int update(NNota nota) throws HNotaDAOException {

		logger.info("--- update  [HNotaDAO] ---- ");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int rows = 0;
		String empty = "";
		StringBuilder query = new StringBuilder();

		query.append(" UPDATE uno_mx_h_nota SET ");
		 query.append(" FC_ID_CATEGORIA = ? , "); 
		 query.append(" FC_NOMBRE = ? , "); 
		 query.append(" FC_TITULO = ? , "); 
		 query.append(" FC_DESCRIPCION = ? , "); 
		 query.append(" FC_ESCRIBIO = ? , "); 
		 query.append(" FC_LUGAR = ? , "); 
		 query.append(" FC_FUENTE = ? , "); 
		 query.append(" FC_ID_TIPO_NOTA = ? , "); 
		 query.append(" FC_IMAGEN_PRINCIPAL = ? , "); 
		 query.append(" FC_IMAGEN_PIE = ? , "); 
		 query.append(" FC_VIDEO_YOUTUBE = ? , "); 
		 query.append(" FC_ID_VIDEO_CONTENT = ? , "); 
		 query.append(" FC_ID_VIDEO_PLAYER = ? , "); 
		 query.append(" CL_GALERIA_IMAGENES = ? , "); 
		 query.append(" CL_RTF_CONTENIDO = ? , "); 
		 query.append(" FD_FECHA_MODIFICACION = '"+dateFormat.format(new Date())+"' , "); 
		 query.append(" FC_KEYWORDS = ? , "); 
		 query.append(" FI_BAN_INFINITO_HOME = ? , "); 
		
		 query.append(" FC_PCODE = ? , "); 
		 query.append(" FC_INFOGRAFIA = ? , "); 
		 query.append(" FC_TAGS = ? , "); 
		 query.append(" FI_BAN_VIDEO_VIRAL = ? , "); 
		 query.append(" FI_BAN_NO_TE_LO_PIERDAS = ? , "); 
		 query.append(" FI_BAN_PATROCINIO = ? , "); 
		 query.append(" FC_PATROCINIO_BACKGROUND = ? , "); 
		 query.append(" FC_PATROCINIO_COLOR_TEXTO = ? , "); 
		 query.append(" FI_BAN_SITEMAP = ? , "); 
		 query.append(" FC_PAIS_REGISTRO = ? , ");
		 query.append(" FC_PLACE_GALLERY = ? , "); 
		 query.append(" FC_SOURCE_VIDEO = ? , "); 
		 query.append(" FC_ALTERNATE_TEXT = ? , "); 
		 query.append(" FC_DURATION = ? , "); 
		 query.append(" FC_FILE_SIZE = ?   "); 
		 query.append(" WHERE FC_ID_CONTENIDO = ?  "); 

		try {
			
			
			
			rows = jdbcTemplate.update(query.toString(),
					nota.getFcIdCategoria(),
					nota.getFcFriendlyUrl(),
					nota.getFcTitulo(),
					nota.getFcDescripcion(),
					nota.getFcEscribio(),
					nota.getFcLugar(),
					nota.getFcFuente(),
					nota.getFcIdTipoNota(),
					nota.getFcImagen(),
					nota.getFcPieImagen(),
					nota.getFcVideoYoutube(),
					nota.getFcContentIdOoyala(),
					nota.getFcPlayerIdOoyala(),
					nota.getClGaleria(),
					nota.getClRtfContenido(),
					
					nota.getFcKeywords(),
					nota.getFiBanInfinitoHome(),
					nota.getFcIdPcode(),
					
					empty,
					empty,
					0,
					0,
					0,
					empty,
					empty,
					0,
					empty,
					empty,
					
					nota.getFcSourceOoyala(),
					nota.getFcAlternativeTextOoyala(),
					nota.getFcDurationOoyala(),
					nota.getFcFileSizeOoyala()
					,nota.getFcIdContenido());


		} catch (Exception e) {

			logger.error(" Error update HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}

		return rows;

	}
	
	


	
	



}
