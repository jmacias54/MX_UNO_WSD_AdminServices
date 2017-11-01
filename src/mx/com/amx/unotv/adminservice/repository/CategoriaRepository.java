package mx.com.amx.unotv.adminservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.amx.unotv.adminservice.model.Categoria;



public interface CategoriaRepository extends JpaRepository<Categoria, String>{
	
	public static final String FIND_BY_ID_CATEGORIA = "SELECT  c.fcIdCategoria , c.fcDescripcion  FROM Categoria c  WHERE c.unoCSeccion.fcIdSeccion =?1  ";
	
	
	@Query(value = FIND_BY_ID_CATEGORIA)
	public List<Categoria> findByIdCategoria(String idCategoria);

}
