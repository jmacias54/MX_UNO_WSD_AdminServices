package mx.com.amx.unotv.adminservice.dao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.model.Categoria;

public abstract class GenericDao<T, PK extends Serializable> {

	
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public  int create(T t) {
		return 0;
	}

	public  T findById(PK id) {
		return null;
	}

	public  int update(T t) {
		return 0;
	}

	public  void delete(PK id) {
	}

	public  List<T> findAll() {
		List<T> lista = null;
		List<Categoria> listaCategoria =  null;
		StringBuilder query = new StringBuilder();
		
		
		query .append(" SELECT  FC_ID_CATEGORIA , ");
		query .append("   FC_ID_SECCION , ");
		query .append("   FC_DESCRIPCION , ");
		query .append("   FC_FRIENDLY_URL , ");
		query .append("   FI_ESTATUS  ");
		query .append("    ");
		query .append("   ");
		query .append(" FROM uno_mx_c_categoria ");
		
		
		try {
			listaCategoria = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Categoria>(Categoria.class));
			lista = (List<T>) listaCategoria;
		}catch (NullPointerException npe) {
			// TODO: handle exception
			return Collections.emptyList();
		} catch (Exception e) {
			new Throwable();
		}
		
		return lista;

	}
}
