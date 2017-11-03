package mx.com.amx.unotv.adminservice.controller;



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


@Controller
@RequestMapping("items")
public class ItemsController {

	private static Logger logger = Logger.getLogger(ItemsController.class);

	@Autowired
	NotaBO notaBO;

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
	
	
	@RequestMapping(value = "/get_item/{idContenido}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public HNota getItem(@PathVariable String idContenido) throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- save_item -----");

		HNota nota = null;;
		try {
			
			nota = notaBO.findById(idContenido);
			
		} catch (Exception e) {
			logger.error(" -- Error  getItem by IdContenido [ItemsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return nota;
	}
	
	@RequestMapping(value = "/get_item", method = RequestMethod.GET, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public NNota getItem() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- getItem -----");

		

		return new NNota();
	}

}
