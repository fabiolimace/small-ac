package com.github.small.ac.abst.dao;

import java.util.UUID;

import com.github.small.ac.conc.Session;

public abstract class AbstractSessionDAO extends AbstractEntityDAO<Session, UUID> {

	public AbstractSessionDAO() {
		super(Session.class);
	}
}
