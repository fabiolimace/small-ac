package com.github.small.ac.mock.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import com.github.small.ac.abst.dao.AbstractEntityDAO;
import com.github.small.ac.abst.AbstractEntity;

public class MockEntityDAO extends AbstractEntityDAO<AbstractEntity, UUID> {

	private Set<AbstractEntity> entities;

	public MockEntityDAO(Class<? extends AbstractEntity> clazz) {
		super(clazz);
		this.entities = new TreeSet<>();
	}

	@Override
	public void insert(AbstractEntity entity) {
		this.entities.add(entity);
	}

	@Override
	public void update(AbstractEntity entity) {
		if (exists(entity)) {
			UUID id = entity.getId();
			AbstractEntity old = find(id);
			if (old != null) {
				delete(old);
				insert(entity);
			}
		}
	}

	@Override
	public void delete(AbstractEntity entity) {
		this.entities.remove(entity);
	}

	@Override
	public List<AbstractEntity> list() {
		return new ArrayList<>(this.entities);
	}

	@Override
	public AbstractEntity find(UUID id) {
		for (AbstractEntity entity : this.entities) {
			if (entity.getId().equals(id)) {
				return entity;
			}
		}
		return null;
	}

	@Override
	public boolean exists(AbstractEntity entity) {
		return find(entity.getId()) != null;
	}

}
