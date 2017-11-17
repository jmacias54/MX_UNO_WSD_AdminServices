/*
 * 
 */
package mx.com.amx.unotv.adminservice.bo;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import mx.com.amx.unotv.adminservice.bo.exception.NotaBOException;
import mx.com.amx.unotv.adminservice.dao.HNotaDAO;
import mx.com.amx.unotv.adminservice.dao.IHNotaUsuarioDAO;
import mx.com.amx.unotv.adminservice.dao.NNotaDAO;
import mx.com.amx.unotv.adminservice.model.NNota;

// TODO: Auto-generated Javadoc
/**
 * The Class NotaBO.
 */
/**
 * @author Jesus A. Macias Benitez
 *
 */
public class NotaBO {

	/** The logger. */
	private Logger logger = Logger.getLogger(NotaBO.class);

	/** The n nota DAO. */
	@Autowired
	NNotaDAO nNotaDAO;
	/** The h nota DAO. */
	@Autowired
	HNotaDAO hNotaDAO;
	@Autowired
	IHNotaUsuarioDAO iHNotaUsuarioDAO;
	
	@Autowired
	HNotaBO hNotaBO;
	
	
	public int expireItem(NNota nota) throws NotaBOException {
		logger.info("--- expireItem  [NotaBO] ---- ");
		int rows = 0;

		try {

			rows = nNotaDAO.delete(nota.getFcIdContenido());
			if (rows > 0 ) {
				rows = 0;
				rows = hNotaBO.update(nota);
			}

		} catch (Exception e) {

			logger.error(" Error al expireItem NOTA [NotaBO] ", e);
			throw new NotaBOException(e.getMessage());

		}

		return rows;
	}



}
