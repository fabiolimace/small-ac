package com.github.small.ac.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.github.small.ac.abst.AbstractEntity;
import com.github.small.ac.conc.Operation;
import com.github.small.ac.conc.Permission;
import com.github.small.ac.conc.Resource;
import com.github.small.ac.other.BasicUtil;

public class ExamplePermissionDAO extends ExampleBinaryRelationDAO<Permission, Resource, Operation> {

	public ExamplePermissionDAO() {
		super(Permission.class, Resource.class, Operation.class);
	}

	@Override
	public List<Permission> findByReferencedEntities(Resource resource, Operation operation) {
		List<Permission> list = new ArrayList<>();
		UUID referencedId1 = resource.getId();
		UUID referencedId2 = operation.getId();
		for (AbstractEntity entity : this.entities) {
			Permission permission = (Permission) entity;
			UUID id1 = permission.getResource().getId();
			UUID id2 = permission.getOperation().getId();
			if (referencedId1.equals(id1) && referencedId2.equals(id2)) {
				list.add(permission);
			}
		}
		return list;
	}

	@Override
	public boolean existsByReferencedEntities(Resource resource, Operation operation) {
		return BasicUtil.isNotEmpty(findByReferencedEntities(resource, operation));
	}
}
