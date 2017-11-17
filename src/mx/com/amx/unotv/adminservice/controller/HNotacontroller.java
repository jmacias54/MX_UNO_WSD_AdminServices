/**
 * 
 */
package mx.com.amx.unotv.adminservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.unotv.adminservice.bo.HNotaBO;
import mx.com.amx.unotv.adminservice.controller.exception.ControllerException;
import mx.com.amx.unotv.adminservice.model.HNota;
import mx.com.amx.unotv.adminservice.model.NNota;
import mx.com.amx.unotv.adminservice.model.response.HNotaWSResponse;

/**
 * @author Jesus A. Macias Benitez
 *
 */


@Controller
@RequestMapping("hNota")
public class HNotacontroller {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(HNotacontroller.class);
	
	
	@Autowired
	HNotaBO hNotaBO;
	
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int insert(@RequestBody NNota nota) throws ControllerException {
		logger.info("--- HNotacontroller-----");
		logger.info("--- insert -----");

		int res = 0;
		try {

			res = hNotaBO.insert(nota);

		} catch (Exception e) {
			logger.error(" -- Error  insert [ HNotacontroller ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return res;
	}
	

	
	
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int update(@RequestBody NNota nota) throws ControllerException {
		logger.info("--- HNotacontroller-----");
		logger.info("--- update -----");

		int res = 0;
		try {

			res = hNotaBO.update(nota);

		} catch (Exception e) {
			logger.error(" -- Error  update [ HNotacontroller ]:", e);
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
	public HNota findById(@PathVariable String idContenido) throws ControllerException {
		logger.info("--- HNotacontroller -----");
		logger.info("--- findById -----");

		HNota nota = null;
		try {

			nota = hNotaBO.findById(idContenido);

		} catch (Exception e) {
			logger.error(" -- Error  find by IdContenido [ HNotacontroller ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return nota;
	}
	


	/**
	 * obtiene la lista de las nota en la tabla HNota.
	 *
	 * @return List<HNota>
	 * @throws ControllerException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public HNotaWSResponse findAll() throws ControllerException {
		logger.info("--- HNotacontroller -----");
		logger.info("--- findAll -----");
		HNotaWSResponse response = new HNotaWSResponse();
		List<HNota> lista = null;

		try {

			lista = hNotaBO.findAll();

			response.setLista(lista);
		} catch (Exception e) {
			logger.error(" -- Error  findAll [ HNotacontroller ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}


}
