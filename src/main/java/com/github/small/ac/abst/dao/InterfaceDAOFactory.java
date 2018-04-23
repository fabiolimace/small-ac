package com.github.small.ac.abst.dao;

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

public interface InterfaceDAOFactory {
	
	AbstractEntityDAO<User> getUserDAO();
	AbstractEntityDAO<Role> getRoleDAO();
	AbstractEntityDAO<Resource> getResourceDAO();
	AbstractEntityDAO<Operation> getOperationDAO();
	AbstractEntityDAO<Session> getSessionDAO();
	
	AbstractBinaryRelationDAO<Permission, Resource, Operation> getPermissionDAO();
	AbstractBinaryRelationDAO<UserAssignment, User, Role> getUserAssignmentDAO();
	AbstractBinaryRelationDAO<PermissionAssignment, Permission, Role> getPermissionAssignmentDAO();
	AbstractBinaryRelationDAO<RoleHierarchy, Role, Role> getRoleHierarchyDAO();
	AbstractBinaryRelationDAO<SessionRole, Session, Role> getSessionRoleDAO();
}
