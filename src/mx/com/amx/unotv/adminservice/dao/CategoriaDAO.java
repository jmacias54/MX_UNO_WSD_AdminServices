package mx.com.amx.unotv.adminservice.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.dao.exception.CategoriaDAOException;
import mx.com.amx.unotv.adminservice.model.Categoria;

public class CategoriaDAO  {



	@Autowired
	private JdbcTemplate jdbcTemplate;


	public List<Categoria> findAllByIdSeccion(String idSeccion)throws CategoriaDAOException {
		List<Categoria> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT  FC_ID_CATEGORIA , ");
		query.append("   FC_ID_SECCION , ");
		query.append("   FC_DESCRIPCION , ");
		query.append("   FC_FRIENDLY_URL , ");
		query.append("   FI_ESTATUS , ");
		query.append("   FI_REGISTRIS , ");
		query.append("   FC_RUTA_DFP  ");
		query.append(" FROM uno_c_categoria WHERE FC_ID_SECCION = '" + idSeccion + "' ");

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
	
	
	public List<Categoria> findAll() throws CategoriaDAOException {
		List<Categoria> listaCategioria = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT  FC_ID_CATEGORIA , ");
		query.append("   FC_ID_SECCION , ");
		query.append("   FC_DESCRIPCION , ");
		query.append("   FC_FRIENDLY_URL , ");
		query.append("   FI_ESTATUS , ");
		query.append("   FI_REGISTRIS , ");
		query.append("   FC_RUTA_DFP  ");
		query.append(" FROM uno_c_categoria ");

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
