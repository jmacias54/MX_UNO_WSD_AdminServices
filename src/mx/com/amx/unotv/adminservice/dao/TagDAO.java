package mx.com.amx.unotv.adminservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.model.Tag;

public class TagDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	

	
	public int create(Tag t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Tag findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int update(Tag t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Tag> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
