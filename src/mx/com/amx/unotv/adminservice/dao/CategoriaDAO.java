package mx.com.amx.unotv.adminservice.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import mx.com.amx.unotv.adminservice.dao.exception.CategoriaDAOException;
import mx.com.amx.unotv.adminservice.model.Categoria;
// TODO: Auto-generated Javadoc

/**
 * The Class CategoriaDAO.
 *
 * @author Jesus A. Macias Benitez
 */
public class CategoriaDAO  {



	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Categoria findById(String idCategoria)throws CategoriaDAOException {
		List<Categoria> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT  FC_ID_CATEGORIA , ");
		query.append("   FC_ID_SECCION , ");
		query.append("   FC_DESCRIPCION , ");
		query.append("   FC_FRIENDLY_URL , ");
		query.append("   FI_ESTATUS , ");
		query.append("   FI_REGISTROS , ");
		query.append("   FC_RUTA_DFP_APP  ");
		query.append(" FROM uno_mx_c_categoria WHERE FC_ID_CATEGORIA = '" + idCategoria + "' ");

		try {
			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Categoria>(Categoria.class));
		} catch (NullPointerException npe) {
			// TODO: handle exception
			throw new CategoriaDAOException(npe.getMessage());
		} catch (Exception e) {
			throw new CategoriaDAOException(e.getMessage());
		}
		
		if (lista == null ) {
			return null;
		}
		
		return lista.get(0);

	}
	
	
	
	public Categoria getCategorieById(String idCategorie) {
		
		List<Categoria> lista = null;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT * ");
		query.append(" FROM uno_mx_c_categoria WHERE FC_ID_CATEGORIA = '" + idCategorie + "' ");

		try {
			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Categoria>(Categoria.class));
		} catch (NullPointerException npe) {
			// TODO: handle exception
			return null;
		} catch (Exception e) {
			new CategoriaDAOException(e.getMessage());
		}
		
		
		if(lista.isEmpty() || lista == null) {
			return null;
		}
		
		
		return lista.get(0);
	}

	/**
	 * Find all by id seccion.
	 *
	 * @param  String idSeccion 
	 * @return List<CategoriaSeccionResponse>  
	 * @throws CategoriaDAOException
	 */
	public List<Categoria> findAllByIdSeccion(String idSeccion)throws CategoriaDAOException {
		List<Categoria> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT  FC_ID_CATEGORIA , ");
		query.append("   FC_ID_SECCION , ");
		query.append("   FC_DESCRIPCION , ");
		query.append("   FC_FRIENDLY_URL , ");
		query.append("   FI_ESTATUS , ");
		query.append("   FI_REGISTROS , ");
		query.append("   FC_RUTA_DFP_APP  ");
		query.append(" FROM uno_mx_c_categoria WHERE FC_ID_SECCION = '" + idSeccion + "' ");

		try {
			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Categoria>(Categoria.class));
		} catch (NullPointerException npe) {
			// TODO: handle exception
			return Collections.emptyList();
		} catch (Exception e) {
			new CategoriaDAOException(e.getMessage());
		}
		return lista;

	}
	
	
	/**
	 * Find all Categoria.
	 *
	 * @return List<Categoria> 
	 * @throws CategoriaDAOException
	 */
	public List<Categoria> findAll() throws CategoriaDAOException {
		List<Categoria> listaCategioria = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT  FC_ID_CATEGORIA , ");
		query.append("   FC_ID_SECCION , ");
		query.append("   FC_DESCRIPCION , ");
		query.append("   FC_FRIENDLY_URL , ");
		query.append("   FI_ESTATUS , ");
		query.append("   FI_REGISTROS , ");
		query.append("   FC_RUTA_DFP_APP  ");
		query.append(" FROM uno_mx_c_categoria ");

		try {
			listaCategioria = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<Categoria>(Categoria.class));

		} catch (NullPointerException npe) {
			// TODO: handle exception
			return Collections.emptyList();
		} catch (Exception e) {
			new CategoriaDAOException(e.getMessage());
		}

		return listaCategioria;
	}

}
