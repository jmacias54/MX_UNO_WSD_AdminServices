package mx.com.amx.unotv.adminservice.bo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.amx.unotv.adminservice.model.Usuario;
import mx.com.amx.unotv.adminservice.model.response.UserResponse;
import mx.com.amx.unotv.adminservice.repository.UsuarioRepository;

public class UsuarioBO {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UserResponse> getAll() {

		List<UserResponse> response = new LinkedList<UserResponse>();

		Iterable<Usuario> iterable = usuarioRepository.findAll();

		for (Usuario usuario : iterable) {
			UserResponse user = new UserResponse();
			user.setIdUser(usuario.getFcIdUsuario());
			user.setName(usuario.getFcNombre());
			response.add(user);
		}

		return response;

	}

}
