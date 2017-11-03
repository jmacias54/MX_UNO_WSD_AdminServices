package mx.com.amx.unotv.adminservice.bo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.bo.exception.UsuarioBOException;
import mx.com.amx.unotv.adminservice.dao.UsuarioDAO;
import mx.com.amx.unotv.adminservice.model.Usuario;
import mx.com.amx.unotv.adminservice.model.response.UserResponse;

public class UsuarioBO {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public List<UserResponse> getAll() throws UsuarioBOException {

		List<UserResponse> response = new LinkedList<UserResponse>();
		List<Usuario> iterable = null;

		try {
			iterable = usuarioDAO.findAll();

			for (Usuario usuario : iterable) {
				UserResponse user = new UserResponse();
				user.setIdUser(usuario.getFcIdUsuario());
				user.setName(usuario.getFcNombre());
				response.add(user);
			}
		} catch (Exception e) {
			new UsuarioBOException(e.getMessage());
		}

		return response;

	}

}
