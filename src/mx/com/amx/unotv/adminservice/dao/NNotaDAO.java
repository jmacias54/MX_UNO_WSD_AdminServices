package mx.com.amx.unotv.adminservice.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.dao.exception.NNotaDAOException;
import mx.com.amx.unotv.adminservice.model.NNota;
import mx.com.amx.unotv.adminservice.model.response.ItemsResponse;



// TODO: Auto-generated Javadoc
/**
 * The Class NNotaDAO.
 *
 * @author Jesus A. Macias Benitez
 */
public class NNotaDAO {
	
	/** The logger. */
	private Logger logger = Logger.getLogger(NNotaDAO.class);
	
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	
	public int delete(String idContenido) throws NNotaDAOException {

		int rows = 0;

		try {

			rows = jdbcTemplate.update(" DELETE FROM uno_mx_n_nota WHERE  FC_ID_CONTENIDO = ? ", idContenido);

		} catch (Exception e) {

			logger.error(" Error delete  N-NOTA [DAO] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		return rows;
	}
	
	public NNota findById(String id) throws NNotaDAOException {
		logger.info("--- findById  [NNotaDAO] ---- ");

		List<NNota> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT FC_ID_CONTENIDO, ");
		query.append(" FC_ID_CATEGORIA , ");
		query.append(" FC_NOMBRE AS fcFriendlyUrl , ");
		query.append(" FC_TITULO , ");
		query.append(" FC_DESCRIPCION , ");
		query.append(" FC_ESCRIBIO , ");
		query.append(" FC_LUGAR , ");
		query.append(" FC_FUENTE , ");
		query.append(" FC_ID_TIPO_NOTA , ");
		query.append(" FC_IMAGEN_PRINCIPAL AS fcImagen , ");
		query.append(" FC_IMAGEN_PIE AS fcPieImagen , ");
		query.append(" FC_VIDEO_YOUTUBE , ");
		query.append(" FC_ID_VIDEO_CONTENT AS fcContentIdOoyala , ");
		query.append(" FC_ID_VIDEO_PLAYER AS fcPlayerIdOoyala, ");
		query.append(" CL_GALERIA_IMAGENES AS clGaleria , ");
		query.append(" FC_INFOGRAFIA , ");
		query.append(" CL_RTF_CONTENIDO , ");
		query.append(" FD_FECHA_PUBLICACION , ");
		query.append(" FD_FECHA_MODIFICACION , ");
		query.append(" FC_TAGS , ");
		query.append(" FC_KEYWORDS , ");
		query.append(" FI_BAN_INFINITO_HOME , ");
		query.append(" FI_BAN_VIDEO_VIRAL , ");
		query.append(" FI_BAN_NO_TE_LO_PIERDAS , ");
		query.append(" FI_BAN_PATROCINIO , ");
		query.append(" FC_PATROCINIO_BACKGROUND , ");
		query.append(" FC_PATROCINIO_COLOR_TEXTO , ");
		query.append(" FC_PAIS_REGISTRO , ");
		query.append(" FC_PCODE  AS fcIdPcode , ");
		query.append(" FC_PLACE_GALLERY , ");
		query.append(" FC_SOURCE_VIDEO AS fcSourceOoyala , ");
		query.append(" FC_ALTERNATE_TEXT AS fcAlternativeTextOoyala  , ");
		query.append(" FC_DURATION AS fcDurationOoyala , ");
		query.append(" FC_FILE_SIZE AS fcFileSizeOoyala  ");
		query.append(" FROM uno_mx_n_nota WHERE FC_ID_CONTENIDO ='" + id + "'");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<NNota>(NNota.class));

		} catch (Exception e) {

			logger.error(" Error findById NNota [DAO] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		if (lista.isEmpty() || lista == null) {
			return null;
		}

		return lista.get(0);

	}
	
	/**
	 * Gets the list items by magazine.
	 *
	 * @param String idMagazine
	 * @return List<ItemsResponse>
	 * @throws NNotaDAOException 
	 */
	public List<ItemsResponse> getListItemsByMagazine(String idMagazine) throws NNotaDAOException {
		List<ItemsResponse> lista = null;
		StringBuilder query = new StringBuilder();
		
		query.append("  SELECT r.rank, ");
		query.append(" 		r.FC_ID_CONTENIDO as id ");
		query.append(" 		,r.FC_TITULO AS title ");
		query.append("      ,r.FC_DESCRIPCION as description ");
		query.append("      ,r.FD_FECHA_PUBLICACION as date ");
		query.append("      ,r.FC_ID_TIPO_NOTA as typeItem ");
		query.append("      ,seccion.FC_ID_SECCION as idSection ");
		query.append("      ,categoria.FC_ID_CATEGORIA as idCategories ");
		query.append("      ,seccion.FC_DESCRIPCION as descSection ");
		query.append("      ,categoria.FC_DESCRIPCION as descCategories ");
		query.append("     ,r.FC_IMAGEN as image  ");
		query.append("     , r.FC_NOMBRE AS url_item ");
		query.append("     , r.FC_ID_ESTATUS AS status ");
		query.append("  FROM (SELECT @rownum:=@rownum+1 rank, n.*       ");
		query.append(" 		   FROM  uno_mx_n_nota N , (SELECT @rownum:=0) r    ");
		query.append(" 		   WHERE  1=1   ");
		query.append("         ORDER BY FD_FECHA_PUBLICACION DESC ) AS r  ");
		query.append(" INNER JOIN uno_mx_c_categoria categoria on r.FC_ID_CATEGORIA = categoria.FC_ID_CATEGORIA ");
		query.append(" INNER JOIN uno_mx_c_seccion seccion ON categoria.FC_ID_SECCION = seccion.FC_ID_SECCION ");
		query.append(" INNER JOIN uno_mx_i_nota_magazine nota_magazine ON r.FC_ID_CONTENIDO = nota_magazine.FC_ID_CONTENIDO ");
		query.append(" INNER JOIN uno_mx_c_magazine magazine ON nota_magazine.FC_ID_MAGAZINE = magazine.FC_ID_MAGAZINE ");
		query.append(" WHERE nota_magazine.FC_ID_CONTENIDO = '"+idMagazine+"' ");
		
	
		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<ItemsResponse>(ItemsResponse.class));

		} catch (Exception e) {

			logger.error(" Error getListItems HNota [DAO] ", e);

			throw new NNotaDAOException(e.getMessage());

		}
		
