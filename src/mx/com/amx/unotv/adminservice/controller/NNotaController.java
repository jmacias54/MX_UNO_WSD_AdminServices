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

import mx.com.amx.unotv.adminservice.bo.NNotaBO;
import mx.com.amx.unotv.adminservice.controller.exception.ControllerException;
import mx.com.amx.unotv.adminservice.model.NNota;

/**
 * @author Jesus A. Macias Benitez
 *
 */

@Controller
@RequestMapping("nNota")
public class NNotaController {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(NNotaController.class);
	
	
	@Autowired
	NNotaBO nNotaBO;
	
	
	
	/**
	 * Inserta la nota en las tablas NNota y HNota
	 *
	 * @param NNota
	 * @return int
	 * @throws ControllerException 
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int insert(@RequestBody NNota nota) throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- insert -----");

		int res = 0;
		try {

			res = nNotaBO.insert(nota);

		} catch (Exception e) {
			logger.error(" -- Error  insert [ NNotaController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return res;
	}
	
	
	@RequestMapping(value = "/delete/{idContenido}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int delete(@PathVariable String idContenido) throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- delete -----");

		int res = 0;
		try {

			res = nNotaBO.delete(idContenido);

		} catch (Exception e) {
			logger.error(" -- Error  delete [ NNotaController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return res;
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int update(@RequestBody NNota nota) throws ControllerException {
		logger.info("--- NNotaController-----");
		logger.info("--- update -----");

		int res = 0;
		try {

			res = nNotaBO.update(nota);

		} catch (Exception e) {
			logger.error(" -- Error  update [ NNotaController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return res;
	}
	
	
	
	/**
	 * obtiene informacion de la tabla HNota.
	 *
	 * @param String idContenido 
	 * @return HNota
	 * @throws ControllerException 
	 */
	@RequestMapping(value = "/{idContenido}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public NNota findById(@PathVariable String idContenido) throws ControllerException {
		logger.info("--- NNotaController-----");
		logger.info("--- findById -----");

		NNota nota = null;
		try {

			nota = nNotaBO.findById(idContenido);

		} catch (Exception e) {
			logger.error(" -- Error  find  by IdContenido [ NNotaController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return nota;
	}
	


}
