package mx.com.amx.unotv.adminservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.unotv.adminservice.bo.CategoriaBO;
import mx.com.amx.unotv.adminservice.bo.SeccionBO;
import mx.com.amx.unotv.adminservice.bo.UsuarioBO;
import mx.com.amx.unotv.adminservice.model.response.CatalogResponse;
import mx.com.amx.unotv.adminservice.model.response.UserResponse;

@Controller
@RequestMapping("items")
public class ItemsController {

	private static Logger logger = Logger.getLogger(ItemsController.class);

	@Autowired
	private CategoriaBO categoriaBO;
	@Autowired
	private SeccionBO seccionBO;
	@Autowired
	private UsuarioBO usuarioBO;

	@RequestMapping(value = "/get_categories/{idSeccion}", method = RequestMethod.GET, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<CatalogResponse> getAllCategories(@PathVariable String idSeccion) {
		logger.info("--- ItemsController-----");
		logger.info("--- get_categories -----");

		return categoriaBO.findAllByIdSeccion(idSeccion);
	}

	@RequestMapping(value = "/get_users", method = RequestMethod.GET, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<UserResponse> get_users() {
		logger.info("--- ItemsController-----");
		logger.info("--- get_users -----");

		return usuarioBO.getAll();
	}

	@RequestMapping(value = "/get_section", method = RequestMethod.GET, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<CatalogResponse> get_section() {
		logger.info("--- ItemsController-----");
		logger.info("--- get_section -----");

		return seccionBO.getAll();
	}

}
