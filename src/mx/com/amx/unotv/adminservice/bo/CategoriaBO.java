package mx.com.amx.unotv.adminservice.bo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.model.Categoria;
import mx.com.amx.unotv.adminservice.model.response.CatalogResponse;
import mx.com.amx.unotv.adminservice.repository.CategoriaRepository;

public class CategoriaBO {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public List<CatalogResponse> findAllByIdSeccion(String idSeccion) {
		
		
	List<CatalogResponse> response = new LinkedList<CatalogResponse>();
		
	   List<Categoria> iterable = categoriaRepository.findByIdCategoria(idSeccion);
		
		for(Categoria categoria : iterable) {
			CatalogResponse cr = new CatalogResponse();
			
			
			cr.setDescription(categoria.getFcDescripcion());
			cr.setId(categoria.getFcIdCategoria());
			
			response.add(cr);
		}
		
		return response;
		
	}
	

}
