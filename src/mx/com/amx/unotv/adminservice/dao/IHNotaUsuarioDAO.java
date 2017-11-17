/**
 * 
 */
package mx.com.amx.unotv.adminservice.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.adminservice.dao.exception.NNotaDAOException;
import mx.com.amx.unotv.adminservice.model.IHNotaUsuario;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class IHNotaUsuarioDAO {
	
	/** The logger. */
	private Logger logger = Logger.getLogger(IHNotaUsuarioDAO.class);
	
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public int insert(IHNotaUsuario iHNotaUsuario) throws NNotaDAOException {

		int rows = 0;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		try {

			rows = jdbcTemplate.update(" INSERT INTO uno_i_h_nota_usuario (FC_ID_USUARIO,FC_ID_CONTENIDO,FD_FECHA_MODIFICACION,FC_ID_ESTATUS) VALUES ( ? ,? ,? ,?) ", 
										iHNotaUsuario.getFcIdUsuario(),iHNotaUsuario.getFcIdContenido(),dateFormat.format(new Date()),iHNotaUsuario.getFcIdEstatus());

		} catch (Exception e) {

			logger.error(" Error insert  IHNotaUsuario  [IHNotaUsuarioDAO] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		return rows;
	}

}
