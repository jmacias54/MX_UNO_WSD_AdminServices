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
import mx.com.amx.unotv.adminservice.bo.NNotaBO;
import mx.com.amx.unotv.adminservice.bo.NotaBO;
import mx.com.amx.unotv.adminservice.controller.exception.ControllerException;
import mx.com.amx.unotv.adminservice.model.HNota;
import mx.com.amx.unotv.adminservice.model.NNota;
import mx.com.amx.unotv.adminservice.model.response.HNotaWSResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class DetailController.
 */
/**
 * @author Jesus A. Macias Benitez
 *
 */
@Controller
@RequestMapping("detail")
public class DetailController {

	/** The logger. */
	private static Logger logger = Logger.getLogger(DetailController.class);

	/** The nota BO. */
	@Autowired
	NotaBO notaBO;
	@Autowired
	NNotaBO nNotaBO;
	@Autowired
	HNotaBO hNotaBO;
	/**
	 * Inserta la nota en las tablas NNota y HNota
	 *
	 * @param NNota
	 * @return int
	 * @throws ControllerException 
	 */
	@RequestMapping(value = "/save_n_nota", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int save_n_nota(@RequestBody NNota nota) throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- save_n_nota -----");

		int res = 0;
		try {

			res = nNotaBO.insert(nota);

		} catch (Exception e) {
			logger.error(" -- Error  save_n_nota [DetailController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return res;
	}
	
	@RequestMapping(value = "/save_h_nota", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int save_h_nota(@RequestBody NNota nota) throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- save_h_nota -----");

		int res = 0;
		try {

			res = hNotaBO.insert(nota);

		} catch (Exception e) {
			logger.error(" -- Error  save_h_nota [DetailController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return res;
	}
	
	@RequestMapping(value = "/update_n_nota", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int update_n_nota(@RequestBody NNota nota) throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- update_n_nota -----");

		int res = 0;
		try {

			res = nNotaBO.update(nota);

		} catch (Exception e) {
			logger.error(" -- Error  update_n_nota [DetailController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return res;
	}
	
	
	
	
	
	@RequestMapping(value = "/update_h_nota", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int update_h_nota(@RequestBody NNota nota) throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- update_h_nota -----");

		int res = 0;
		try {

			res = hNotaBO.update(nota);

		} catch (Exception e) {
			logger.error(" -- Error  update_h_nota [DetailController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return res;
	}
	
	@RequestMapping(value = "/expire_item", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int expireItem(@RequestBody NNota nota) throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- expire_item -----");

		int res = 0;
		try {

			res = notaBO.expireItem(nota);

		} catch (Exception e) {
			logger.error(" -- Error  expire_item  [DetailController]:", e);
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
	@RequestMapping(value = "/get_item/{idContenido}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public HNota getItem(@PathVariable String idContenido) throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- getItem -----");

		HNota nota = null;
		try {

			nota = hNotaBO.findById(idContenido);

		} catch (Exception e) {
			logger.error(" -- Error  getItem by IdContenido [DetailController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return nota;
	}
	
	
	/**
	 * obtiene informacion de la tabla HNota.
	 *
	 * @param String idContenido 
	 * @return HNota
	 * @throws ControllerException 
	 */
	@RequestMapping(value = "/get_n_nota/{idContenido}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public NNota get_n_nota(@PathVariable String idContenido) throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- get_n_nota -----");

		NNota nota = null;
		try {

			nota = nNotaBO.findById(idContenido);

		} catch (Exception e) {
			logger.error(" -- Error  get_n_nota by IdContenido [DetailController]:", e);
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
	@RequestMapping(value = "/get_item", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public HNotaWSResponse getItem() throws ControllerException {
		logger.info("--- DetailController-----");
		logger.info("--- getItem -----");
		HNotaWSResponse response = new HNotaWSResponse();
		List<HNota> lista = null;

		try {

			lista = hNotaBO.findAll();

			response.setLista(lista);
		} catch (Exception e) {
			logger.error(" -- Error  getItem [DetailController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}

}
