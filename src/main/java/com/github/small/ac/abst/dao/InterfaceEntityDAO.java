package com.github.small.ac.abst.dao;

import java.util.List;

public interface InterfaceEntityDAO<T, K> {

	void insert(T entity);

	void update(T entity);

	void delete(T entity);

	List<T> list();

	T find(K id);
	
	boolean exists(T entity);
	
}
