package mx.com.amx.unotv.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.amx.unotv.adminservice.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
