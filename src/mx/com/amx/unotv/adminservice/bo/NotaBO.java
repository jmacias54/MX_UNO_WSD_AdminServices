/*
 * 
 */
package mx.com.amx.unotv.adminservice.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import mx.com.amx.unotv.adminservice.bo.exception.NotaBOException;
import mx.com.amx.unotv.adminservice.dao.HNotaDAO;
import mx.com.amx.unotv.adminservice.dao.IHNotaUsuarioDAO;
import mx.com.amx.unotv.adminservice.dao.NNotaDAO;
import mx.com.amx.unotv.adminservice.model.HNota;
import mx.com.amx.unotv.adminservice.model.IHNotaUsuario;
import mx.com.amx.unotv.adminservice.model.NNota;
import mx.com.amx.unotv.adminservice.model.request.ItemsFilterRequest;
import mx.com.amx.unotv.adminservice.model.request.ItemsRequest;
import mx.com.amx.unotv.adminservice.model.request.ItemsRequestByTitle;
import mx.com.amx.unotv.adminservice.model.response.ItemsResponse;

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
	
	
	/**
	 * Gets the list items by magazine.
	 *
	 * @param String idMagazine 
	 * @return List<ItemsResponse> 
	 * @throws NotaBOException 
	 */
	public List<ItemsResponse> getListItemsByMagazine(String idMagazine)throws NotaBOException{
		List<ItemsResponse> lista = null;
		
		try {
			lista = nNotaDAO.getListItemsByMagazine(idMagazine);

		} catch (Exception e) {

			logger.error(" Error getListItemsByTitle H-NOTA [NotaBO] ", e);
			throw new NotaBOException(e.getMessage());

		}

		
		return lista ;
	}

	
	
	/**
	 * Gets the list items by filter.
	 *
	 * @param ItemsFilterRequest
	 * @return List<ItemsResponse> 
	 * @throws NotaBOException 
	 */
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

	/**
	 * Gets the list items by title.
	 *
	 * @param ItemsRequestByTitle
	 * @return List<ItemsResponse>
	 * @throws NotaBOException 
	 */
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

	/**
	 * Gets the list items.
	 *
	 * @param ItemsRequest
	 * @return List<ItemsResponse>
	 * @throws NotaBOException 
	 */
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

	/**
	 * obtiene la lista de las nota en la tabla HNota.
	 *
	 * @return  List<HNota>
	 * @throws NotaBOException 
	 */
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

	/**
	 * Inserta la nota en las tablas NNota y HNota
	 *
	 * @param NNota
	 * @return int
	 * @throws NotaBOException the nota BO exception
	 */
	public int insert(NNota nota) throws NotaBOException {
		logger.info("--- insert  [NotaBO] ---- ");
		int rows = 0;

		try {

			rows = nNotaDAO.insert(nota);
			if (rows == 1)
				rows = hNotaDAO.insert(nota);
			if (rows == 1)
				rows = hNotaDAO.insert(nota);

		} catch (Exception e) {

			logger.error(" Error al insertar N-NOTA [NotaBO] ", e);
			throw new NotaBOException(e.getMessage());

		}

		return rows;
	}
	
	public int update(NNota nota) throws NotaBOException {
		logger.info("--- update  [NotaBO] ---- ");
		int rows = 0;

		try {

			rows = nNotaDAO.update(nota);
			if (rows == 1) {
				rows = 0;
				rows = hNotaDAO.update(nota);
				if (rows == 1) {
					rows = 0;
					IHNotaUsuario iHNotaUsuario = new IHNotaUsuario();
					iHNotaUsuario.setFcIdContenido(nota.getFcIdContenido());
					iHNotaUsuario.setFcIdUsuario(nota.getFcIdUsuario());

					rows = iHNotaUsuarioDAO.insert(iHNotaUsuario);
				}
			}

		} catch (Exception e) {

			logger.error(" Error al update N-NOTA [NotaBO] ", e);
			throw new NotaBOException(e.getMessage());

		}

		return rows;
	}
	
	public int expireItem(NNota nota) throws NotaBOException {
		logger.info("--- expireItem  [NotaBO] ---- ");
		int rows = 0;

		try {

			rows = nNotaDAO.delete(nota.getFcIdContenido());
			if (rows == 1) {
				rows = 0;
				rows = hNotaDAO.expire(nota);
				if (rows == 1) {
					rows = 0;
					IHNotaUsuario iHNotaUsuario = new IHNotaUsuario();
					iHNotaUsuario.setFcIdContenido(nota.getFcIdContenido());
					iHNotaUsuario.setFcIdUsuario(nota.getFcIdUsuario());

					rows = iHNotaUsuarioDAO.insert(iHNotaUsuario);
				}
			}

		} catch (Exception e) {

			logger.error(" Error al expireItem NOTA [NotaBO] ", e);
			throw new NotaBOException(e.getMessage());

		}

		return rows;
	}

	/**
	 * obtiene informacion de la tabla HNota.
	 *
	 * @param String idContenido 
	 * @return HNota
	 * @throws NotaBOException the nota BO exception
	 */
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
