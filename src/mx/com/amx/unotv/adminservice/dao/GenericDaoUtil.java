package mx.com.amx.unotv.adminservice.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import mx.com.amx.unotv.adminservice.model.Categoria;



public abstract class GenericDaoUtil<T> {
	

	 Class<T> clazz;
	 
	 GenericDaoUtil(Class<T> clazz) {
	        this.clazz = clazz;
	    }
	 
	 @Autowired
		private JdbcTemplate jdbcTemplate;


	 
	 public List<T> findAll(){
		 List<T> lista=null;
		 
		 if(clazz.getName().equals("mx.com.amx.unotv.adminservice.model.Categoria")) {
			 List<Categoria> listaCategioria = null;
				StringBuilder query = new StringBuilder();
				query .append(" SELECT  FC_ID_CATEGORIA , ");
				query .append("   FC_ID_SECCION , ");
				query .append("   FC_DESCRIPCION , ");
				query .append("   FC_FRIENDLY_URL , ");
				query .append("   FI_ESTATUS , ");
				query .append("   FI_REGISTRIS , ");
				query .append("   FC_RUTA_DFP  ");
				query .append(" FROM uno_c_categoria ");
				
				
				try {
					listaCategioria = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Categoria>(Categoria.class));
					lista = (List<T>) listaCategioria;
				}catch (NullPointerException npe) {
					// TODO: handle exception
					return Collections.emptyList();
				} catch (Exception e) {
					new Throwable();
				}
		 }
		 
			return lista;
	 }
	 
	 

		public int create(T t) {
			// TODO Auto-generated method stub
			return 0;
		}

	
		public T findById(String id) {
			// TODO Auto-generated method stub
			return null;
		}


		public int update(T t) {
			// TODO Auto-generated method stub
			return 0;
		}


		public void delete(String id) {
			// TODO Auto-generated method stub
			
		}
}
