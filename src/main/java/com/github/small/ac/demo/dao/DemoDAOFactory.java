package com.github.small.ac.demo.dao;

import com.github.small.ac.abst.dao.AbstractBinaryRelationDAO;
import com.github.small.ac.abst.dao.AbstractDAOFactory;
import com.github.small.ac.abst.dao.AbstractEntityDAO;
import com.github.small.ac.conc.Operation;
import com.github.small.ac.conc.Permission;
import com.github.small.ac.conc.PermissionAssignment;
import com.github.small.ac.conc.Resource;
import com.github.small.ac.conc.Role;
import com.github.small.ac.conc.RoleHierarchy;
import com.github.small.ac.conc.Session;
import com.github.small.ac.conc.SessionRole;
import com.github.small.ac.conc.User;
import com.github.small.ac.conc.UserAssignment;

public class DemoDAOFactory extends AbstractDAOFactory {

	@Override
	public AbstractEntityDAO<User> getUserDAO() {
		return new DemoUserDAO();
	}

	@Override
	public AbstractEntityDAO<Role> getRoleDAO() {
		return new DemoRoleDAO();
	}

	@Override
	public AbstractEntityDAO<Resource> getResourceDAO() {
		return new DemoResourceDAO();
	}

	@Override
	public AbstractEntityDAO<Operation> getOperationDAO() {
		return new DemoOperationDAO();
	}

	@Override
	public AbstractEntityDAO<Session> getSessionDAO() {
		return new DemoSessionDAO();
	}

	@Override
	public AbstractBinaryRelationDAO<Permission, Resource, Operation> getPermissionDAO() {
		return new DemoPermissionDAO();
	}

	@Override
	public AbstractBinaryRelationDAO<UserAssignment, User, Role> getUserAssignmentDAO() {
		return new DemoUserAssignment();
	}

	@Override
	public AbstractBinaryRelationDAO<PermissionAssignment, Permission, Role> getPermissionAssignmentDAO() {
		return new DemoPermissionAssignmentDAO();
	}

	@Override
	public AbstractBinaryRelationDAO<RoleHierarchy, Role, Role> getRoleHierarchyDAO() {
		return new DemoRoleHierarchyDAO();
	}

	@Override
	public AbstractBinaryRelationDAO<SessionRole, Session, Role> getSessionRoleDAO() {
		return new DemoSessionRoleDAO();
	}
}
