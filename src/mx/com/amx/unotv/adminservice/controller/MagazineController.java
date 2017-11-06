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

@Controller
@RequestMapping("magazine")
public class MagazineController {

	@Autowired
	NotaBO notaBO;

	@Autowired
	MagazineBO magazineBO;

	@RequestMapping(value = "/get_magazine/{idMagazine}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<ItemsResponse> getListItemsByMagazine(@PathVariable String idMagazine) throws ControllerException {
		List<ItemsResponse> lista = null;

		try {
			lista = notaBO.getListItemsByMagazine(idMagazine);
		} catch (Exception e) {
			new ControllerException(e.getMessage());
		}

		return lista;
	}

	@RequestMapping(value = "/get_list_magazine", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<Magazine> getListMagazine() throws ControllerException {
		List<Magazine> lista = null;

		try {
			lista = magazineBO.getListMagazine();
		} catch (Exception e) {
			new ControllerException(e.getMessage());
		}

		return lista;
	}
	
	
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
