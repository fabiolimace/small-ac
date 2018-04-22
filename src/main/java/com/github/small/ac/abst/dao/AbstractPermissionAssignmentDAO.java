package com.github.small.ac.abst.dao;

import java.util.UUID;

import com.github.small.ac.conc.Permission;
import com.github.small.ac.conc.PermissionAssignment;
import com.github.small.ac.conc.Role;

public abstract class AbstractPermissionAssignmentDAO extends AbstractRelationDAO<PermissionAssignment, UUID, Permission, Role> {

	public AbstractPermissionAssignmentDAO() {
		super(PermissionAssignment.class, Permission.class, Role.class);
	}

	public PermissionAssignment find(UUID permissionId, UUID roleId) {
		return find(permissionId, roleId);
	}
}
