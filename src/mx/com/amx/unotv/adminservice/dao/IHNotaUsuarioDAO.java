/**
 * 
 */
package mx.com.amx.unotv.adminservice.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

		logger.info(" --- Inicio insert [ IHNotaUsuarioDAO ]  --- ");
		int rows = 0;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		try {

			rows = jdbcTemplate.update(" INSERT INTO uno_i_h_nota_usuario"
										+ " (FC_ID_USUARIO,FC_ID_CONTENIDO,FD_FECHA_MODIFICACION,FC_ID_ESTATUS) "
										+ "	VALUES ( ? ,? ,? ,?) ", 
										iHNotaUsuario.getFcIdUsuario(),iHNotaUsuario.getFcIdContenido(),
										dateFormat.format(new Date()),iHNotaUsuario.getFcIdEstatus());

		} catch (Exception e) {

			logger.error(" Error insert  IHNotaUsuario  [ IHNotaUsuarioDAO ] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		return rows;
	}
	
	
	/* obtiene al ultimo usuario que inserto o modifico la nota */
	public IHNotaUsuario findByIdContenido(String idContenido) throws NNotaDAOException{
		logger.info(" --- Inicio findByIdContenido [ IHNotaUsuarioDAO ]  --- ");
		List<IHNotaUsuario> lista = null;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT  * FROM uno_i_h_nota_usuario  ");
		query.append(" WHERE  FC_ID_CONTENIDO = '"+idContenido+"' ");
		query.append(" ORDER BY FD_FECHA_MODIFICACION DESC ");
		query.append(" LIMIT 1 ");
		
		try {

			logger.info("Ejecuta QRY : "+query);
			lista = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<IHNotaUsuario>(IHNotaUsuario.class));
			
			
		} catch (Exception e) {

			logger.error(" Error   findByIdContenido  [ IHNotaUsuarioDAO ] ", e);

			throw new NNotaDAOException(e.getMessage());

		}
		
		return lista.get(0) ;
		
	}

}
