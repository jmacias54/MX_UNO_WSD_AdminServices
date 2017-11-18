/**
 * 
 */
package mx.com.amx.unotv.adminservice.bo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.bo.exception.IHNotaUsuarioBOException;
import mx.com.amx.unotv.adminservice.dao.IHNotaUsuarioDAO;
import mx.com.amx.unotv.adminservice.model.IHNotaUsuario;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class IHNotaUsuarioBO {

	/** The logger. */
	private Logger logger = Logger.getLogger(IHNotaUsuarioBO.class);

	@Autowired
	IHNotaUsuarioDAO iHNotaUsuarioDAO;

	public IHNotaUsuario findByIdContenido(String idContenido) throws IHNotaUsuarioBOException {
		logger.info(" --- Inicio findByIdContenido [ IHNotaUsuarioBO ]  --- ");
		IHNotaUsuario user = null;

		try {
			user = iHNotaUsuarioDAO.findByIdContenido(idContenido);
		} catch (Exception e) {
			logger.error(" Error findByIdContenido  [ IHNotaUsuarioBO ] ", e);
			throw new IHNotaUsuarioBOException(e.getMessage());
		}

		return user;

	}

	public int insert(IHNotaUsuario iHNotaUsuario) throws IHNotaUsuarioBOException {
		logger.info(" --- Inicio insert [ IHNotaUsuarioBO ]  --- ");
		int rows = 0;

		try {
			rows = iHNotaUsuarioDAO.insert(iHNotaUsuario);
		} catch (Exception e) {
			logger.error(" Error insert  [ IHNotaUsuarioBO ] ", e);
			throw new IHNotaUsuarioBOException(e.getMessage());
		}

		return rows;

	}

}
