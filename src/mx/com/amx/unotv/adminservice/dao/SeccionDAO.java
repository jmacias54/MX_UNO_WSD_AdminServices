package mx.com.amx.unotv.adminservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.model.Seccion;

public class SeccionDAO extends GenericDao<Seccion, String> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${${ambiente}.database.db}")
	private String instDB;

	@Override
	public int create(Seccion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Seccion findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Seccion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Seccion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
