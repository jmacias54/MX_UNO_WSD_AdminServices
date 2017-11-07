package mx.com.amx.unotv.adminservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.unotv.adminservice.bo.NotaBO;
import mx.com.amx.unotv.adminservice.controller.exception.ControllerException;
import mx.com.amx.unotv.adminservice.model.request.ItemsFilterRequest;
import mx.com.amx.unotv.adminservice.model.request.ItemsRequest;
import mx.com.amx.unotv.adminservice.model.request.ItemsRequestByTitle;
import mx.com.amx.unotv.adminservice.model.response.ItemsResponse;
import mx.com.amx.unotv.adminservice.model.response.ItemsWSResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemsController.
 */
/**
 * @author Jesus A. Macias Benitez
 *
 */
@Controller
@RequestMapping("items")
public class ItemsController {

	/** The nota BO. */
	@Autowired
	NotaBO notaBO;

	/** The logger. */
	private static Logger logger = Logger.getLogger(ItemsController.class);
	
	
	
	

	/**
	 * Gets the list items by filter.
	 *
	 * @param ItemsFilterRequest
	 * @return List<ItemsResponse> / ItemsWSResponse
	 * @throws ControllerException 
	 */
	@RequestMapping(value = "/get_list_items_filter", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ItemsWSResponse getListItemsByFilter(@RequestBody ItemsFilterRequest req) throws ControllerException {
		logger.info("---getListItemsByFilter [ItemsController] ----");
		List<ItemsResponse> lista = null;
		ItemsWSResponse response = new ItemsWSResponse();


		try {
			lista = notaBO.getListItemsByFilter(req);
			response.setLista(lista);
		} catch (Exception e) {
			new ControllerException(e.getMessage());
		}

		return response;
	}
	

	/**
	 * Gets the list items.
	 *
	  * @param ItemsFilterRequest
	 * @return List<ItemsResponse> / ItemsWSResponse
	 * @throws ControllerException 
	 */
	@RequestMapping(value = "/get_list_items", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ItemsWSResponse getListItems(@RequestBody ItemsRequest req) throws ControllerException {
		logger.info("---get_list_items [ItemsController] ----");
		List<ItemsResponse> lista = null;
		ItemsWSResponse response = new ItemsWSResponse();

		try {
			lista = notaBO.getListItems(req);
			response.setLista(lista);
		} catch (Exception e) {
			new ControllerException(e.getMessage());
		}

		return response;
	}
	
	/**
	 * Gets the list items by title.
	 *
	 * @param ItemsFilterRequest
	 * @return List<ItemsResponse> / ItemsWSResponse
	 * @throws ControllerException 
	 */
	@RequestMapping(value = "/get_list_items_search", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ItemsWSResponse  getListItemsByTitle(@RequestBody ItemsRequestByTitle req) throws ControllerException {
		logger.info("---get_list_items [ItemsController] ----");
		
		ItemsWSResponse response = new ItemsWSResponse();
		List<ItemsResponse> lista = null;

		try {
			lista = notaBO.getListItemsByTitle(req);
			response.setLista(lista);
		} catch (Exception e) {
			new ControllerException(e.getMessage());
		}

		return response;
	}

	

}
