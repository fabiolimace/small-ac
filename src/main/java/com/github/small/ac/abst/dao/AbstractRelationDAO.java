package com.github.small.ac.abst.dao;

public abstract class AbstractRelationDAO<T, K, A, B> extends AbstractEntityDAO<T, K>
		implements InterfaceRelationDAO<T, K, A, B> {

	protected Class<? extends T> clazz;
	protected Class<? extends A> referencedClazz1;
	protected Class<? extends B> referencedClazz2;

	public AbstractRelationDAO(Class<? extends T> clazz, Class<? extends A> referencedClazz1, Class<? extends B> referencedClazz2) {
		super(clazz);

		this.clazz = clazz;

		this.referencedClazz1 = referencedClazz1;
		this.referencedClazz2 = referencedClazz2;

	}
}
