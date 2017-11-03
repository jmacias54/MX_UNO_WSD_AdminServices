package mx.com.amx.unotv.adminservice.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.dao.exception.HNotaDAOException;

import mx.com.amx.unotv.adminservice.model.NNota;

public class HNotaDAO {
	
	
private Logger logger = Logger.getLogger(HNotaDAO.class);
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
public int insert(NNota nota) throws HNotaDAOException {
		
		logger.info("--- insert  [HNotaDAO] ---- ");
		int rows = 0;
		
		try {
		rows = jdbcTemplate.update( " INSERT INTO UNO_H_NOTA " +
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
				 " FC_ID_ESTATUS) " +
				 " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,) " ,
				nota.getFcContentIdOoyala(), nota.getFcIdCategoria(), nota.getFcFriendlyUrl(), nota.getFcTitulo(), nota.getFcEscribio(),
				nota.getFcLugar(),nota.getFcFuente(),nota.getFcIdTipoNota(),nota.getFcImagen(),nota.getFcVideoYoutube(),nota.getFcContentIdOoyala(),
				nota.getFcPlayerIdOoyala(),nota.getFcIdPcode(),nota.getFcSourceOoyala(),nota.getFcAlternativeTextOoyala(),nota.getFcDurationOoyala(),
				nota.getFcFileSizeOoyala(),nota.getClGaleria(),nota.getClRtfContenido(),nota.getFdFechaPublicacion(),nota.getFdFechaModificacion(),
				nota.getFcKeywords(),nota.getFiBanInfinitoHome(),nota.getFiBanMsn(),nota.getFiBanOtros(),nota.getFcIdEstatus());

		} catch (Exception e) {

			logger.error(" Error al insertar HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}
		
		return rows;
		
	}

}
