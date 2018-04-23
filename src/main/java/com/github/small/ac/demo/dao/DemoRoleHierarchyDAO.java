package com.github.small.ac.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.github.small.ac.abst.AbstractEntity;
import com.github.small.ac.conc.Role;
import com.github.small.ac.conc.RoleHierarchy;
import com.github.small.ac.other.BasicUtil;

public class DemoRoleHierarchyDAO extends DemoBinaryRelationDAO<RoleHierarchy, Role, Role> {

	public DemoRoleHierarchyDAO() {
		super(RoleHierarchy.class, Role.class, Role.class);
	}

	@Override
	public List<RoleHierarchy> findByReferencedEntities(Role ascendantRole, Role descendantRole) {
		List<RoleHierarchy> list = new ArrayList<>();
		UUID referencedId1 = ascendantRole.getId();
		UUID referencedId2 = descendantRole.getId();
		for (AbstractEntity entity : this.entities) {
			RoleHierarchy roleHierarchy = (RoleHierarchy) entity;
			UUID id1 = roleHierarchy.getAscendantRole().getId();
			UUID id2 = roleHierarchy.getDescendantRole().getId();
			if (referencedId1.equals(id1) && referencedId2.equals(id2)) {
				list.add(roleHierarchy);
			}
		}
		return list;
	}

	@Override
	public boolean existsByReferencedEntities(Role ascendantRole, Role descendantRole) {
		return BasicUtil.isNotEmpty(findByReferencedEntities(ascendantRole, descendantRole));
	}
}