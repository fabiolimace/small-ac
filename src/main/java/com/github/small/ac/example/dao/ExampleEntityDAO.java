package com.github.small.ac.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import com.github.small.ac.abst.dao.AbstractEntityDAO;
import com.github.small.ac.abst.AbstractEntity;

public class ExampleEntityDAO<T extends AbstractEntity> extends AbstractEntityDAO<T> {

	protected Set<T> entities;

	public ExampleEntityDAO(Class<? extends T> clazz) {
		super(clazz);
		this.entities = new TreeSet<>();
	}

	@Override
	public void insert(T entity) {
		this.entities.add(entity);
	}

	@Override
	public void update(T entity) {
		if (exists(entity)) {
			UUID id = (UUID) entity.getId();
			T old = find(id);
			if (old != null) {
				delete((T) old);
				insert(entity);
			}
		}
	}

	@Override
	public void delete(T entity) {
		this.entities.remove(entity);
	}

	@Override
	public List<T> list() {
		return new ArrayList<>(this.entities);
	}

	@Override
	public T find(UUID id) {
		for (T entity : this.entities) {
			if (entity.getId().equals(id)) {
				return entity;
			}
		}
		return null;
	}

	@Override
	public boolean exists(T entity) {
		return find((UUID) entity.getId()) != null;
	}

}
