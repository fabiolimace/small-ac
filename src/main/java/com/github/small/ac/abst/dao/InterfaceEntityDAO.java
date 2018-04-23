package com.github.small.ac.abst.dao;

import java.util.List;
import java.util.UUID;

public interface InterfaceEntityDAO<T> {

	void insert(T entity);

	void update(T entity);

	void delete(T entity);

	List<T> list();

	T find(UUID id);
	
	boolean exists(T entity);
	
}
