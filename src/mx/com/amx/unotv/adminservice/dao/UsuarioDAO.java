package mx.com.amx.unotv.adminservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.model.Usuario;

public class UsuarioDAO {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${${ambiente}.database.db}")
	private String instDB;

	
	public int create(Usuario t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Usuario findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int update(Usuario t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
