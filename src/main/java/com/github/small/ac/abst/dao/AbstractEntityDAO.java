package com.github.small.ac.abst.dao;

public abstract class AbstractEntityDAO<T, K> implements InterfaceEntityDAO<T, K> {

	protected Class<? extends T> clazz;

	public AbstractEntityDAO(Class<? extends T> clazz) {
		this.clazz = clazz;
	}
}
