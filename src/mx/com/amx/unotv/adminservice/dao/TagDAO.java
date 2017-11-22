package mx.com.amx.unotv.adminservice.dao;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.dao.exception.TagDAOException;
import mx.com.amx.unotv.adminservice.model.Tag;
// TODO: Auto-generated Javadoc

/**
 * The Class TagDAO.
 *
 * @author Jesus A. Macias Benitez
 */
public class TagDAO {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static Logger logger = Logger.getLogger(TagDAO.class);

	
	/**
	 * Find all.
	 *
	 * @return the list
	 * @throws TagDAOException the tag DAO exception
	 */
	public List<Tag> findAll()  throws TagDAOException {
		
		logger.debug("--- findAll  [ TagDAO ] -----");
		List<Tag> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT * ");
		query.append(" FROM UNO_C_TAGS ");

		try {
			
			logger.debug("--- Ejecura Query : "+query);
			lista = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<Tag>(Tag.class));
			
			logger.debug("--- Total Regs : "+lista.size());

		} catch (NullPointerException npe) {
			logger.error("--- Error findAll  [ TagDAO ] : "+npe.getMessage());
			// TODO: handle exception
			return Collections.emptyList();
		} catch (Exception e) {
			logger.error("--- Error findAll  [ TagDAO ] : "+e.getMessage());
			new TagDAOException(e.getMessage());
		}

		return lista;
	}
	
	
	

}
