package com.github.small.ac.abst.dao;

import java.util.UUID;

import com.github.small.ac.conc.Resource;

public abstract class AbstractResourceDAO extends AbstractEntityDAO<Resource, UUID> {

	public AbstractResourceDAO() {
		super(Resource.class);
	}
}
