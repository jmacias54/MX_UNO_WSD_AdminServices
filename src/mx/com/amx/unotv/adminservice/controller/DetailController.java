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

import mx.com.amx.unotv.adminservice.bo.NotaBO;
import mx.com.amx.unotv.adminservice.controller.exception.ControllerException;
import mx.com.amx.unotv.adminservice.model.HNota;
import mx.com.amx.unotv.adminservice.model.NNota;

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

	/**
	 * Inserta la nota en las tablas NNota y HNota
	 *
	 * @param NNota
	 * @return int
	 * @throws ControllerException 
	 */
	@RequestMapping(value = "/save_item", method = RequestMethod.PUT, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int saveItem(@RequestBody NNota nota) throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- save_item -----");

		int res = 0;
		try {

			res = notaBO.insert(nota);

		} catch (Exception e) {
			logger.error(" -- Error  save_item [ItemsController]:", e);
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
		logger.info("--- ItemsController-----");
		logger.info("--- save_item -----");

		HNota nota = null;
		;
		try {

			nota = notaBO.findById(idContenido);

		} catch (Exception e) {
			logger.error(" -- Error  getItem by IdContenido [ItemsController]:", e);
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
	public List<HNota> getItem() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- getItem -----");

		List<HNota> lista = null;

		try {

			lista = notaBO.findAll();

		} catch (Exception e) {
			logger.error(" -- Error  getItem [ItemsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return lista;
	}

}
