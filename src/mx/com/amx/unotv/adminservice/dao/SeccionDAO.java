package mx.com.amx.unotv.adminservice.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.dao.exception.SeccionDAOException;
import mx.com.amx.unotv.adminservice.model.Seccion;

public class SeccionDAO  {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	
	
	public List<Seccion> findAll()  throws SeccionDAOException {
		List<Seccion> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT FC_ID_SECCION , ");
		query.append("   FC_DESCRIPCION , ");
		query.append("   FC_FRIENDLY_URL , ");
		query.append("   FI_ESTATUS  ");
		query.append(" FROM uno_c_seccion ");

		try {
			lista = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<Seccion>(Seccion.class));

		} catch (NullPointerException npe) {
			// TODO: handle exception
			return Collections.emptyList();
		} catch (Exception e) {
			new SeccionDAOException(e.getMessage());
		}

		return lista;
	}



}
