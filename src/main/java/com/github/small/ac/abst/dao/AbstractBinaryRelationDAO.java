package com.github.small.ac.abst.dao;

public abstract class AbstractBinaryRelationDAO<T, A, B> extends AbstractEntityDAO<T> implements InterfaceBinaryRelationDAO<T, A, B>{

	protected Class<? extends A> referencedClazz1;
	protected Class<? extends B> referencedClazz2;
	
	public AbstractBinaryRelationDAO(Class<? extends T> clazz, Class<? extends A> referencedClazz1, Class<? extends B> referencedClazz2) {
		super(clazz);
		this.referencedClazz1 = referencedClazz1;
		this.referencedClazz2 = referencedClazz2;
	}
}
