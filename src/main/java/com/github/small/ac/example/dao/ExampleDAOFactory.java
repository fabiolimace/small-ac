package com.github.small.ac.example.dao;

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

public class ExampleDAOFactory extends AbstractDAOFactory {

	@Override
	public AbstractEntityDAO<User> getUserDAO() {
		return new ExampleUserDAO();
	}

	@Override
	public AbstractEntityDAO<Role> getRoleDAO() {
		return new ExampleRoleDAO();
	}

	@Override
	public AbstractEntityDAO<Resource> getResourceDAO() {
		return new ExampleResourceDAO();
	}

	@Override
	public AbstractEntityDAO<Operation> getOperationDAO() {
		return new ExampleOperationDAO();
	}

	@Override
	public AbstractEntityDAO<Session> getSessionDAO() {
		return new ExampleSessionDAO();
	}

	@Override
	public AbstractBinaryRelationDAO<Permission, Resource, Operation> getPermissionDAO() {
		return new ExamplePermissionDAO();
	}

	@Override
	public AbstractBinaryRelationDAO<UserAssignment, User, Role> getUserAssignmentDAO() {
		return new ExampleUserAssignment();
	}

	@Override
	public AbstractBinaryRelationDAO<PermissionAssignment, Permission, Role> getPermissionAssignmentDAO() {
		return new ExamplePermissionAssignmentDAO();
	}

	@Override
	public AbstractBinaryRelationDAO<RoleHierarchy, Role, Role> getRoleHierarchyDAO() {
		return new ExampleRoleHierarchyDAO();
	}

	@Override
	public AbstractBinaryRelationDAO<SessionRole, Session, Role> getSessionRoleDAO() {
		return new ExampleSessionRoleDAO();
	}
}
