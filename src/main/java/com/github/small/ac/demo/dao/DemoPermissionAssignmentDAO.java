package com.github.small.ac.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.github.small.ac.abst.AbstractEntity;
import com.github.small.ac.conc.Permission;
import com.github.small.ac.conc.PermissionAssignment;
import com.github.small.ac.conc.Role;
import com.github.small.ac.other.BasicUtil;

public class DemoPermissionAssignmentDAO extends DemoBinaryRelationDAO<PermissionAssignment, Permission, Role> {

	public DemoPermissionAssignmentDAO() {
		super(PermissionAssignment.class, Permission.class, Role.class);
	}

	@Override
	public List<PermissionAssignment> findByReferencedEntities(Permission permission, Role role) {
		List<PermissionAssignment> list = new ArrayList<>();
		UUID referencedId1 = permission.getId();
		UUID referencedId2 = role.getId();
		for (AbstractEntity entity : this.entities) {
			PermissionAssignment permissionAssignment = (PermissionAssignment) entity;
			UUID id1 = permissionAssignment.getPermission().getId();
			UUID id2 = permissionAssignment.getRole().getId();
			if (referencedId1.equals(id1) && referencedId2.equals(id2)) {
				list.add(permissionAssignment);
			}
		}
		return list;
	}

	@Override
	public boolean existsByReferencedEntities(Permission permission, Role role) {
		return BasicUtil.isNotEmpty(findByReferencedEntities(permission, role));
	}
}
