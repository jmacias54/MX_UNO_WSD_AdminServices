package mx.com.amx.unotv.adminservice.bo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import mx.com.amx.unotv.adminservice.model.Tag;
import mx.com.amx.unotv.adminservice.model.response.CatalogResponse;
import mx.com.amx.unotv.adminservice.repository.TagRepository;

public class TagBO {
	
	
	
	@Autowired
	private TagRepository tagRepository;

	
	public List<CatalogResponse> getAll() {
		List<CatalogResponse> response = new LinkedList<CatalogResponse>();
		
		Iterable<Tag> iterable = tagRepository.findAll();
		
		for(Tag tag : iterable) {
			CatalogResponse cr = new CatalogResponse();
			
			
			cr.setDescription(tag.getFcDescripcion());
			cr.setId(tag.getFcIdTag());
			
			response.add(cr);
		}
		
		return response;
	}

}
