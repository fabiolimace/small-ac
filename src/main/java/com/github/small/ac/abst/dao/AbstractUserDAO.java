package com.github.small.ac.abst.dao;

import java.util.UUID;

import com.github.small.ac.conc.User;

public abstract class AbstractUserDAO extends AbstractEntityDAO<User, UUID> {

	public AbstractUserDAO() {
		super(User.class);
	}
}
