package mx.com.amx.unotv.adminservice.dao;

import java.io.Serializable;

import java.util.List;




public interface GenericDao<T, PK extends Serializable> {

	int create(T t);

	T findById(PK id);

	int update(T t);

	void delete(PK id);

	List<T> findAll();
}
