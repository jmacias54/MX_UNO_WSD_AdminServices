/*
 * 
 */
package mx.com.amx.unotv.adminservice.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.bo.exception.PcodeBOException;
import mx.com.amx.unotv.adminservice.dao.PcodeDAO;
import mx.com.amx.unotv.adminservice.model.Pcode;

// TODO: Auto-generated Javadoc
/**
 * The Class PcodeBO.
 */
/**
 * @author Jesus A. Macias Benitez
 *
 */
public class PcodeBO {

	/** The logger. */
	private static Logger logger = Logger.getLogger(PcodeBO.class);
	
	/** The pcode DAO. */
	@Autowired
	PcodeDAO pcodeDAO;

	/**
	 * Find all Pcode
	 *
	 * @return List<Pcode>
	 * @throws PcodeBOException
	 */
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
