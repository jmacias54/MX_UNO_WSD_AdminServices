package mx.com.amx.unotv.adminservice.bo;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.model.Seccion;
import mx.com.amx.unotv.adminservice.model.response.CatalogResponse;
import mx.com.amx.unotv.adminservice.repository.SeccionRepository;


public class SeccionBO {


	private static Logger logger = Logger.getLogger(SeccionBO.class);
	
	
	@Autowired
	private SeccionRepository seccionRepository;

	
	public List<CatalogResponse> getAll() {
		List<CatalogResponse> response = new LinkedList<CatalogResponse>();
		
		Iterable<Seccion> iterable = seccionRepository.findAll();
		
		for(Seccion seccion : iterable) {
			CatalogResponse cr = new CatalogResponse();
			
			
			cr.setDescription(seccion.getFcDescripcion());
			cr.setId(seccion.getFcIdSeccion());
			
			response.add(cr);
		}
		
		return response;
	}
}
