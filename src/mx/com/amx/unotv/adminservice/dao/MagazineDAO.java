package mx.com.amx.unotv.adminservice.dao;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.dao.exception.MagazineDAOException;
import mx.com.amx.unotv.adminservice.model.IMagazineNota;
import mx.com.amx.unotv.adminservice.model.Magazine;

// TODO: Auto-generated Javadoc
/**
 * The Class MagazineDAO.
 *
 * @author Jesus A. Macias Benitez
 */
public class MagazineDAO {

	private Logger logger = Logger.getLogger(MagazineDAO.class);

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Gets the list magazine.
	 *
	 * @return the list magazine
	 * @throws MagazineDAOException
	 *             the magazine DAO exception
	 */
	public List<Magazine> getListMagazine() throws MagazineDAOException {
		List<Magazine> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT  * FROM uno_c_magazine  ");

		try {
			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Magazine>(Magazine.class));

		} catch (NullPointerException npe) {
			// TODO: handle exception
			return Collections.emptyList();
		} catch (Exception e) {
			new MagazineDAOException(e.getMessage());
		}

		return lista;
	}

	public Magazine getMagazineByIdMagazine(String idMagazine) throws MagazineDAOException {
		List<Magazine> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT  * FROM uno_c_magazine WHERE FC_ID_MAGAZINE = '" + idMagazine + "' ");

		try {
			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Magazine>(Magazine.class));

		} catch (NullPointerException npe) {
			// TODO: handle exception
			return new Magazine();
		} catch (Exception e) {
			new MagazineDAOException(e.getMessage());
		}

		return lista.get(0);
	}

	public int deleteIMagazineNota(String IdMagazine) throws MagazineDAOException {
		int rows = 0;
		StringBuilder query = new StringBuilder();

		query.append(" DELETE FROM uno_i_nota_magazine WHERE  FC_ID_MAGAZINE = '" + IdMagazine + "' ");
		try {

			rows = jdbcTemplate.update(query.toString());

		} catch (Exception e) {

			logger.error(" Error deleteIMagazineNota [ MagazineDAO ] ", e);

			throw new MagazineDAOException(e.getMessage());

		}

		return rows;

	}

	public int insertIMagazineNota(IMagazineNota magazineNota) throws MagazineDAOException {
		int rows = 0;

		try {
			rows = jdbcTemplate.update(" INSERT INTO uno_i_nota_magazine "
					+ " (FC_ID_MAGAZINE, FC_ID_CONTENIDO, FC_URL_EXTERNA, FI_ORDEN ) " + " VALUES (? , ?, ?, ?)",
					magazineNota.getFcIdMagazine(), magazineNota.getFcIdContenido(), magazineNota.getFcUrlExterna(),
					magazineNota.getFiOrden());

		} catch (Exception e) {

			logger.error(" Error al insertIMagazineNota [ MagazineDAO ] ", e);

			throw new MagazineDAOException(e.getMessage());

		}

		return rows;

	}

}
