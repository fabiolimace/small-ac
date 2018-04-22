package com.github.small.ac.abst.dao;

import java.util.UUID;

import com.github.small.ac.conc.Operation;
import com.github.small.ac.conc.Permission;
import com.github.small.ac.conc.Resource;

public abstract class AbstractPermissionDAO extends AbstractRelationDAO<Permission, UUID, Resource, Operation> {

	public AbstractPermissionDAO() {
		super(Permission.class, Resource.class, Operation.class);
	}

	public Permission find(UUID resourceid, UUID operationid) {
		return find(resourceid, operationid);
	}

}
