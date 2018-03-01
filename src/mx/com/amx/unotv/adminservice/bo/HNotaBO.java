/**
 * 
 */
package mx.com.amx.unotv.adminservice.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import mx.com.amx.unotv.adminservice.bo.exception.HNotaBOException;
import mx.com.amx.unotv.adminservice.bo.exception.NotaBOException;
import mx.com.amx.unotv.adminservice.dao.HNotaDAO;
import mx.com.amx.unotv.adminservice.model.HNota;
import mx.com.amx.unotv.adminservice.model.IHNotaUsuario;
import mx.com.amx.unotv.adminservice.model.NNota;
import mx.com.amx.unotv.adminservice.model.request.ItemsFilterRequest;
import mx.com.amx.unotv.adminservice.model.request.ItemsRequest;
import mx.com.amx.unotv.adminservice.model.request.ItemsRequestByTitle;
import mx.com.amx.unotv.adminservice.model.response.ItemsResponse;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class HNotaBO {

	/** The logger. */
	private Logger logger = Logger.getLogger(HNotaBO.class);

	/** The h nota DAO. */
	@Autowired
	HNotaDAO hNotaDAO;
	@Autowired
	IHNotaUsuarioBO iHNotaUsuarioBO;
	
	
	public Integer getNoNotas(String date) throws HNotaBOException {
		Integer res = 0;

		try {
			res =hNotaDAO.getNoNotas(date);
		} catch (Exception e) {

			logger.error(" Error getNoNotas H-NOTA [ HNotaBO ] ", e);
			throw new HNotaBOException(e.getMessage());

		}

		return res;
	}


	public int update(NNota nota) throws HNotaBOException {
		logger.info("--- update  [ HNotaBO ] ---- ");
		int rows = 0;

		try {
			
			rows = hNotaDAO.update(nota);
			/*

			IHNotaUsuario iHNotaUsuario = new IHNotaUsuario();
			iHNotaUsuario.setFcIdContenido(nota.getFcIdContenido());
			iHNotaUsuario.setFcIdUsuario(nota.getFcIdUsuario());
			iHNotaUsuario.setFcIdEstatus(nota.getFcIdEstatus());

			rows = iHNotaUsuarioBO.insert(iHNotaUsuario);

			if (rows > 0) {
				rows = 0;

				rows = hNotaDAO.update(nota);

			}*/

		} catch (Exception e) {

			logger.error(" Error al update H-NOTA [ HNotaBO ] ", e);
			throw new HNotaBOException(e.getMessage());

		}

		return rows;
	}

	/**
	 * Inserta la nota en las tablas NNota y HNota
	 *
	 * @param NNota
	 * @return int
	 * @throws NotaBOException
	 *             the nota BO exception
	 */
	public int insert(NNota nota) throws HNotaBOException {
		logger.info("--- insert  [ HNotaBO ] ---- ");
		int rows = 0;

		try {

			rows = hNotaDAO.insert(nota);
			/*
			if (rows == 1) {
				rows = 0;
				IHNotaUsuario iHNotaUsuario = new IHNotaUsuario();
				iHNotaUsuario.setFcIdContenido(nota.getFcIdContenido());
				iHNotaUsuario.setFcIdUsuario(nota.getFcIdUsuario());
				iHNotaUsuario.setFcIdEstatus(nota.getFcIdEstatus());

				rows = iHNotaUsuarioBO.insert(iHNotaUsuario);
			}*/

		} catch (Exception e) {

			logger.error(" Error al insertar H-NOTA [ HNotaBO ] ", e);
			throw new HNotaBOException(e.getMessage());

		}

		return rows;
	}

	/**
	 * Gets the list items by filter.
	 *
	 * @param ItemsFilterRequest
	 * @return List<ItemsResponse>
	 * @throws NotaBOException
	 */
	public List<ItemsResponse> getListItemsByFilter(ItemsFilterRequest req) throws HNotaBOException {
		List<ItemsResponse> lista = null;

		try {
			lista = hNotaDAO.getListItemsByFilter(req);

		} catch (Exception e) {

			logger.error(" Error getListItemsByTitle  [ HNotaBO ] ", e);
			throw new HNotaBOException(e.getMessage());

		}

		return lista;
	}

	/**
	 * Gets the list items by title.
	 *
	 * @param ItemsRequestByTitle
	 * @return List<ItemsResponse>
	 * @throws NotaBOException
	 */
	public List<ItemsResponse> getListItemsByTitle(ItemsRequestByTitle req) throws HNotaBOException {

		List<ItemsResponse> lista = null;

		try {
			lista = hNotaDAO.getListItemsByTitle(req);

		} catch (Exception e) {

			logger.error(" Error getListItemsByTitle  [ HNotaBO ] ", e);
			throw new HNotaBOException(e.getMessage());

		}

		return lista;

	}

	/**
	 * Gets the list items.
	 *
	 * @param ItemsRequest
	 * @return List<ItemsResponse>
	 * @throws NotaBOException
	 */
	public List<ItemsResponse> getListItems(ItemsRequest req) throws HNotaBOException {
		List<ItemsResponse> lista = null;
		try {
			lista = hNotaDAO.getListItems(req);

		} catch (Exception e) {

			logger.error(" Error getListItems  [ HNotaBO ] ", e);
			throw new HNotaBOException(e.getMessage());

		}

		return lista;
	}

	/**
	 * obtiene la lista de las nota en la tabla HNota.
	 *
	 * @return List<HNota>
	 * @throws NotaBOException
	 */
	public List<HNota> findAll() throws HNotaBOException {
		List<HNota> lista = null;

		try {
			lista = hNotaDAO.findAll();

		} catch (Exception e) {

			logger.error(" Error FindAll  [ HNotaBO ] ", e);
			throw new HNotaBOException(e.getMessage());

		}

		return lista;

	}

	/**
	 * obtiene informacion de la tabla HNota.
	 *
	 * @param String
	 *            idContenido
	 * @return HNota
	 * @throws NotaBOException
	 *             the nota BO exception
	 */
	public HNota findById(String id) throws HNotaBOException {
		HNota nota = null;
		try {
			nota = hNotaDAO.findById(id);

		} catch (Exception e) {

			logger.error(" Error findById  [ HNotaBO ] ", e);
			throw new HNotaBOException(e.getMessage());

		}

		return nota;

	}

}
