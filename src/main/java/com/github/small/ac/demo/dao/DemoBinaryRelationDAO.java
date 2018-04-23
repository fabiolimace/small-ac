package com.github.small.ac.demo.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import com.github.small.ac.abst.AbstractEntity;
import com.github.small.ac.abst.dao.AbstractBinaryRelationDAO;

public abstract class DemoBinaryRelationDAO<T extends AbstractEntity, A extends AbstractEntity, B extends AbstractEntity>
		extends AbstractBinaryRelationDAO<T, A, B> {

	protected Set<T> entities;
	protected DemoEntityDAO<T> entityDAO; // Inheritance by decoration

	public DemoBinaryRelationDAO(Class<? extends T> clazz, Class<? extends A> referencedClazz1,
			Class<? extends B> referencedClazz2) {
		super(clazz, referencedClazz1, referencedClazz2);
		this.entities = new TreeSet<>();
		this.entityDAO = new DemoEntityDAO<>(clazz);
	}

	@Override
	public void insert(T entity) {
		this.entityDAO.insert(entity);
	}

	@Override
	public void update(T entity) {
		this.entityDAO.update(entity);
	}

	@Override
	public void delete(T entity) {
		this.entityDAO.delete(entity);
	}

	@Override
	public List<T> list() {
		return this.entityDAO.list();
	}

	@Override
	public T find(UUID id) {
		return (T) this.entityDAO.find(id);
	}

	@Override
	public boolean exists(T entity) {
		return this.entityDAO.exists(entity);
	}

	@Override
	public abstract List<T> findByReferencedEntities(A referencedEntity1, B referencedEntity2);

	@Override
	public abstract boolean existsByReferencedEntities(A referencedEntity1, B referencedEntity2);
}
