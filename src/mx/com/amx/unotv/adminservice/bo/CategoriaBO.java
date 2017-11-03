package mx.com.amx.unotv.adminservice.bo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.bo.exception.CategoriaBOException;
import mx.com.amx.unotv.adminservice.dao.CategoriaDAO;
import mx.com.amx.unotv.adminservice.model.Categoria;
import mx.com.amx.unotv.adminservice.model.response.CategoriaSeccionResponse;

public class CategoriaBO {

	@Autowired
	private CategoriaDAO categoriaDAO;

	public List<CategoriaSeccionResponse> findAllByIdSeccion(String idSeccion) throws CategoriaBOException {

		List<CategoriaSeccionResponse> response = new LinkedList<CategoriaSeccionResponse>();
		List<Categoria> lista = null;

		try {
			lista = categoriaDAO.findAllByIdSeccion(idSeccion);
		} catch (Exception e) {

			throw new CategoriaBOException(e.getMessage());

		}

		for (Categoria categoria : lista) {
			CategoriaSeccionResponse cr = new CategoriaSeccionResponse();

			cr.setDescription(categoria.getFcDescripcion());
			cr.setId(categoria.getFcIdCategoria());
			cr.setFriendlyUrl(categoria.getFcFriendlyUrl());

			response.add(cr);
		}

		return response;

	}

	public List<Categoria> findAll() throws CategoriaBOException {

		List<Categoria> lista = null;
		try {
			lista = categoriaDAO.findAll();
		} catch (Exception e) {

			throw new CategoriaBOException(e.getMessage());

		}

		return lista;

	}

}
