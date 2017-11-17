package mx.com.amx.unotv.adminservice.dao;

import java.util.Collections;
import java.util.List;

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


	
	/**
	 * Find all.
	 *
	 * @return the list
	 * @throws TagDAOException the tag DAO exception
	 */
	public List<Tag> findAll()  throws TagDAOException {
		List<Tag> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT FC_ID_TAG , ");
		query.append("   FC_DESCRIPCION , ");
		query.append("   FI_ESTATUS , FC_DFP  ");
		query.append(" FROM UNO_C_TAGS ");

		try {
			lista = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<Tag>(Tag.class));

		} catch (NullPointerException npe) {
			// TODO: handle exception
			return Collections.emptyList();
		} catch (Exception e) {
			new TagDAOException(e.getMessage());
		}

		return lista;
	}
	
	
	

}
