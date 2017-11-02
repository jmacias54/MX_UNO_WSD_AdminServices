package mx.com.amx.unotv.adminservice.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.model.Categoria;

public class CategoriaDAO extends GenericDao<Categoria, String>{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${${ambiente}.database.db}")
	private String instDB;

	public List<Categoria> findAllByIdSeccion(String idSeccion) {
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
			new Throwable();
		}
		return lista;

	}

}
