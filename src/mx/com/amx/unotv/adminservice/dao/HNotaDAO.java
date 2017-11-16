package mx.com.amx.unotv.adminservice.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.dao.exception.HNotaDAOException;
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
        query.append("         n.FC_FRIENDLY_URL  AS url_item ,");
        query.append("         n.FC_ID_ESTATUS AS status  ,");
        query.append("         n.FC_IMAGEN as image   ,");
		query.append("         categoria.FC_ID_CATEGORIA as idCategories ,");
        query.append("         seccion.FC_DESCRIPCION as descSection,");
		query.append("         seccion.FC_ID_SECCION as idSection,");
        query.append(" 		   categoria.FC_DESCRIPCION as descCategories");
		query.append(" 		   FROM  UNO_H_NOTA N      ");
		query.append(" 		   LEFT JOIN uno_c_categoria categoria on N.FC_ID_CATEGORIA = categoria.FC_ID_CATEGORIA   ");
		query.append("		   LEFT JOIN uno_c_seccion seccion ON categoria.FC_ID_SECCION = seccion.FC_ID_SECCION ");
		query.append("         LEFT JOIN uno_i_h_nota_usuario nota_usuario ON N.FC_ID_CONTENIDO = nota_usuario.FC_ID_CONTENIDO   ");
		query.append("         LEFT JOIN uno_c_usuarios usuario ON nota_usuario.FC_ID_USUARIO = usuario.FC_ID_USUARIO ");
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
        query.append("         n.FC_FRIENDLY_URL  AS url_item ,");
        query.append("         n.FC_ID_ESTATUS AS status  ,");
        query.append("         n.FC_IMAGEN as image   ,");
		query.append("         categoria.FC_ID_CATEGORIA as idCategories ,");
        query.append("         seccion.FC_DESCRIPCION as descSection,");
		query.append("         seccion.FC_ID_SECCION as idSection,");
        query.append(" 		   categoria.FC_DESCRIPCION as descCategories");
		query.append(" 		   FROM  UNO_H_NOTA N      ");
		query.append(" 		   LEFT JOIN uno_c_categoria categoria on N.FC_ID_CATEGORIA = categoria.FC_ID_CATEGORIA   ");
		query.append("		   LEFT JOIN uno_c_seccion seccion ON categoria.FC_ID_SECCION = seccion.FC_ID_SECCION ");
		query.append(" 		   LEFT JOIN uno_i_h_nota_usuario ihNotaUsuario ON N.FC_ID_CONTENIDO = ihNotaUsuario.FC_ID_CONTENIDO ");
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
			query.append(" 		AND N.FC_TITULO = '" + req.getTitle() + "' ");

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
		query.append("  FROM ( ");
		query.append("		   n.FC_ID_CONTENIDO as id  ,");
		query.append(" 		   n.FC_TITULO AS title,");
        query.append("         n.FC_DESCRIPCION as description ,");
        query.append("         n.FD_FECHA_PUBLICACION as date   ,");
        query.append("         n.FC_ID_TIPO_NOTA as typeItem,");
        query.append("         n.FC_FRIENDLY_URL  AS url_item ,");
        query.append("         n.FC_ID_ESTATUS AS status  ,");
        query.append("         n.FC_IMAGEN as image   ,");
		query.append("         categoria.FC_ID_CATEGORIA as idCategories ,");
        query.append("         seccion.FC_DESCRIPCION as descSection,");
		query.append("         seccion.FC_ID_SECCION as idSection,");
        query.append(" 		   categoria.FC_DESCRIPCION as descCategories");
		query.append(" 		   FROM  UNO_H_NOTA N      ");
		query.append(" 		   LEFT JOIN uno_c_categoria categoria on N.FC_ID_CATEGORIA = categoria.FC_ID_CATEGORIA   ");
		query.append("		   LEFT JOIN uno_c_seccion seccion ON categoria.FC_ID_SECCION = seccion.FC_ID_SECCION ");

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
		query.append(" SELECT * FROM UNO_H_NOTA");

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
		query.append(" DELETE FROM UNO_H_NOTA WHERE FC_ID_CONTENIDO ='" + id + "'");
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
		query.append(" SELECT * FROM UNO_H_NOTA WHERE FC_ID_CONTENIDO ='" + id + "'");

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

		try {
			rows = jdbcTemplate.update(" INSERT INTO UNO_H_NOTA " + " (FC_ID_CONTENIDO, " + " FC_ID_CATEGORIA, "
					+ " FC_FRIENDLY_URL, " + " FC_TITULO, " + " FC_DESCRIPCION, " + " FC_ESCRIBIO, " + " FC_LUGAR, "
					+ " FC_FUENTE, " + " FC_ID_TIPO_NOTA, " + " FC_IMAGEN, " + " FC_VIDEO_YOUTUBE, "
					+ " FC_CONTENT_ID_OOYALA, " + " FC_PLAYER_ID_OOYALA, " + " FC_ID_PCODE, " + " FC_SOURCE_OOYALA, "
					+ " FC_ALTERNATIVE_TEXT_OOYALA, " + " FC_DURATION_OOYALA, " + " FC_FILE_SIZE_OOYALA, "
					+ " CL_GALERIA, " + " CL_RTF_CONTENIDO, " + " FD_FECHA_PUBLICACION, " + " FD_FECHA_MODIFICACION, "
					+ " FC_KEYWORDS, " + " FI_BAN_INFINITO_HOME, " + " FI_BAN_MSN, " + " FI_BAN_OTROS, "
					+ " FC_ID_ESTATUS) " + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ",
					nota.getFcIdContenido(), nota.getFcIdCategoria(), nota.getFcFriendlyUrl(), nota.getFcTitulo(),
					nota.getFcDescripcion(), nota.getFcEscribio(), nota.getFcLugar(), nota.getFcFuente(),
					nota.getFcIdTipoNota(), nota.getFcImagen(), nota.getFcVideoYoutube(), nota.getFcContentIdOoyala(),
					nota.getFcPlayerIdOoyala(), nota.getFcIdPcode(), nota.getFcSourceOoyala(),
					nota.getFcAlternativeTextOoyala(), nota.getFcDurationOoyala(), nota.getFcFileSizeOoyala(),
					nota.getClGaleria(), nota.getClRtfContenido(), dateFormat.format(new Date()),
					dateFormat.format(new Date()), nota.getFcKeywords(), nota.getFiBanInfinitoHome(),
					nota.getFiBanMsn(), nota.getFiBanOtros(), nota.getFcIdEstatus());

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

		try {
			
			
			
			rows = jdbcTemplate.update(" UPDATE uno_h_nota " +
					" SET  " +
					" FC_ID_CATEGORIA  = ?, "+
					" FC_FRIENDLY_URL  = ? , "+
					" FC_TITULO  = ?, "+
					" FC_DESCRIPCION  = ? , "+
					" FC_ESCRIBIO  = ?, "+
					" FC_LUGAR  = ? , "+
					" FC_FUENTE  = ? , "+
					" FC_ID_TIPO_NOTA  = ? , "+
					" FC_IMAGEN  = ?, "+
					" FC_VIDEO_YOUTUBE  = ?, "+
					" FC_CONTENT_ID_OOYALA  = ? , "+
					" FC_PLAYER_ID_OOYALA  = ?, "+
					" FC_ID_PCODE  = ?, "+
					" FC_SOURCE_OOYALA  = ?, "+
					" FC_ALTERNATIVE_TEXT_OOYALA  = ?, "+
					" FC_DURATION_OOYALA  = ?, "+
					" FC_FILE_SIZE_OOYALA  = ? , "+
					" CL_GALERIA  = ? , "+
					" CL_RTF_CONTENIDO  = ?, "+
					// " FD_FECHA_PUBLICACION  = ? , "+
					" FD_FECHA_MODIFICACION  = ? , "+
					" FC_KEYWORDS  = ? , "+
					" FI_BAN_INFINITO_HOME  = ? , "+
					" FI_BAN_MSN  = ? , "+
					" FI_BAN_OTROS  = ? , "+
					" FC_ID_ESTATUS  = ? "+
					" WHERE FC_ID_CONTENIDO = ? ",
					nota.getFcIdCategoria(), nota.getFcFriendlyUrl(), nota.getFcTitulo(),
					nota.getFcDescripcion(), nota.getFcEscribio(), nota.getFcLugar(), nota.getFcFuente(),
					nota.getFcIdTipoNota(), nota.getFcImagen(), nota.getFcVideoYoutube(), nota.getFcContentIdOoyala(),
					nota.getFcPlayerIdOoyala(), nota.getFcIdPcode(), nota.getFcSourceOoyala(),
					nota.getFcAlternativeTextOoyala(), nota.getFcDurationOoyala(), nota.getFcFileSizeOoyala(),
					nota.getClGaleria(), nota.getClRtfContenido(), dateFormat.format(new Date()),
					nota.getFcKeywords(), nota.getFiBanInfinitoHome(),
					nota.getFiBanMsn(), nota.getFiBanOtros(), nota.getFcIdEstatus(),nota.getFcIdContenido());


		} catch (Exception e) {

			logger.error(" Error update HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}

		return rows;

	}
	
	

	public int expire(NNota nota) throws HNotaDAOException {

		logger.info("--- expire  [HNotaDAO] ---- ");
	
		int rows = 0;

		try {
			
			
			rows = jdbcTemplate.update(" UPDATE uno_h_nota " +
					" SET  " +
					" FC_ID_CATEGORIA  = ?, "+
					" FC_FRIENDLY_URL  = ? , "+
					" FC_TITULO  = ?, "+
					" FC_DESCRIPCION  = ? , "+
					" FC_ESCRIBIO  = ?, "+
					" FC_LUGAR  = ? , "+
					" FC_FUENTE  = ? , "+
					" FC_ID_TIPO_NOTA  = ? , "+
					" FC_IMAGEN  = ?, "+
					" FC_VIDEO_YOUTUBE  = ?, "+
					" FC_CONTENT_ID_OOYALA  = ? , "+
					" FC_PLAYER_ID_OOYALA  = ?, "+
					" FC_ID_PCODE  = ?, "+
					" FC_SOURCE_OOYALA  = ?, "+
					" FC_ALTERNATIVE_TEXT_OOYALA  = ?, "+
					" FC_DURATION_OOYALA  = ?, "+
					" FC_FILE_SIZE_OOYALA  = ? , "+
					" CL_GALERIA  = ? , "+
					" CL_RTF_CONTENIDO  = ?, "+
					// " FD_FECHA_PUBLICACION  = ? , "+
					" FD_FECHA_MODIFICACION  = ? , "+
					" FC_KEYWORDS  = ? , "+
					" FI_BAN_INFINITO_HOME  = ? , "+
					" FI_BAN_MSN  = ? , "+
					" FI_BAN_OTROS  = ? , "+
					" FC_ID_ESTATUS  = ? "+
					" WHERE FC_ID_CONTENIDO = ? ",
					nota.getFcIdCategoria(), nota.getFcFriendlyUrl(), nota.getFcTitulo(),
					nota.getFcDescripcion(), nota.getFcEscribio(), nota.getFcLugar(), nota.getFcFuente(),
					nota.getFcIdTipoNota(), nota.getFcImagen(), nota.getFcVideoYoutube(), nota.getFcContentIdOoyala(),
					nota.getFcPlayerIdOoyala(), nota.getFcIdPcode(), nota.getFcSourceOoyala(),
					nota.getFcAlternativeTextOoyala(), nota.getFcDurationOoyala(), nota.getFcFileSizeOoyala(),
					nota.getClGaleria(), nota.getClRtfContenido(), dateFormat.format(new Date()),
					nota.getFcKeywords(), nota.getFiBanInfinitoHome(),
					nota.getFiBanMsn(), nota.getFiBanOtros(), "CAD",nota.getFcIdContenido());

		} catch (Exception e) {

			logger.error(" Error expire HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}

		return rows;

	}
	
	public int review(NNota nota) throws HNotaDAOException {

		logger.info("--- review  [HNotaDAO] ---- ");

		int rows = 0;

		try {

			
			rows = jdbcTemplate.update(" UPDATE uno_h_nota " +
					" SET  " +
					" FC_ID_CATEGORIA  = ?, "+
					" FC_FRIENDLY_URL  = ? , "+
					" FC_TITULO  = ?, "+
					" FC_DESCRIPCION  = ? , "+
					" FC_ESCRIBIO  = ?, "+
					" FC_LUGAR  = ? , "+
					" FC_FUENTE  = ? , "+
					" FC_ID_TIPO_NOTA  = ? , "+
					" FC_IMAGEN  = ?, "+
					" FC_VIDEO_YOUTUBE  = ?, "+
					" FC_CONTENT_ID_OOYALA  = ? , "+
					" FC_PLAYER_ID_OOYALA  = ?, "+
					" FC_ID_PCODE  = ?, "+
					" FC_SOURCE_OOYALA  = ?, "+
					" FC_ALTERNATIVE_TEXT_OOYALA  = ?, "+
					" FC_DURATION_OOYALA  = ?, "+
					" FC_FILE_SIZE_OOYALA  = ? , "+
					" CL_GALERIA  = ? , "+
					" CL_RTF_CONTENIDO  = ?, "+
					// " FD_FECHA_PUBLICACION  = ? , "+
					" FD_FECHA_MODIFICACION  = ? , "+
					" FC_KEYWORDS  = ? , "+
					" FI_BAN_INFINITO_HOME  = ? , "+
					" FI_BAN_MSN  = ? , "+
					" FI_BAN_OTROS  = ? , "+
					" FC_ID_ESTATUS  = ? "+
					" WHERE FC_ID_CONTENIDO = ? ",
					nota.getFcIdCategoria(), nota.getFcFriendlyUrl(), nota.getFcTitulo(),
					nota.getFcDescripcion(), nota.getFcEscribio(), nota.getFcLugar(), nota.getFcFuente(),
					nota.getFcIdTipoNota(), nota.getFcImagen(), nota.getFcVideoYoutube(), nota.getFcContentIdOoyala(),
					nota.getFcPlayerIdOoyala(), nota.getFcIdPcode(), nota.getFcSourceOoyala(),
					nota.getFcAlternativeTextOoyala(), nota.getFcDurationOoyala(), nota.getFcFileSizeOoyala(),
					nota.getClGaleria(), nota.getClRtfContenido(), dateFormat.format(new Date()),
					nota.getFcKeywords(), nota.getFiBanInfinitoHome(),
					nota.getFiBanMsn(), nota.getFiBanOtros(), "REV",nota.getFcIdContenido());

		} catch (Exception e) {

			logger.error(" Error review HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}

		return rows;

	}


}
