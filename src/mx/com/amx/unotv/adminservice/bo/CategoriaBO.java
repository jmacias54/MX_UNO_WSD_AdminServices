package mx.com.amx.unotv.adminservice.bo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.dao.CategoriaDAO;
import mx.com.amx.unotv.adminservice.model.Categoria;
import mx.com.amx.unotv.adminservice.model.response.CatalogResponse;

public class CategoriaBO {

	@Autowired
	private CategoriaDAO categoriaDAO;

	public List<CatalogResponse> findAllByIdSeccion(String idSeccion) {

		List<CatalogResponse> response = new LinkedList<CatalogResponse>();

		List<Categoria> lista = categoriaDAO.findAllByIdSeccion(idSeccion);

		for (Categoria categoria : lista) {
			CatalogResponse cr = new CatalogResponse();

			cr.setDescription(categoria.getFcDescripcion());
			cr.setId(categoria.getFcIdCategoria());

			response.add(cr);
		}

		return response;

	}

	public List<Categoria> findAll() {

		List<Categoria> lista = categoriaDAO.findAll();

		return lista;

	}

}
