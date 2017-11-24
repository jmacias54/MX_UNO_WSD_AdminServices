/**
 * 
 */
package mx.com.amx.unotv.adminservice.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import mx.com.amx.unotv.adminservice.bo.exception.IMagazineNotaBOException;
import mx.com.amx.unotv.adminservice.dao.IMagazineNotaDAO;
import mx.com.amx.unotv.adminservice.model.IMagazineNota;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class IMagazineNotaBO {
	
	private static Logger logger = Logger.getLogger(IMagazineNotaBO.class);
	
	@Autowired
	IMagazineNotaDAO iMagazineNotaDAO;
	
	
	public List<IMagazineNota> findAll()  throws IMagazineNotaBOException {
		logger.debug("--- findAll  [ IMagazineNotaBO ] -----");
		List<IMagazineNota>  lista = null;
		
		try {
			lista = iMagazineNotaDAO.findAll();
		} catch (Exception e) {
			logger.error("--- Error findAll  [ IMagazineNotaBO ] : "+e.getMessage());
			new IMagazineNotaBOException(e.getMessage());
		}
		
		
		return lista;
	}
	
	
	public List<IMagazineNota> findById(String idMagazine)  throws IMagazineNotaBOException {
		logger.debug("--- findById  [ IMagazineNotaBO ] -----");
		List<IMagazineNota>  lista = null;
		
		try {
			lista = iMagazineNotaDAO.findById(idMagazine);
		} catch (Exception e) {
			logger.error("--- Error findById  [ IMagazineNotaBO ] : "+e.getMessage());
			new IMagazineNotaBOException(e.getMessage());
		}
		
		
		return lista;
	}

}
