/*
 * 
 */
package mx.com.amx.unotv.adminservice.bo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import mx.com.amx.unotv.adminservice.bo.exception.SeccionBOException;
import mx.com.amx.unotv.adminservice.dao.SeccionDAO;
import mx.com.amx.unotv.adminservice.model.Seccion;

import mx.com.amx.unotv.adminservice.model.response.CategoriaSeccionResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class SeccionBO.
 */
/**
 * @author Jesus A. Macias Benitez
 *
 */
public class SeccionBO {

	/** The seccion DAO. */
	@Autowired
	private SeccionDAO seccionDAO;
	
	
	public Seccion getSectionById(String idSeccion) {
	
		
		Seccion seccion = null;

		try {
			seccion = seccionDAO.getSectionById(idSeccion);

		} catch (Exception e) {
			new SeccionBOException(e.getMessage());
		}

		return seccion;
	}

	/**
	 * Gets the all Seccion
	 *
	 * @return List<CategoriaSeccionResponse>
	 * @throws SeccionBOException 
	 */
	public List<CategoriaSeccionResponse> getAll() throws SeccionBOException{
		List<CategoriaSeccionResponse> response = new LinkedList<CategoriaSeccionResponse>();

		List<Seccion> lista = null;

		try {
			lista = seccionDAO.findAll();

			for (Seccion seccion : lista) {
				CategoriaSeccionResponse cr = new CategoriaSeccionResponse();

				cr.setDescription(seccion.getFcDescripcion());
				cr.setId(seccion.getFcIdSeccion());
				cr.setFriendlyUrl(seccion.getFcFriendlyUrl());
				response.add(cr);
			}
		} catch (Exception e) {
			new SeccionBOException(e.getMessage());
		}

		return response;
	}
}
