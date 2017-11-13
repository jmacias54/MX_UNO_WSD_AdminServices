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
		query.append("     , r.FC_FRIENDLY_URL AS url_item ");
		query.append("     , r.FC_ID_ESTATUS AS status ");
		query.append("  FROM (SELECT @rownum:=@rownum+1 rank, n.*       ");
		query.append(" 		   FROM  UNO_H_NOTA N , (SELECT @rownum:=0) r    ");
		query.append(" 		   WHERE  1=1   ");
		query.append("         ORDER BY FD_FECHA_PUBLICACION DESC ) AS r  ");
		query.append(" INNER JOIN uno_c_categoria categoria on r.FC_ID_CATEGORIA = categoria.FC_ID_CATEGORIA ");
		query.append(" INNER JOIN uno_c_seccion seccion ON categoria.FC_ID_SECCION = seccion.FC_ID_SECCION ");
		query.append(" INNER JOIN uno_i_nota_magazine nota_magazine ON r.FC_ID_CONTENIDO = nota_magazine.FC_ID_CONTENIDO ");
		query.append(" INNER JOIN uno_c_magazine magazine ON nota_magazine.FC_ID_MAGAZINE = magazine.FC_ID_MAGAZINE ");
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

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			
			
			
		rows = jdbcTemplate.update( " INSERT INTO UNO_N_NOTA " +
				 " (FC_ID_CONTENIDO, " +
				 " FC_ID_CATEGORIA, " +
				 " FC_FRIENDLY_URL, " +
				 " FC_TITULO, " +
				 " FC_DESCRIPCION, " +
				 " FC_ESCRIBIO, " +
				 " FC_LUGAR, " +
				 " FC_FUENTE, " +
				 " FC_ID_TIPO_NOTA, " +
				 " FC_IMAGEN, " +
				 " FC_VIDEO_YOUTUBE, " +
				 " FC_CONTENT_ID_OOYALA, " +
				 " FC_PLAYER_ID_OOYALA, " +
				 " FC_ID_PCODE, " +
				 " FC_SOURCE_OOYALA, " +
				 " FC_ALTERNATIVE_TEXT_OOYALA, " +
				 " FC_DURATION_OOYALA, " +
				 " FC_FILE_SIZE_OOYALA, " +
				 " CL_GALERIA, " +
				 " CL_RTF_CONTENIDO, " +
				 " FD_FECHA_PUBLICACION, " +
				 " FD_FECHA_MODIFICACION, " +
				 " FC_KEYWORDS, " +
				 " FI_BAN_INFINITO_HOME, " +
				 " FI_BAN_MSN, " +
				 " FI_BAN_OTROS, " +
				 " FC_ID_USUARIO, " +
				 " FC_ID_ESTATUS) " +
				 " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) " ,
				nota.getFcIdContenido(), nota.getFcIdCategoria(), nota.getFcFriendlyUrl(), nota.getFcTitulo(), nota.getFcDescripcion(), nota.getFcEscribio(),
				nota.getFcLugar(),nota.getFcFuente(),nota.getFcIdTipoNota(),nota.getFcImagen(),nota.getFcVideoYoutube(),nota.getFcContentIdOoyala(),
				nota.getFcPlayerIdOoyala(),nota.getFcIdPcode(),nota.getFcSourceOoyala(),nota.getFcAlternativeTextOoyala(),nota.getFcDurationOoyala(),
				nota.getFcFileSizeOoyala(),nota.getClGaleria(),nota.getClRtfContenido(), dateFormat.format(new Date()), dateFormat.format(new Date()),
				nota.getFcKeywords(),nota.getFiBanInfinitoHome(),nota.getFiBanMsn(),nota.getFiBanOtros(),nota.getFcIdUsuario(),nota.getFcIdEstatus());

		} catch (Exception e) {

			logger.error(" Error al insertar  N-NOTA [DAO] ", e);

			throw new NNotaDAOException(e.getMessage());

		}
		
		return rows;
		
	}
	
	
	public int update(NNota nota) throws NNotaDAOException {
		
		logger.info("--- update  [NNotaDAO] ---- ");
		int rows = 0;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			
			rows = jdbcTemplate.update(" UPDATE UNO_N_NOTA " +
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
					" FC_ID_ESTATUS  = ?, "
					+ "FC_ID_USUARIO = ? "+
					" WHERE FC_ID_CONTENIDO = ? ",
					nota.getFcIdCategoria(), nota.getFcFriendlyUrl(), nota.getFcTitulo(),
					nota.getFcDescripcion(), nota.getFcEscribio(), nota.getFcLugar(), nota.getFcFuente(),
					nota.getFcIdTipoNota(), nota.getFcImagen(), nota.getFcVideoYoutube(), nota.getFcContentIdOoyala(),
					nota.getFcPlayerIdOoyala(), nota.getFcIdPcode(), nota.getFcSourceOoyala(),
					nota.getFcAlternativeTextOoyala(), nota.getFcDurationOoyala(), nota.getFcFileSizeOoyala(),
					nota.getClGaleria(), nota.getClRtfContenido(), dateFormat.format(new Date()),
					nota.getFcKeywords(), nota.getFiBanInfinitoHome(),
					nota.getFiBanMsn(), nota.getFiBanOtros(), nota.getFcIdEstatus(),nota.getFcIdUsuario(),nota.getFcIdContenido());

		} catch (Exception e) {

			logger.error(" Error al update  N-NOTA [DAO] ", e);

			throw new NNotaDAOException(e.getMessage());

		}
		
		return rows;
		
	}



}