		return lista ;
		
	}
	
	
	
	
	/**
	 * Insert.
	 *
	 * @param NNota
	 * @return the int
	 * @throws NNotaDAOException 
	 */
	public int insert(NNota nota) throws NNotaDAOException {
		logger.info("--- insert  [NNotaDAO] ---- ");
		
		int rows = 0;
		String empty = "";
		StringBuilder query = new StringBuilder();
		
		query.append(" INSERT INTO uno_mx_n_nota (FC_ID_CONTENIDO, ");
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
		
		query.append(" FC_INFOGRAFIA, ");
		query.append(" FC_TAGS, ");
		query.append(" FI_BAN_VIDEO_VIRAL, ");
		query.append(" FI_BAN_NO_TE_LO_PIERDAS, ");
		query.append(" FI_BAN_PATROCINIO, ");
		query.append(" FC_PATROCINIO_BACKGROUND, ");
		query.append(" FC_PATROCINIO_COLOR_TEXTO, ");
		query.append(" FC_PAIS_REGISTRO, ");
		query.append(" FC_PLACE_GALLERY, ");
		
		query.append(" FC_PCODE, ");
		query.append(" FC_SOURCE_VIDEO, ");
		query.append(" FC_ALTERNATE_TEXT, ");
		query.append(" FC_DURATION, ");
		query.append(" FC_FILE_SIZE ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ");
		
		
		try {
		
			rows = jdbcTemplate.update( query.toString() ,   
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
					empty,
					empty,
					0,
					0,
					0,
					empty,
					empty,
					empty,
					empty,
					nota.getFcIdPcode(),
					nota.getFcSourceOoyala(),
					nota.getFcAlternativeTextOoyala(),
					nota.getFcDurationOoyala(),
					nota.getFcFileSizeOoyala());

		} catch (Exception e) {

			logger.error(" Error al insertar  N-NOTA [DAO] ", e);

			throw new NNotaDAOException(e.getMessage());

		}
		
		return rows;
		
	}
	

	public int update(NNota nota) throws NNotaDAOException {
		logger.info("--- update  [NNotaDAO] ---- ");
		
		int rows = 0;
		String empty = "";
		StringBuilder query = new StringBuilder();
		 query.append(" UPDATE uno_mx_n_nota SET  ");
		 query.append(" FC_ID_CATEGORIA = ? ,  ");
		 query.append(" FC_NOMBRE = ? ,  ");
		 query.append(" FC_TITULO = ? ,  ");
		 query.append(" FC_DESCRIPCION = ? ,  ");
		 query.append(" FC_ESCRIBIO = ? ,  ");
		 query.append(" FC_LUGAR = ? ,  ");
		 query.append(" FC_FUENTE = ? ,  ");
		 query.append(" FC_ID_TIPO_NOTA = ? ,  ");
		 query.append(" FC_IMAGEN_PRINCIPAL = ? ,  ");
		 query.append(" FC_IMAGEN_PIE = ? ,  ");
		 query.append(" FC_VIDEO_YOUTUBE = ? ,  ");
		 query.append(" FC_ID_VIDEO_CONTENT = ? ,  ");
		 query.append(" FC_ID_VIDEO_PLAYER = ? ,  ");
		 query.append(" CL_GALERIA_IMAGENES = ? ,  ");
		 query.append(" CL_RTF_CONTENIDO = ? ,  ");
		 //query.append(" FD_FECHA_PUBLICACION = ? ,  ");
		 query.append(" FD_FECHA_MODIFICACION = ? ,  ");
		 query.append(" FC_KEYWORDS = ? ,  ");
		 query.append(" FI_BAN_INFINITO_HOME = ? ,  ");
		
		 query.append(" FC_INFOGRAFIA = ? ,  ");
		 query.append(" FC_TAGS = ? ,  ");
		 query.append(" FI_BAN_VIDEO_VIRAL = ? ,  ");
		 query.append(" FI_BAN_NO_TE_LO_PIERDAS = ? ,  ");
		 query.append(" FI_BAN_PATROCINIO = ? ,  ");
		 query.append(" FC_PATROCINIO_BACKGROUND = ? ,  ");
		 query.append(" FC_PATROCINIO_COLOR_TEXTO = ? ,  ");
		 query.append(" FC_PAIS_REGISTRO = ? ,  ");
		 query.append(" FC_PLACE_GALLERY = ? ,  ");
		 
		 query.append(" FC_PCODE = ? ,  ");
		 query.append(" FC_SOURCE_VIDEO = ? ,  ");
		 query.append(" FC_ALTERNATE_TEXT = ? ,  ");
		 query.append(" FC_DURATION = ? ,  ");
		 query.append(" FC_FILE_SIZE = ? ");
		 query.append(" WHERE FC_ID_CONTENIDO = ? ");
		
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
					dateFormat.format(new Date()),
					nota.getFcKeywords(),
					nota.getFiBanInfinitoHome(),
					empty,
					empty,
					0,
					0,
					0,
					empty,
					empty,
					empty,
					empty,
					nota.getFcIdPcode(),
					nota.getFcSourceOoyala(),
					nota.getFcAlternativeTextOoyala(),
					nota.getFcDurationOoyala(),
					nota.getFcFileSizeOoyala(),
					nota.getFcIdContenido());

		} catch (Exception e) {

			logger.error(" Error al update  N-NOTA [DAO] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		return rows;

	}



}
