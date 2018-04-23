package com.github.small.ac.abst.dao;

import com.github.small.ac.reflection.Reflection;

public abstract class AbstractEntityDAO<T> implements InterfaceEntityDAO<T> {

	protected Class<? extends T> clazz;
	protected Reflection reflection;

	public AbstractEntityDAO(Class<? extends T> clazz) {
		this.clazz = clazz;
		this.reflection = new Reflection(clazz);
	}
}
