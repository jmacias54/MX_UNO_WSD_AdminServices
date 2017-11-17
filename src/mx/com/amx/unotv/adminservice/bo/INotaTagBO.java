/**
 * 
 */
package mx.com.amx.unotv.adminservice.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.bo.exception.INotaTagBOException;
import mx.com.amx.unotv.adminservice.dao.INotaTagDAO;
import mx.com.amx.unotv.adminservice.model.INotaTag;
import mx.com.amx.unotv.adminservice.model.Tag;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class INotaTagBO {
	
	
	private static Logger logger = Logger.getLogger(INotaTagDAO.class);

	@Autowired
	INotaTagDAO iNotaTagDAO;

	

	public int insert(INotaTag iNotaTag) throws INotaTagBOException {
		int rows = 0;

		try {

			rows = iNotaTagDAO.insert(iNotaTag);

		} catch (Exception e) {

			logger.error(" Error insert [  INotaTagBO ] ", e);

			throw new INotaTagBOException(e.getMessage());

		}

		return rows;

	}

	public int delete(String idContenido) throws INotaTagBOException {
		int rows = 0;

		try {

			rows = iNotaTagDAO.delete(idContenido);

		} catch (Exception e) {

			logger.error(" Error delete [ INotaTagBO ] ", e);

			throw new INotaTagBOException(e.getMessage());

		}

		return rows;

	}

	public List<Tag> getByIdContenido(String idContenido) throws INotaTagBOException {
		List<Tag> lista = null;

		try {

			lista = iNotaTagDAO.getByIdContenido(idContenido);

		} catch (Exception e) {

			logger.error(" Error getByIdContenido [ INotaTagBO ] ", e);
			new INotaTagBOException(e.getMessage());
		}

		return lista;
	}

}
