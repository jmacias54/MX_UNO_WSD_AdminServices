/*
 * 
 */
package mx.com.amx.unotv.adminservice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.bo.exception.MagazineBOException;
import mx.com.amx.unotv.adminservice.dao.MagazineDAO;
import mx.com.amx.unotv.adminservice.model.Magazine;

// TODO: Auto-generated Javadoc
/**
 * The Class MagazineBO.
 */
/**
 * @author Jesus A. Macias Benitez
 *
 */
public class MagazineBO {
	
	
	/** The magazine DAO. */
	@Autowired
	MagazineDAO magazineDAO;
	
	
	/**
	 * Gets the list magazine.
	 *
	 * @return the list magazine
	 * @throws MagazineBOException the magazine BO exception
	 */
	public List<Magazine> getListMagazine() throws MagazineBOException{
		List<Magazine> lista = null ;
		
		try {
		lista = magazineDAO.getListMagazine();
		
		} catch (Exception e) {
			new MagazineBOException(e.getMessage());
		}
		
		
		return lista ;
	}

}
