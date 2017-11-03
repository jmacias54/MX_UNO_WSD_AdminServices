package mx.com.amx.unotv.adminservice.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.dao.exception.TagDAOException;
import mx.com.amx.unotv.adminservice.model.Tag;

public class TagDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	
	public List<Tag> findAll()  throws TagDAOException {
		List<Tag> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT FC_ID_TAG , ");
		query.append("   FC_DESCRIPCION , ");
		query.append("   FI_ESTATUS  ");
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
