package mx.com.amx.unotv.adminservice.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.bo.exception.UsuarioBOException;
import mx.com.amx.unotv.adminservice.dao.exception.UsuarioDAOException;
import mx.com.amx.unotv.adminservice.model.Usuario;
// TODO: Auto-generated Javadoc

/**
 * The Class UsuarioDAO.
 *
 * @author Jesus A. Macias Benitez
 */
public class UsuarioDAO {
	
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;



	/**
	 * Gets the all  Usuario
	 *
	 * @return List<Usuario>
	 * @throws UsuarioBOException 
	 */
	public List<Usuario> findAll() throws UsuarioDAOException{
		List<Usuario> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT  FC_ID_USUARIO , ");
		query.append("   FC_NOMBRE , ");
		query.append("   FD_FECHA_REGISTRO , ");
		query.append("   FI_ESTATUS  ");
		query.append(" FROM UNO_C_USUARIOS ");

		try {
			lista = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<Usuario>(Usuario.class));

		} catch (NullPointerException npe) {
			// TODO: handle exception
			return Collections.emptyList();
		} catch (Exception e) {
			new UsuarioDAOException(e.getMessage());
		}

		return lista;
	}

}
