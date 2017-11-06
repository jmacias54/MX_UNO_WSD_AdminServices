package mx.com.amx.unotv.adminservice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.bo.exception.MagazineBOException;
import mx.com.amx.unotv.adminservice.dao.MagazineDAO;
import mx.com.amx.unotv.adminservice.model.Magazine;

public class MagazineBO {
	
	
	@Autowired
	MagazineDAO magazineDAO;
	
	
	public List<Magazine> getListMagazine() throws MagazineBOException{
		List<Magazine> lista = null ;
		
		try {
		lista = magazineDAO.getListMagazine();
		
		} catch (Exception e) {
			new MagazineBOException(e.getMessage());
		}
		
		
		return lista ;
	}

}
