/**
 * 
 */
package mx.com.amx.unotv.adminservice.dao;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import mx.com.amx.unotv.adminservice.dao.exception.IHNotaTagDAOException;
import mx.com.amx.unotv.adminservice.model.IHNotaTag;
import mx.com.amx.unotv.adminservice.model.Tag;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class IHNotaTagDAO {
	

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static Logger logger = Logger.getLogger(IHNotaTagDAO.class);
	
	
	public int insert(IHNotaTag iHNotaTag) throws IHNotaTagDAOException {
		int rows = 0;

		try {
			rows = jdbcTemplate.update("INSERT INTO uno_i_h_nota_tags (FC_ID_CONTENIDO,FC_ID_TAG) VALUES( ?, ?) ",iHNotaTag.getFcIdContenido(),iHNotaTag.getFcIdTag());

		} catch (Exception e) {

			logger.error(" Error insert [ I_H_NotaTagDAO ] ", e);

			throw new IHNotaTagDAOException(e.getMessage());

		}

		return rows;

	}
	
	
	public int delete(String idContenido) throws IHNotaTagDAOException {
		int rows = 0;

		try {
			rows = jdbcTemplate.update(" DELETE FROM uno_i_h_nota_tags WHERE FC_ID_CONTENIDO = ?   ",idContenido);

		} catch (Exception e) {

			logger.error(" Error delete [ I_H_NotaTagDAO ] ", e);

			throw new IHNotaTagDAOException(e.getMessage());

		}

		return rows;

	}
	
	
	public List<Tag> getByIdContenido(String idContenido)  throws IHNotaTagDAOException {
		List<Tag> lista = null;
		
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT iHNotaTag.FC_ID_CONTENIDO, ");
		query.append(" 	      iHNotaTag.FC_ID_TAG, ");
		query.append("        cTag.FC_DESCRIPCION, ");
		query.append("        cTag.FI_ESTATUS ");
		query.append(" FROM  uno_i_h_nota_tags iHNotaTag ");
		query.append(" INNER JOIN uno_c_tags cTag ON  iHNotaTag.FC_ID_TAG = cTag.FC_ID_TAG ");
		query.append(" where iHNotaTag.FC_ID_CONTENIDO = '"+idContenido+"' ");

		try {
			lista = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<Tag>(Tag.class));

		} catch (NullPointerException npe) {
			// TODO: handle exception
			return Collections.emptyList();
		} catch (Exception e) {
			new IHNotaTagDAOException(e.getMessage());
		}

		return lista;
	}

}
