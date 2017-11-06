/*
 * 
 */
package mx.com.amx.unotv.adminservice.bo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.bo.exception.TagBOException;
import mx.com.amx.unotv.adminservice.dao.TagDAO;
import mx.com.amx.unotv.adminservice.model.Tag;
import mx.com.amx.unotv.adminservice.model.response.CatalogResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class TagBO.
 */
/**
 * @author Jesus A. Macias Benitez
 *
 */
public class TagBO {

	/** The tag DAO. */
	@Autowired
	private TagDAO tagDAO;

	/**
	 * Gets the all Tags
	 *
	 * @return List<CatalogResponse>
	 * @throws TagBOException 
	 */
	public List<CatalogResponse> getAll() throws TagBOException {
		List<CatalogResponse> response = new LinkedList<CatalogResponse>();
		List<Tag> iterable = null;

		try {

			iterable = tagDAO.findAll();
			for (Tag tag : iterable) {
				CatalogResponse cr = new CatalogResponse();

				cr.setDescription(tag.getFcDescripcion());
				cr.setId(tag.getFcIdTag());

				response.add(cr);
			}

		} catch (Exception e) {
			new TagBOException(e.getMessage());
		}

		return response;
	}

}
