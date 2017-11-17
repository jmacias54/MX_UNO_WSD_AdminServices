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
import mx.com.amx.unotv.adminservice.model.Seccion;
import mx.com.amx.unotv.adminservice.model.response.CatalogResponse;
import mx.com.amx.unotv.adminservice.model.response.CatalogWSResponse;
import mx.com.amx.unotv.adminservice.model.response.CategoriaSeccionResponse;
import mx.com.amx.unotv.adminservice.model.response.CategoriaSeccionWSResponse;
import mx.com.amx.unotv.adminservice.model.response.CategoriaWSResponse;
import mx.com.amx.unotv.adminservice.model.response.PcodeListResponse;
import mx.com.amx.unotv.adminservice.model.response.UserResponse;
import mx.com.amx.unotv.adminservice.model.response.UserWSResponse;

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
	 * @return List<Categoria> / CategoriaWSResponse
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
	
	@RequestMapping(value = "/get_categorie/{idCategorie}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public Categoria getCategorieById(@PathVariable String idCategorie) throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- getCategorieById -----");
		Categoria categoria = new Categoria();

		
		try {
			categoria = categoriaBO.getCategorieById(idCategorie);
			
		} catch (Exception e) {
			logger.error(" -- Error  getCategorieById [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return categoria;
	}

	/**
	 * Gets the users.
	 *
	 * @return List<UserResponse> / UserWSResponse
	 * @throws ControllerException 
	 */
	@RequestMapping(value = "/get_users", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public UserWSResponse get_users() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- get_users -----");
		UserWSResponse response = new UserWSResponse();
		List<UserResponse> lista = null;
		try {

			lista = usuarioBO.getAll();
			response.setLista(lista);
		} catch (Exception e) {
			logger.error(" -- Error  get_users [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}
		return response;
	}

	/**
	 * Gets the section.
	 *
	 * @return List<CategoriaSeccionResponse> / CategoriaSeccionWSResponse
	 * @throws ControllerException
	 */
	@RequestMapping(value = "/get_section", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public CategoriaSeccionWSResponse get_section() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- get_section -----");
		List<CategoriaSeccionResponse> lista = null;
		
		CategoriaSeccionWSResponse response = new CategoriaSeccionWSResponse();

		try {
			lista = seccionBO.getAll();
			response.setLista(lista);
		} catch (Exception e) {
			logger.error(" -- Error  get_section [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}
	
	@RequestMapping(value = "/get_section/{idSeccion}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public Seccion getSectionById(@PathVariable String idSeccion) throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- getSectionById -----");

		
		Seccion seccion = new Seccion();

		try {
			seccion = seccionBO.getSectionById(idSeccion);
			
		} catch (Exception e) {
			logger.error(" -- Error  getSectionById [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return seccion;
	}

	/**
	 * Gets the tags.
	 *
	 * @return List<CatalogResponse> / CatalogWSResponse
	 * @throws ControllerException
	 */
	@RequestMapping(value = "/get_tags", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public CatalogWSResponse get_tags() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- get_tags -----");

		CatalogWSResponse response = new CatalogWSResponse();
		List<CatalogResponse> lista = null;

		try {
			lista = tagBO.getAll();
			response.setLista(lista);
		} catch (Exception e) {
			logger.error(" -- Error  get_tags [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}

	
	@RequestMapping(value = "/get_tags", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public CatalogWSResponse get_tags_by_id_() throws ControllerException {
		logger.info("--- ItemsController-----");
		logger.info("--- get_tags -----");

		CatalogWSResponse response = new CatalogWSResponse();
		List<CatalogResponse> lista = null;

		try {
			lista = tagBO.getAll();
			response.setLista(lista);
		} catch (Exception e) {
			logger.error(" -- Error  get_tags [CatalogsController]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}
	
	


}
