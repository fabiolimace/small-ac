package com.github.small.ac.abst.dao;

import java.util.UUID;

import com.github.small.ac.conc.Role;
import com.github.small.ac.conc.RoleHierarchy;

public abstract class AbstractRoleHierarchyDAO extends
		AbstractRelationDAO<RoleHierarchy, UUID, Role, Role> {

	public AbstractRoleHierarchyDAO() {
		super(RoleHierarchy.class, Role.class, Role.class);
	}
	
	public RoleHierarchy find(UUID ascendantRoleId, UUID descendantRoleId) {
		return find(ascendantRoleId, descendantRoleId);
	}

}
