package com.github.small.ac.abst.dao;

import java.util.UUID;

import com.github.small.ac.conc.Role;
import com.github.small.ac.conc.User;
import com.github.small.ac.conc.UserAssignment;

public abstract class AbstractUserAssignmentDAO extends AbstractRelationDAO<UserAssignment, UUID, User, Role> {

	public AbstractUserAssignmentDAO() {
		super(UserAssignment.class, User.class, Role.class);
	}

	public UserAssignment find(UUID userid, UUID roleid) {
		return find(userid, roleid);
	}

}
