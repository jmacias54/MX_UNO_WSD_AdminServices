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
import mx.com.amx.unotv.adminservice.bo.PcodeBO;
import mx.com.amx.unotv.adminservice.bo.SeccionBO;
import mx.com.amx.unotv.adminservice.bo.TagBO;
import mx.com.amx.unotv.adminservice.bo.UsuarioBO;
import mx.com.amx.unotv.adminservice.controller.exception.ControllerException;
import mx.com.amx.unotv.adminservice.model.Categoria;
import mx.com.amx.unotv.adminservice.model.Pcode;
import mx.com.amx.unotv.adminservice.model.response.CatalogResponse;
import mx.com.amx.unotv.adminservice.model.response.CategoriaSeccionResponse;
import mx.com.amx.unotv.adminservice.model.response.UserResponse;

@Controller
@RequestMapping("catalogs")
public class CatalogsController {

	private static Logger logger = Logger.getLogger(CatalogsController.class);

	@Autowired
	private CategoriaBO categoriaBO;
	@Autowired
	private SeccionBO seccionBO;
	@Autowired
	private UsuarioBO usuarioBO;
	@Autowired
	private TagBO tagBO;
	@Autowired
	private PcodeBO pcodeBO;
	
	
	@RequestMapping(value = "/get_video_pcode", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<Pcode> pcodeFindAll() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- get_video_pcode -----");

		List<Pcode> lista = null;
		try {
			lista = pcodeBO.findAll();

		} catch (Exception e) {
			logger.error(" -- Error  get_video_pcode [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return lista;
	}

	@RequestMapping(value = "/get_categories/{idSeccion}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<CategoriaSeccionResponse> categoriesFindAllByIdSeccion(@PathVariable String idSeccion)
			throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- categoriesFindAllByIdSeccion -----");

		List<CategoriaSeccionResponse> lista = null;

		try {
			lista = categoriaBO.findAllByIdSeccion(idSeccion);
		} catch (Exception e) {
			logger.error(" -- Error  categoriesFindAllByIdSeccion [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}
		return lista;
	}

	@RequestMapping(value = "/get_categories", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<Categoria> categoriesFindAll() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- categoriesFindAll -----");

		List<Categoria> lista = null;
		try {
			lista = categoriaBO.findAll();

		} catch (Exception e) {
			logger.error(" -- Error  get_categories [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return lista;
	}

	@RequestMapping(value = "/get_users", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<UserResponse> get_users() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- get_users -----");

		List<UserResponse> lista = null;
		try {

			lista = usuarioBO.getAll();
		} catch (Exception e) {
			logger.error(" -- Error  get_users [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}
		return lista;
	}

	@RequestMapping(value = "/get_section", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<CategoriaSeccionResponse> get_section() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- get_section -----");
		List<CategoriaSeccionResponse> lista = null;

		try {
			lista = seccionBO.getAll();
		} catch (Exception e) {
			logger.error(" -- Error  get_section [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return lista;
	}

	@RequestMapping(value = "/get_tags", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<CatalogResponse> get_tags() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- get_tags -----");

		List<CatalogResponse> lista = null;

		try {
			lista = tagBO.getAll();
		} catch (Exception e) {
			logger.error(" -- Error  get_tags [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return lista;
	}

}
