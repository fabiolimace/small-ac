package com.github.small.ac.abst.dao;

import java.util.UUID;

import com.github.small.ac.conc.Role;
import com.github.small.ac.conc.Session;
import com.github.small.ac.conc.SessionRole;

public abstract class AbstractSessionRoleDAO extends AbstractRelationDAO<SessionRole, UUID, Session, Role> {

	public AbstractSessionRoleDAO() {
		super(SessionRole.class, Session.class, Role.class);
	}
	
	public SessionRole find(UUID sessionid, UUID roleid) {
		return find(sessionid, roleid);
	}
}
