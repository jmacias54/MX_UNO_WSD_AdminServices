/**
 * 
 */
package mx.com.amx.unotv.adminservice.controller;

import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.com.amx.unotv.adminservice.bo.IMagazineNotaBO;
import mx.com.amx.unotv.adminservice.controller.exception.ControllerException;
import mx.com.amx.unotv.adminservice.model.IMagazineNota;
import mx.com.amx.unotv.adminservice.model.response.IMagazineNotaListResponse;

/**
 * @author Jesus A. Macias Benitez
 *
 */

@Controller
@RequestMapping("iMagazineNota")
public class IMagazineNotaController {

	/** The logger. */
	private static Logger logger = Logger.getLogger(IMagazineNotaController.class);

	@Autowired
	IMagazineNotaBO iMagazineNotaBO;

	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public IMagazineNotaListResponse findAll() throws ControllerException {

		logger.info("--- IMagazineNotaController-----");
		logger.info("--- findAll -----");
		List<IMagazineNota> lista = null;
		IMagazineNotaListResponse response = null;
		try {
			lista = iMagazineNotaBO.findAll();

			if (lista != null && !lista.isEmpty()) {
				response = new IMagazineNotaListResponse();
				response.setLista(lista);
			} else {

				response = new IMagazineNotaListResponse();
				response.setLista(Collections.<IMagazineNota>emptyList());
			}

		} catch (Exception e) {
			logger.error(" -- Error  findAll [ IMagazineNotaController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}
	

	@RequestMapping(value = "/{idMagazine}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public IMagazineNotaListResponse findById(@PathVariable String idMagazine) throws ControllerException {

		logger.info("--- IMagazineNotaController-----");
		logger.info("--- findById -----");
		List<IMagazineNota> lista = null;
		IMagazineNotaListResponse response = null;
		try {
			lista = iMagazineNotaBO.findById(idMagazine);

			if (lista != null && !lista.isEmpty()) {
				response = new IMagazineNotaListResponse();
				response.setLista(lista);
			} else {

				response = new IMagazineNotaListResponse();
				response.setLista(Collections.<IMagazineNota>emptyList());
			}

		} catch (Exception e) {
			logger.error(" -- Error  findById [ IMagazineNotaController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}

}
