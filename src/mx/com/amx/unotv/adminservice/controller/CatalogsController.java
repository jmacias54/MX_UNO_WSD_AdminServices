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
import mx.com.amx.unotv.adminservice.model.response.CategoriaSeccionWSResponse;
import mx.com.amx.unotv.adminservice.model.response.CategoriaWSResponse;
import mx.com.amx.unotv.adminservice.model.response.PcodeListResponse;
import mx.com.amx.unotv.adminservice.model.response.UserResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class CatalogsController.
 */
/**
 * @author Jesus A. Macias Benitez
 *
 */
@Controller
@RequestMapping("catalogs")
public class CatalogsController {

	/** The logger. */
	private static Logger logger = Logger.getLogger(CatalogsController.class);

	/** The categoria BO. */
	@Autowired
	private CategoriaBO categoriaBO;
	
	/** The seccion BO. */
	@Autowired
	private SeccionBO seccionBO;
	
	/** The usuario BO. */
	@Autowired
	private UsuarioBO usuarioBO;
	
	/** The tag BO. */
	@Autowired
	private TagBO tagBO;
	
	/** The pcode BO. */
	@Autowired
	private PcodeBO pcodeBO;
	
	
	/**
	 * Pcode find all Pcode
	 *
	 * @return List<Pcode> - PcodeListResponse
	 * @throws ControllerException
	 */
	@RequestMapping(value = "/get_video_pcode", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public PcodeListResponse pcodeFindAll() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- get_video_pcode -----");
		PcodeListResponse obj= new PcodeListResponse();
		List<Pcode> lista = null;
		try {
			
			lista = pcodeBO.findAll();
			obj.setLista(lista);

		} catch (Exception e) {
			logger.error(" -- Error  get_video_pcode [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return obj;
	}

	/**
	 * Find all by id seccion.
	 *
	 * @param  String idSeccion 
	 * @return List<CategoriaSeccionResponse>  - CategoriaSeccionWSResponse
	 * @throws ControllerException
	 */
	@RequestMapping(value = "/get_categories/{idSeccion}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public CategoriaSeccionWSResponse  categoriesFindAllByIdSeccion(@PathVariable String idSeccion)
			throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- categoriesFindAllByIdSeccion -----");

		CategoriaSeccionWSResponse response = new CategoriaSeccionWSResponse();
		List<CategoriaSeccionResponse> lista = null;

		try {
			lista = categoriaBO.findAllByIdSeccion(idSeccion);
			response.setLista(lista);
		} catch (Exception e) {
			logger.error(" -- Error  categoriesFindAllByIdSeccion [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}
		return response;
	}

	/**
	 * Find all Categoria.
	 *
	 * @return List<Categoria> 
	 * @throws ControllerException
	 */
	@RequestMapping(value = "/get_categories", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public CategoriaWSResponse categoriesFindAll() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- categoriesFindAll -----");
		CategoriaWSResponse response = new CategoriaWSResponse();

		List<Categoria> lista = null;
		try {
			lista = categoriaBO.findAll();
			response.setLista(lista);
		} catch (Exception e) {
			logger.error(" -- Error  get_categories [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}

	/**
	 * Gets the users.
	 *
	 * @return List<UserResponse>
	 * @throws ControllerException 
	 */
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

	/**
	 * Gets the section.
	 *
	 * @return List<CategoriaSeccionResponse>
	 * @throws ControllerException
	 */
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

	/**
	 * Gets the tags.
	 *
	 * @return List<CatalogResponse> 
	 * @throws ControllerException
	 */
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
