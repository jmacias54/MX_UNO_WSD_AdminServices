package mx.com.amx.unotv.adminservice.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.dao.exception.MagazineDAOException;

import mx.com.amx.unotv.adminservice.model.Magazine;

// TODO: Auto-generated Javadoc
/**
 * The Class MagazineDAO.
 *
 * @author Jesus A. Macias Benitez
 */
public class MagazineDAO {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * Gets the list magazine.
	 *
	 * @return the list magazine
	 * @throws MagazineDAOException the magazine DAO exception
	 */
	public List<Magazine> getListMagazine() throws MagazineDAOException{
		List<Magazine> lista = null ;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT  * FROM uno_c_magazine  ");
	

		try {
			lista = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<Magazine>(Magazine.class));

		} catch (NullPointerException npe) {
			// TODO: handle exception
			return Collections.emptyList();
		} catch (Exception e) {
			new MagazineDAOException(e.getMessage());
		}

		return lista ;
	}

}
