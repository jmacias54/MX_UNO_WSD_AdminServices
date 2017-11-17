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

import mx.com.amx.unotv.adminservice.bo.INotaTagBO;
import mx.com.amx.unotv.adminservice.controller.exception.ControllerException;
import mx.com.amx.unotv.adminservice.model.INotaTag;
import mx.com.amx.unotv.adminservice.model.Tag;
import mx.com.amx.unotv.adminservice.model.response.ListTag;

/**
 * @author Jesus A. Macias Benitez
 *
 */

@Controller
@RequestMapping("iNotaTag")
public class INotaTagController {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(INotaTagController.class);
	
	
	/** The INotaTagBO. */
	@Autowired
	private INotaTagBO iNotaTagBO;
	
	
	// ListTag
	@RequestMapping(value = "/{idContenido}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ListTag getByIdContenido(@PathVariable String idContenido) throws ControllerException {
		logger.info("--- INotaTagController-----");
		logger.info("--- getByIdContenido -----");

		ListTag response = new ListTag();
		List<Tag> lista = null;

		try {
			lista = iNotaTagBO.getByIdContenido(idContenido);
			response.setLista(lista);
		} catch (Exception e) {
			logger.error(" -- Error  getByIdContenido [ INotaTagController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}
	
	
	@RequestMapping(value = "/delete/{idContenido}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int delete(@PathVariable String idContenido) throws ControllerException {
		int rows = 0;

		try {
			rows = iNotaTagBO.delete(idContenido);

		} catch (Exception e) {

			logger.error(" Error delete [ INotaTagController ] ", e);

			throw new ControllerException(e.getMessage());

		}

		return rows;

	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int insert(@RequestBody INotaTag iNotaTag) throws ControllerException {
		int rows = 0;

		try {
			rows = iNotaTagBO.insert(iNotaTag);

		} catch (Exception e) {

			logger.error(" Error insert [ INotaTagController ] ", e);

			throw new ControllerException(e.getMessage());

		}

		return rows;

	}

}
