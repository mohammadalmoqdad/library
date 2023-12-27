package com.library.DAOs;

import java.util.List;

// Generic DAO to implement the basic methods that will be implemented for each DAO.
// The ability to add additional methods for each single DAO is still maintained.
public interface DAO<T> {
	List<T> findAll();
	
	T findById(String id);
	
	T save(T t);
	
	T update(String id, T t);
	
	void delete(String id);
}
