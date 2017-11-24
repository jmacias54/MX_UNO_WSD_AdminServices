/**
 * 
 */
package mx.com.amx.unotv.adminservice.dao;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import mx.com.amx.unotv.adminservice.dao.exception.IMagazineNotaDAOException;
import mx.com.amx.unotv.adminservice.model.IMagazineNota;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class IMagazineNotaDAO {
	
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static Logger logger = Logger.getLogger(IMagazineNotaDAO.class);
	
	
	public List<IMagazineNota> findAll()  throws IMagazineNotaDAOException {
		
		logger.debug("--- findAll  [ IMagazineNotaDAO ] -----");
		List<IMagazineNota> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT * ");
		query.append(" FROM uno_i_nota_magazine ");

		try {
			
			logger.debug("--- Ejecura Query : "+query);
			lista = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<IMagazineNota>(IMagazineNota.class));
			
			logger.debug("--- Total Regs : "+lista.size());

		} catch (NullPointerException npe) {
			logger.error("--- Error findAll  [ IMagazineNotaDAO ] : "+npe.getMessage());
			// TODO: handle exception
			return Collections.emptyList();
		} catch (Exception e) {
			logger.error("--- Error findAll  [ IMagazineNotaDAO ] : "+e.getMessage());
			new IMagazineNotaDAOException(e.getMessage());
		}

		return lista;
	}
	
	
	public List<IMagazineNota> findById(String idMagazine)  throws IMagazineNotaDAOException {
		
		logger.debug("--- findById  [ IMagazineNotaDAO ] -----");
		List<IMagazineNota> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT * ");
		query.append(" FROM uno_i_nota_magazine WHERE FC_ID_MAGAZINE = '"+idMagazine+"'");

		try {
			
			logger.debug("--- Ejecura Query : "+query);
			lista = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<IMagazineNota>(IMagazineNota.class));
			
			if(lista != null && !lista.isEmpty())
			logger.debug("--- Total Regs : "+lista.size());

		} catch (NullPointerException npe) {
			logger.error("--- Error findById  [ IMagazineNotaDAO ] : "+npe.getMessage());
			// TODO: handle exception
			return Collections.emptyList();
		} catch (Exception e) {
			logger.error("--- Error findById  [ IMagazineNotaDAO ] : "+e.getMessage());
			new IMagazineNotaDAOException(e.getMessage());
		}

		return lista;
	}

}
