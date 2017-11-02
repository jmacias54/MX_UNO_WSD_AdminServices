package mx.com.amx.unotv.adminservice.bo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.dao.TagDAO;
import mx.com.amx.unotv.adminservice.model.Tag;
import mx.com.amx.unotv.adminservice.model.response.CatalogResponse;


public class TagBO {
	
	
	
	@Autowired
	private TagDAO tagDAO;

	
	public List<CatalogResponse> getAll() {
		List<CatalogResponse> response = new LinkedList<CatalogResponse>();
		
		List<Tag> iterable = tagDAO.findAll();
		
		for(Tag tag : iterable) {
			CatalogResponse cr = new CatalogResponse();
			
			
			cr.setDescription(tag.getFcDescripcion());
			cr.setId(tag.getFcIdTag());
			
			response.add(cr);
		}
		
		return response;
	}

}
