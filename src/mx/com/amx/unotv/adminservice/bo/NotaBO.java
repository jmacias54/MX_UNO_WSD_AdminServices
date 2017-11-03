package mx.com.amx.unotv.adminservice.bo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mx.com.amx.unotv.adminservice.bo.exception.NotaBOException;
import mx.com.amx.unotv.adminservice.dao.HNotaDAO;
import mx.com.amx.unotv.adminservice.dao.NNotaDAO;
import mx.com.amx.unotv.adminservice.model.HNota;
import mx.com.amx.unotv.adminservice.model.NNota;

public class NotaBO {

	private Logger logger = Logger.getLogger(NotaBO.class);

	@Autowired
	NNotaDAO nNotaDAO;

	@Autowired
	HNotaDAO hNotaDAO;

	@Transactional
	public int insert(NNota nota) throws NotaBOException {
		logger.info("--- insert  [NotaBO] ---- ");
		int rows = 0;

		try {

			rows = nNotaDAO.insert(nota);
			if (rows == 1)
				rows = hNotaDAO.insert(nota);

		} catch (Exception e) {

			logger.error(" Error al insertar N-NOTA [NotaBO] ", e);
			throw new NotaBOException(e.getMessage());

		}

		return rows;
	}

	public HNota findById(String id) throws NotaBOException {
		HNota nota = null;
		try {
			nota = hNotaDAO.findById(id);

		} catch (Exception e) {

			logger.error(" Error findById H-NOTA [NotaBO] ", e);
			throw new NotaBOException(e.getMessage());

		}

		return nota;

	}

}
