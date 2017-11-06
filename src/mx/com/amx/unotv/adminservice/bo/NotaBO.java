package mx.com.amx.unotv.adminservice.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import mx.com.amx.unotv.adminservice.bo.exception.NotaBOException;
import mx.com.amx.unotv.adminservice.dao.HNotaDAO;
import mx.com.amx.unotv.adminservice.dao.NNotaDAO;
import mx.com.amx.unotv.adminservice.model.HNota;
import mx.com.amx.unotv.adminservice.model.NNota;
import mx.com.amx.unotv.adminservice.model.response.ItemsResponse;
import mx.com.amx.unotv.adminservice.model.resquest.ItemsFilterRequest;
import mx.com.amx.unotv.adminservice.model.resquest.ItemsRequest;
import mx.com.amx.unotv.adminservice.model.resquest.ItemsRequestByTitle;

public class NotaBO {

	private Logger logger = Logger.getLogger(NotaBO.class);

	@Autowired
	NNotaDAO nNotaDAO;

	@Autowired
	HNotaDAO hNotaDAO;
	
	
	public List<ItemsResponse> getListItemsByFilter(ItemsFilterRequest req)throws NotaBOException{
	List<ItemsResponse> lista = null;
		
		try {
			lista = hNotaDAO.getListItemsByFilter(req);

		} catch (Exception e) {

			logger.error(" Error getListItemsByTitle H-NOTA [NotaBO] ", e);
			throw new NotaBOException(e.getMessage());

		}

		return lista;
	}

	public  List<ItemsResponse> getListItemsByTitle(ItemsRequestByTitle req) throws NotaBOException {

		List<ItemsResponse> lista = null;
		
		try {
			lista = hNotaDAO.getListItemsByTitle(req);

		} catch (Exception e) {

			logger.error(" Error getListItemsByTitle H-NOTA [NotaBO] ", e);
			throw new NotaBOException(e.getMessage());

		}

		return lista;

	}

	public List<ItemsResponse> getListItems(ItemsRequest req) throws NotaBOException {
		List<ItemsResponse> lista = null;
		try {
			lista = hNotaDAO.getListItems(req);

		} catch (Exception e) {

			logger.error(" Error getListItems H-NOTA [NotaBO] ", e);
			throw new NotaBOException(e.getMessage());

		}

		return lista;
	}

	public List<HNota> findAll() throws NotaBOException {
		List<HNota> lista = null;

		try {
			lista = hNotaDAO.findAll();

		} catch (Exception e) {

			logger.error(" Error FindAll H-NOTA [NotaBO] ", e);
			throw new NotaBOException(e.getMessage());

		}

		return lista;

	}

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
