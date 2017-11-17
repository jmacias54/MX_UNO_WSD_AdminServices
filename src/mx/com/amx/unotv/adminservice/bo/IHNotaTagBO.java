/**
 * 
 */
package mx.com.amx.unotv.adminservice.bo;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import mx.com.amx.unotv.adminservice.bo.exception.IHNotaTagBOException;
import mx.com.amx.unotv.adminservice.dao.IHNotaTagDAO;
import mx.com.amx.unotv.adminservice.model.IHNotaTag;
import mx.com.amx.unotv.adminservice.model.Tag;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class IHNotaTagBO {
	
	private static Logger logger = Logger.getLogger(IHNotaTagBO.class);
	
	@Autowired
	IHNotaTagDAO iHNotaTagDAO;
	

	
	
	public int insert(IHNotaTag iHNotaTag) throws IHNotaTagBOException {
		int rows = 0;

		try {
			rows = iHNotaTagDAO.insert(iHNotaTag);

		} catch (Exception e) {

			logger.error(" Error insert [ IHNotaTagBO ] ", e);

			throw new IHNotaTagBOException(e.getMessage());

		}

		return rows;

	}
	
	
	public int delete(String idContenido) throws IHNotaTagBOException {
		int rows = 0;

		try {
			rows = iHNotaTagDAO.delete(idContenido);

		} catch (Exception e) {

			logger.error(" Error delete [ IHNotaTagBO ] ", e);

			throw new IHNotaTagBOException(e.getMessage());

		}

		return rows;

	}
	
	
	public List<Tag> getByIdContenido(String idContenido)  throws IHNotaTagBOException {
		List<Tag> lista = null;
		
		

		try {
			lista = iHNotaTagDAO.getByIdContenido(idContenido);

		}  catch (Exception e) {
			logger.error(" Error getByIdContenido [ IHNotaTagBO ] ", e);
			new IHNotaTagBOException(e.getMessage());
		}

		return lista;
	}



}
