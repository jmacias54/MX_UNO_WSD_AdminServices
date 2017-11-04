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
import mx.com.amx.unotv.adminservice.model.response.ItemsResponse;
import mx.com.amx.unotv.adminservice.model.resquest.ItemsRequest;

public class HNotaDAO {
	
	
private Logger logger = Logger.getLogger(HNotaDAO.class);
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<ItemsResponse> getListItems(ItemsRequest req) throws HNotaDAOException {
		List<ItemsResponse> lista = null;
		StringBuilder query = new StringBuilder();
		
		int to = req.getLimit() * req.getPage();
		int from = (to - req.getPage()) + 1;
		
		query.append(" SELECT * FROM (SELECT @rownum:=@rownum+1 rank, n.*     ");
		query.append(" FROM  UNO_N_NOTA N , (SELECT @rownum:=0) r  ");
		query.append(" ORDER BY FD_FECHA_PUBLICACION DESC ) AS r ");
		query.append(" WHERE r.rank between ("+from+") AND ("+to+") ");
		
		if(!req.getId().equals("") || req.getId() != null)
		query.append(" AND r.FC_ID_CATEGORIA = '"+req.getId()+"' ");
		if(!req.getType().equals("") || req.getType() != null)
		query.append(" AND r.FC_ID_TIPO_NOTA = '"+req.getType()+"' ");
		
		query.append(" AND r.FC_ID_ESTATUS = "+req.getStatus()+" ");
		
		
		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<ItemsResponse>(ItemsResponse.class));

		} catch (Exception e) {

			logger.error(" Error findById HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}
		
		return lista ;
		
	}
	
	
	public List<HNota> findAll() throws HNotaDAOException {
		List<HNota> lista = null;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM UNO_H_NOTA");
		

		
		try {
			
			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<HNota>(HNota.class));
			
			
			} catch (Exception e) {

				logger.error(" Error findById HNota [DAO] ", e);

				throw new HNotaDAOException(e.getMessage());

			}
		
		
		return lista ;
	}
	
	
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

	public HNota findById(String id) throws HNotaDAOException {
		logger.info("--- findById  [HNotaDAO] ---- ");
		
		List<HNota> lista = null;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM UNO_H_NOTA WHERE FC_ID_CONTENIDO ='"+id+"'");
		

		
		try {
			
			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<HNota>(HNota.class));
			
			
			} catch (Exception e) {

				logger.error(" Error findById HNota [DAO] ", e);

				throw new HNotaDAOException(e.getMessage());

			}
		return lista.get(0) ;
		
	}
	
	

	public int insert(NNota nota) throws HNotaDAOException {
		
		logger.info("--- insert  [HNotaDAO] ---- ");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
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
				 " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) " ,
				nota.getFcIdContenido(), nota.getFcIdCategoria(), nota.getFcFriendlyUrl(), nota.getFcTitulo(), nota.getFcDescripcion(),nota.getFcEscribio(),
				nota.getFcLugar(),nota.getFcFuente(),nota.getFcIdTipoNota(),nota.getFcImagen(),nota.getFcVideoYoutube(),nota.getFcContentIdOoyala(),
				nota.getFcPlayerIdOoyala(),nota.getFcIdPcode(),nota.getFcSourceOoyala(),nota.getFcAlternativeTextOoyala(),nota.getFcDurationOoyala(),
				nota.getFcFileSizeOoyala(),nota.getClGaleria(),nota.getClRtfContenido(), dateFormat.format(new Date()), dateFormat.format(new Date()),
				nota.getFcKeywords(),nota.getFiBanInfinitoHome(),nota.getFiBanMsn(),nota.getFiBanOtros(),nota.getFcIdEstatus());

		} catch (Exception e) {

			logger.error(" Error al insertar HNota [DAO] ", e);

			throw new HNotaDAOException(e.getMessage());

		}
		
		return rows;
		
	}

}
