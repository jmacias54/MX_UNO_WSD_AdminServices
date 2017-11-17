package mx.com.amx.unotv.adminservice.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.unotv.adminservice.bo.NotaBO;
import mx.com.amx.unotv.adminservice.controller.exception.ControllerException;
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
	
	



}
