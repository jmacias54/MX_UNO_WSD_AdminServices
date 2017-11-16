/**
 * 
 */
package mx.com.amx.unotv.adminservice.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.bo.exception.HNotaBOException;
import mx.com.amx.unotv.adminservice.bo.exception.NNotaBOException;
import mx.com.amx.unotv.adminservice.bo.exception.NotaBOException;
import mx.com.amx.unotv.adminservice.dao.NNotaDAO;
import mx.com.amx.unotv.adminservice.model.NNota;
import mx.com.amx.unotv.adminservice.model.response.ItemsResponse;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class NNotaBO {
	
	/** The logger. */
	private Logger logger = Logger.getLogger(NNotaBO.class);

	/** The n nota DAO. */
	@Autowired
	NNotaDAO nNotaDAO;
	
	
	
	public NNota findById(String id) throws HNotaBOException {
		NNota nota = null;
		try {
			nota = nNotaDAO.findById(id);

		} catch (Exception e) {

			logger.error(" Error findById  [ NNotaBO ] ", e);
			throw new HNotaBOException(e.getMessage());

		}

		return nota;

	}
	
	

	/**
	 * Inserta la nota en las tablas NNota y HNota
	 *
	 * @param NNota
	 * @return int
	 * @throws NotaBOException the nota BO exception
	 */
	public int insert(NNota nota) throws NotaBOException {
		logger.info("--- insert  [ NNotaBO ] ---- ");
		int rows = 0;

		try {

			rows = nNotaDAO.insert(nota);

		} catch (Exception e) {

			logger.error(" Error al insertar N-NOTA [ NNotaBO ] ", e);
			throw new NotaBOException(e.getMessage());

		}

		return rows;
	}
	
	
	public int update(NNota nota) throws NotaBOException {
		logger.info("--- update  [ NNotaBO ] ---- ");
		int rows = 0;

		try {

			rows = nNotaDAO.update(nota);
			

		} catch (Exception e) {

			logger.error(" Error al update N-NOTA [ NNotaBO ] ", e);
			throw new NotaBOException(e.getMessage());

		}

		return rows;
	}
	
	
	/**
	 * Gets the list items by magazine.
	 *
	 * @param String idMagazine 
	 * @return List<ItemsResponse> 
	 * @throws NotaBOException 
	 */
	public List<ItemsResponse> getListItemsByMagazine(String idMagazine)throws NNotaBOException{
		List<ItemsResponse> lista = null;
		
		try {
			lista = nNotaDAO.getListItemsByMagazine(idMagazine);

		} catch (Exception e) {

			logger.error(" Error getListItemsByTitle  [ NNotaBO ] ", e);
			throw new NNotaBOException(e.getMessage());

		}

		
		return lista ;
	}

	

}
