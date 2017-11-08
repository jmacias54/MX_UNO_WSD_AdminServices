package mx.com.amx.unotv.adminservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.unotv.adminservice.bo.MagazineBO;
import mx.com.amx.unotv.adminservice.bo.NotaBO;
import mx.com.amx.unotv.adminservice.controller.exception.ControllerException;
import mx.com.amx.unotv.adminservice.model.Magazine;
import mx.com.amx.unotv.adminservice.model.request.MagazineRequest;
import mx.com.amx.unotv.adminservice.model.response.ItemsResponse;
import mx.com.amx.unotv.adminservice.model.response.ItemsWSResponse;
import mx.com.amx.unotv.adminservice.model.response.ListMagazine;

// TODO: Auto-generated Javadoc
/**
 * The Class MagazineController.
 */
/**
 * @author Jesus A. Macias Benitez
 *
 */
@Controller
@RequestMapping("magazine")
public class MagazineController {

	/** The nota BO. */
	@Autowired
	NotaBO notaBO;

	/** The magazine BO. */
	@Autowired
	MagazineBO magazineBO;

	/**
	 * Gets the list items by magazine.
	 *
	 * @param idMagazine the id magazine
	 * @return the list items by magazine
	 * @throws ControllerException the controller exception
	 */
	@RequestMapping(value = "/get_magazine/{idMagazine}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ItemsWSResponse getListItemsByMagazine(@PathVariable String idMagazine) throws ControllerException {
		List<ItemsResponse> lista = null;
		ItemsWSResponse response = new ItemsWSResponse();

		try {
			lista = notaBO.getListItemsByMagazine(idMagazine);
			response.setLista(lista);
		} catch (Exception e) {
			new ControllerException(e.getMessage());
		}

		return response;
	}

	/**
	 * Gets the list magazine.
	 *
	 * @return the list magazine
	 * @throws ControllerException the controller exception
	 */
	@RequestMapping(value = "/get_list_magazine", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ListMagazine getListMagazine() throws ControllerException {
		List<Magazine> lista = null;
		ListMagazine response = new ListMagazine();

		try {
			lista = magazineBO.getListMagazine();
			response.setLista(lista);
		} catch (Exception e) {
			new ControllerException(e.getMessage());
		}

		return response;
	}
	
	
	/**
	 * Save magazine.
	 *
	 * @param req the req
	 * @throws ControllerException the controller exception
	 */
	@RequestMapping(value = "/save_magazine", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public void saveMagazine(@RequestBody MagazineRequest req) throws ControllerException {
	

		try {
			  magazineBO.getListMagazine();
		} catch (Exception e) {
			new ControllerException(e.getMessage());
		}

		
	}
	
	
	

}
