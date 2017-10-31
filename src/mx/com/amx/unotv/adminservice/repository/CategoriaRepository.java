package mx.com.amx.unotv.adminservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.amx.unotv.adminservice.model.Categoria;



public interface CategoriaRepository extends CrudRepository<Categoria, String>{

}
