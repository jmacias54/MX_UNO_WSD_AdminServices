package mx.com.amx.unotv.adminservice.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.unotv.adminservice.model.Categoria;
import mx.com.amx.unotv.adminservice.repository.CategoriaRepository;



@Controller
@RequestMapping("items")
public class ItemsController {
	
	private static Logger logger = Logger.getLogger(ItemsController.class);
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@RequestMapping(value = "/get_categories", method = RequestMethod.GET, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public Iterable<Categoria> getAllCategories() {
		logger.info("--- ItemsController-----");
		logger.info("--- get_categories -----");
		
		return categoriaRepository.findAll(); 
	}


	
}
