package mx.com.amx.unotv.adminservice.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.bo.exception.PcodeBOException;
import mx.com.amx.unotv.adminservice.dao.PcodeDAO;

import mx.com.amx.unotv.adminservice.model.Pcode;

public class PcodeBO {

	private static Logger logger = Logger.getLogger(PcodeBO.class);
	
	@Autowired
	PcodeDAO pcodeDAO;

	public List<Pcode> findAll() throws PcodeBOException {
		List<Pcode> lista = null;

		try {

			lista = pcodeDAO.findAll();

		} catch (Exception e) {

			logger.error(" Error findAll Pcode [BO] ", e);

			throw new PcodeBOException(e.getMessage());

		}

		return lista;
	}

}
