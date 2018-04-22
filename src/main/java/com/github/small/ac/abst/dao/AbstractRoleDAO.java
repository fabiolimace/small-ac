package com.github.small.ac.abst.dao;

import java.util.UUID;

import com.github.small.ac.conc.Role;

public abstract class AbstractRoleDAO extends AbstractEntityDAO<Role, UUID> {

	public AbstractRoleDAO() {
		super(Role.class);
	}

}
