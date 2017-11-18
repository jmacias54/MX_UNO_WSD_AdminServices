/**
 * 
 */
package mx.com.amx.unotv.adminservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.unotv.adminservice.bo.IHNotaUsuarioBO;
import mx.com.amx.unotv.adminservice.controller.exception.ControllerException;
import mx.com.amx.unotv.adminservice.model.IHNotaUsuario;

/**
 * @author Jesus A. Macias Benitez
 *
 */

@Controller
@RequestMapping("iHNotaUsuario")
public class IHNotaUsuarioController {

	/** The logger. */
	private static Logger logger = Logger.getLogger(IHNotaUsuarioController.class);

	@Autowired
	IHNotaUsuarioBO iHNotaUsuarioBO;

	@RequestMapping(value = "/insert", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int insert(@RequestBody IHNotaUsuario iHNotaUsuario) throws ControllerException {

		logger.info("--- IHNotaUsuarioController-----");
		logger.info("--- insert -----");
		int res = 0;
		try {
			iHNotaUsuarioBO.insert(iHNotaUsuario);

		} catch (Exception e) {
			logger.error(" -- Error  insert [ IHNotaUsuarioController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return res;
	}
	
	@RequestMapping(value = "/{idContenido}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public IHNotaUsuario findByIdContenido(@PathVariable String idContenido) throws ControllerException {

		logger.info("--- IHNotaUsuarioController-----");
		logger.info("--- findByIdContenido -----");
		IHNotaUsuario user = null;
		try {
			user = iHNotaUsuarioBO.findByIdContenido(idContenido);

		} catch (Exception e) {
			logger.error(" -- Error  findByIdContenido [ IHNotaUsuarioController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return user;
	}

}
