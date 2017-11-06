package mx.com.amx.unotv.adminservice.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import mx.com.amx.unotv.adminservice.dao.exception.PcodeDAOException;

import mx.com.amx.unotv.adminservice.model.Pcode;
// TODO: Auto-generated Javadoc

/**
 * The Class PcodeDAO.
 *
 * @author Jesus A. Macias Benitez
 */
public class PcodeDAO {

	/** The logger. */
	private Logger logger = Logger.getLogger(PcodeDAO.class);

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Find all Pcode
	 *
	 * @return List<Pcode>
	 * @throws PcodeDAOException
	 */
	public List<Pcode> findAll() throws PcodeDAOException {
		List<Pcode> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT * FROM UNO_C_PCODE ");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Pcode>(Pcode.class));

		} catch (Exception e) {

			logger.error(" Error findById HNota [DAO] ", e);

			throw new PcodeDAOException(e.getMessage());

		}

		return lista;
	}
}
