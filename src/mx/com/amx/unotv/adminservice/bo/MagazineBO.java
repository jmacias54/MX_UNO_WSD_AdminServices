/*
 * 
 */
package mx.com.amx.unotv.adminservice.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.bo.exception.MagazineBOException;
import mx.com.amx.unotv.adminservice.dao.MagazineDAO;
import mx.com.amx.unotv.adminservice.model.IMagazineNota;
import mx.com.amx.unotv.adminservice.model.Magazine;
import mx.com.amx.unotv.adminservice.model.request.MagazineRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class MagazineBO.
 */
/**
 * @author Jesus A. Macias Benitez
 *
 */
public class MagazineBO {

	
	private Logger logger = Logger.getLogger(MagazineBO.class);
	/** The magazine DAO. */
	@Autowired
	MagazineDAO magazineDAO;

	
	public Magazine getMagazineByIdMagazine(String idMagazine) {
		
		Magazine magazine = null;

		try {
			magazine = magazineDAO.getMagazineByIdMagazine(idMagazine);

		} catch (Exception e) {
			logger.error(" Error geMagazineByIdMagazine [ MagazineBO ] ", e);
			new MagazineBOException(e.getMessage());
		}

		return magazine;
	}
	
	
	
	
	/**
	 * Gets the list magazine.
	 *
	 * @return the list magazine
	 * @throws MagazineBOException
	 *             the magazine BO exception
	 *             
	 */
	public List<Magazine> getListMagazine() throws MagazineBOException {
		List<Magazine> lista = null;

		try {
			lista = magazineDAO.getListMagazine();

		} catch (Exception e) {
			logger.error(" Error getListMagazine [ MagazineBO ] ", e);
			new MagazineBOException(e.getMessage());
		}

		return lista;
	}

	public void saveMagazine(MagazineRequest req) throws MagazineBOException {

		try {

			magazineDAO.deleteIMagazineNota(req.getId_magazine());

		} catch (Exception e) {
			new MagazineBOException(e.getMessage());
			logger.error(" Error saveMagazine - deleteIMagazineNota [ MagazineBO ] ", e);
		}

		try {

			for (IMagazineNota iMagazineNota : req.getLista()) {

				magazineDAO.insertIMagazineNota(iMagazineNota);

			}

		} catch (Exception e) {

			logger.error(" Error saveMagazine - insertIMagazineNota [ MagazineBO ] ", e);
			new MagazineBOException(e.getMessage());
		}

	}

}
