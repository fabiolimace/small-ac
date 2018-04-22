package com.github.small.ac;

import java.util.ArrayList;
import java.util.List;

import com.github.small.ac.abst.dao.AbstractOperationDAO;
import com.github.small.ac.abst.dao.AbstractPermissionAssignmentDAO;
import com.github.small.ac.abst.dao.AbstractPermissionDAO;
import com.github.small.ac.abst.dao.AbstractResourceDAO;
import com.github.small.ac.abst.dao.AbstractRoleDAO;
import com.github.small.ac.abst.dao.AbstractRoleHierarchyDAO;
import com.github.small.ac.abst.dao.AbstractSessionDAO;
import com.github.small.ac.abst.dao.AbstractSessionRoleDAO;
import com.github.small.ac.abst.dao.AbstractUserAssignmentDAO;
import com.github.small.ac.abst.dao.AbstractUserDAO;
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
import com.github.small.ac.other.BasicException;

public class AccessControlFacade {

	private AbstractUserDAO userDAO;
	private AbstractRoleDAO roleDAO;
	private AbstractResourceDAO resourceDAO;
	private AbstractOperationDAO operationDAO;
	private AbstractPermissionDAO permissionDAO;
	private AbstractUserAssignmentDAO userAssignmentDAO;
	private AbstractPermissionAssignmentDAO permissionAssignmentDAO;
	private AbstractRoleHierarchyDAO roleHierarchyDAO;
	private AbstractSessionDAO sessionDAO;
	private AbstractSessionRoleDAO sessionRoleDAO;

	public AccessControlFacade() {
		
	}
	
	/******************************************/
	/** BEGINNING OF Core RBAC specification **/
	/******************************************/

	/**
	 * Returns all users in the set of users (USERS).
	 * 
	 * @return List<User>
	 */
	public List<User> getAllUsers() {

		try {
			return userDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * Checks if a given user exists in the set of users (USERS).
	 * 
	 * @param user User
	 * @return boolean
	 */
	public boolean existsUser(User user){
		return userDAO.exists(user);
	}
	
	/**
	 * Returns all roles in the set of roles (ROLES).
	 * 
	 * @return List<Role>
	 */
	public List<Role> getAllRoles() {

		try {
			return roleDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Checks if a given role exists in the set of roles (ROLES).
	 * 
	 * @param role Role
	 * @return boolean
	 */
	public boolean existsRole(Role role){
		return roleDAO.exists(role);
	}
	
	/**
	 * Returns all operations in the set of operations (OPS).
	 * 
	 * @return List<Operation>
	 */
	public List<Operation> getAllOperations() {

		try {
			return operationDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Checks if a given operation exists in the set of operations (OPS).
	 * 
	 * @param operation Operation
	 * @return boolean
	 */
	public boolean existsOperation(Operation operation){
		return operationDAO.exists(operation);
	}
	
	/**
	 * Returns all resources in the set of resources (OBS).
	 * 
	 * @return List<Resource>
	 */
	public List<Resource> getAllResources() {

		try {
			return resourceDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Checks if a given resource exists in the set of resources (OBS).
	 * 
	 * @param resource Resource
	 * @return boolean
	 */
	public boolean existsResource(Resource resource){
		return resourceDAO.exists(resource);
	}
	
	/**
	 * Returns all permissions in the set of permissions (PRMS).
	 * 
	 * PRMS = 2 ^ (OPS x OBS)
	 * 
	 * @return List<Permission>
	 */
	public List<Permission> getAllPermissions() {

		try {
			return permissionDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Checks if a given permission exists in the set of permissions (PRMS).
	 * 
	 * @param permission Permission
	 * @return boolean
	 */
	public boolean existsPermission(Permission permission){
		return permissionDAO.exists(permission);
	}
	
	/**
	 * Checks if a given permission, consisting of a pair operation x resource,
	 * exists in the set of permissions (PRMS).
	 * 
	 * @param operation Operation
	 * @param resource Resource
	 * @return boolean
	 */
	public boolean existsPermission(Operation operation, Resource resource) {
		try {
			for (Permission i : getAllPermissions()){
				if((i.getResource().equals(resource)) && (i.getOperation().equals(operation))){
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Returns all user assignments in the set of user assignments to roles (UA).
	 * A user assignment is a many-to-many mapping user-to-role assignment relation.
	 * 
	 * UA C= USERS x ROLES
	 * 
	 * @return List<UserAssignment>
	 */
	public List<UserAssignment> getAllUserAssignments() {
		try {
			return userAssignmentDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Checks if a given user assignment exists in the set of user assignments 
	 * to roles (UA).
	 * 
	 * @param permission Permission
	 * @return boolean
	 */
	public boolean existsUserAssignment(UserAssignment userAssignment){
		return userAssignmentDAO.exists(userAssignment);
	}

	/**
	 * Checks if a given user assignment, consisting of a pair user x role,
	 * exists in the set of user assignments to roles (UA).
	 * 
	 * @param user User
	 * @param role Role
	 * @return boolean
	 */
	public boolean existsUserAssignment(User user, Role role) {
		try {
			for (UserAssignment i : getAllUserAssignments()){
				if((i.getUser().equals(user)) && (i.getRole().equals(role))){
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Returns all permission assignments in the set of permission assignments
	 * to roles (PA).
	 * A permission assignment is a many-to-many mapping permission-to-role assignment 
	 * relation.
	 * 
	 * PA C= PERMS x ROLES
	 * 
	 * @return List<PermissionAssignment>
	 */
	public List<PermissionAssignment> getAllPermissionAssignments() {
		try {
			return permissionAssignmentDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Checks if a given permission assignment, consisting of a pair 
	 * permission x role, exists in the set of permission assignments 
	 * to roles (PA).
	 * 
	 * @param permission Permission
	 * @param role Role
	 * @return boolean
	 */
	public boolean existsPermissionAssignment(Permission permission, Role role) {
		try {
			for (PermissionAssignment i : getAllPermissionAssignments()){
				if((i.getPermission().equals(permission)) && (i.getRole().equals(role))){
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Returns the users that have been assigned to a given role
	 * The function assigned_users is the mapping of a role onto a set of users.
	 * 
	 * assigned_users(r:ROLES) -> 2 ^ USERS
	 * 
	 * Formally: 
	 * assigned_users(r) -> { u E USERS | (u, r) E UA }
	 * 
	 * @param role
	 * @return List<User>
	 */
	public List<User> getAssignedUsers(Role role) {
		return role.getAssignedUsers();
	}

	/**
	 * Returns the users that have been assigned to a given role
	 * The function assigned_users is the mapping of a role onto a set of users.
	 * 
	 * assigned_permissions(r:ROLES) -> 2 ^ PERMS
	 * 
	 * Formally:
	 * assigned_permissions(r) -> { p E PRMS | (p, r) E PA} 
	 * 
	 * @param role
	 * @return List<Permission>
	 */
	public List<Permission> getAssignedPermissions(Role role) {
		return role.getAssignedPermissions();
	}

	/**
	 * Returns the operation associated with a permission.
	 * 
	 * Op(p: PRMS) -> {op C= OPS}
	 * 
	 * @param permission Permission
	 * @return Operation
	 */
	public Operation getOperation(Permission permission) {
		return permission.getOperation();
	}
	
	/**
	 * Returns the resource associated with a given permission.
	 * 
	 * Ob(p: PRMS) -> {ob C= OBS}
	 * 
	 * @param permission Permission
	 * @return Resource
	 */
	public Resource getResource(Permission permission) {
		return permission.getResource();
	}

	/**
	 * Returns all sessions in the set of sessions (SESSIONS).
	 * 
	 * @return List<Session>
	 */
	public List<Session> getAllSessions() {
		// TODO
		return null;
	}

	/**
	 * Checks if a given session exists in the set of sessions (SESSIONS).
	 * 
	 * @param session Session
	 * @return boolean
	 */
	public boolean existsSession(Session session) {
		return sessionDAO.exists(session); 
	}
	
	/**
	 * Returns the user associated with a given session.
	 * 
	 * session_users(s:SESSIONS) -> USERS
	 * 
	 * @param session Session
	 * @return User
	 */
	public User getSessionUser(Session session) {
		return session.getUser();
	}

	// session_roles(s: SESSIONS)
	/**
	 * Returns the set of roles associated with a given session.
	 * 
	 * session_roles(s:SESSIONS) -> 2 ^ ROLES
	 * 
	 * Formally:
	 * session_roles(si) C= {r E ROLES | (session_users(si), r) E UA}
	 * 
	 * @param session Session
	 * @return List<Role>
	 */
	public List<Role> getSessionRoles(Session session) {
		return session.getRoles();
	}

	/**
	 * Returns the set of permissions available to session.
	 * 
	 * avail_session_perms(s:SESSIONS) -> 2 ^ PRMS
	 * 
	 * @param session Session
	 * @return List<Permission>
	 */
	public List<Permission> getAvailableSessionPermissions(Session session) {

		List<Permission> permissions = new ArrayList<Permission>();

		for (Role role : session.getRoles()) {
			permissions.addAll(role.getAssignedPermissions());
		}

		return permissions;
	}

	/******************************************/
	/** END OF Core RBAC specification       **/
	/******************************************/

	/******************************************/
	/** BEGINNING OF General Role Hierarchies **/
	/******************************************/

	// RH C= ROLES × ROLES
	public List<RoleHierarchy> getAllRoleHierarchies() {
		try {
			return roleHierarchyDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean existsRoleHierarchy(Role ascendantRole, Role descendantRole) {
		try {
			for (RoleHierarchy i : getAllRoleHierarchies()){
				if((i.getAscendantRole().equals(ascendantRole)) && (i.getDescendantRole().equals(descendantRole))){
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean existRoleHierarchies(Role ascendantRole, List<Role> descendantRoles) {
		try {
			for (RoleHierarchy i : getAllRoleHierarchies()){
				for (Role j: descendantRoles){
					if((i.getAscendantRole().equals(ascendantRole)) && (i.getDescendantRole().equals(j))){
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// TODO: authorized_users(r:ROLES)
	public List<User> getAuthorizedUsers(Role role) {
		return role.getAuthorizedUsers();
	}

	// TODO: authorized_permissions(r:ROLES)
	public List<Permission> getAuthorizedPermissions(Role role) {
		return role.getAuthorizedPermissions();
	}

	/*************************************/
	/** END OF General Role Hierarchies **/
	/*************************************/

	
	/* 6.1 Core RBAC */
	/* 6.1.1 Administrative Commands for Core RBAC */
	
	public void addUser(User user) {

		if (!userDAO.exists(user))
			userDAO.insert(user);
		else
			throw new BasicException("User already exists.");

	}

	public void deleteUser(User user) {

		if (userDAO.exists(user))
			userDAO.delete(user);
		else
			throw new BasicException("User doesn't exist.");
	}

	public void addRole(Role role) {

		if (!roleDAO.exists(role))
			roleDAO.insert(role);
		else
			throw new BasicException("Role already exists.");
	}

	public void deleteRole(Role role) {

		if (roleDAO.exists(role))
			roleDAO.delete(role);
		else
			throw new BasicException("Role doesn't exist.");
	}

	public void addResource(Resource resource) {

		if (!resourceDAO.exists(resource))
			resourceDAO.insert(resource);
		else
			throw new BasicException("Resource already exists.");

	}

	public void removeResource(Resource resource) {

		if (resourceDAO.exists(resource))
			resourceDAO.delete(resource);
		else
			throw new BasicException("Resource doesn't exist.");
	}

	public void addOperation(Operation operation) {

		if (!operationDAO.exists(operation))
			operationDAO.insert(operation);
		else
			throw new BasicException("Operation already exists.");
	}

	public void removeOperation(Operation operation) {

		if (operationDAO.exists(operation))
			operationDAO.delete(operation);
		else
			throw new BasicException("Operation doesn't exist.");
	}

	public void addPermission(Permission permission) {

		if (!permissionDAO.exists(permission))
			permissionDAO.insert(permission);
		else
			throw new BasicException("Permission already exists.");
	}

	public void removePermission(Permission permission) {

		if (permissionDAO.exists(permission))
			permissionDAO.delete(permission);
		else
			throw new BasicException("Permission doesn't exist.");
	}

	public void assignUser(User user, Role role) {

		if (userDAO.exists(user) && roleDAO.exists(role)) {

			UserAssignment userAssignment = new UserAssignment(user, role);
			userAssignmentDAO.insert(userAssignment);

		} else {
			throw new BasicException("User or role doesn't exist.");
		}
	}

	public void deassignUser(User user, Role role) {

		if (userDAO.exists(user) && roleDAO.exists(role)) {

			UserAssignment userAssignment = userAssignmentDAO.find(
					user.getId(), role.getId());

			userAssignmentDAO.delete(userAssignment);

			user.removeUserAssignment(userAssignment);
			role.removeUserAssignment(userAssignment);

		} else {
			throw new BasicException("User or role doesn't exist.");
		}

	}

	public void grantPermission(Permission permission, Role role) {

		if (permissionDAO.exists(permission) && roleDAO.exists(role)) {

			PermissionAssignment permissionAssignment = new PermissionAssignment(
					permission, role);
			permissionAssignmentDAO.insert(permissionAssignment);
		}
	}

	public void grantPermission(Resource resource, Operation operation,
			Role role) {

		if (resourceDAO.exists(resource) && operationDAO.exists(operation)
				&& roleDAO.exists(role)) {

			Permission permission = permissionDAO.find(resource.getId(),
					operation.getId());

			grantPermission(permission, role);
		}
	}

	public void revokePermission(Permission permission, Role role) {
		if (permissionDAO.exists(permission) && roleDAO.exists(role)) {

			PermissionAssignment permissionAssignment = permissionAssignmentDAO
					.find(permission.getId(), role.getId());

			permissionAssignmentDAO.delete(permissionAssignment);

			permission.removePermissionAssignment(permissionAssignment);
			role.removePermissionAssignment(permissionAssignment);
		}
	}

	public void revokePermission(Resource resource, Operation operation,
			Role role) {

		if (resourceDAO.exists(resource) && operationDAO.exists(operation)
				&& roleDAO.exists(role)) {

			Permission permission = permissionDAO.find(resource.getId(),
					operation.getId());

			revokePermission(permission, role);

		}
	}

	public List<Role> getAscendants(Role role) {
		return role.getAscendants();
	}

	public List<Role> getDescendants(Role role) {
		return role.getDescendants();
	}

	public boolean isValidInheritance(Role ascendantRole, Role descendantRole) {

		return (RoleHierarchy.isValid(ascendantRole, descendantRole));

	}

	public void addInheritance(Role ascendantRole, Role descendantRole)
			throws BasicException {

		if (isValidInheritance(ascendantRole, descendantRole)) {

			RoleHierarchy roleHierarchy = new RoleHierarchy();

			roleHierarchy.setAscendantRole(ascendantRole);
			roleHierarchy.setDescendantRole(descendantRole);

			ascendantRole.addAscendantHierarchy(roleHierarchy);
			descendantRole.addDescendantHierarchy(roleHierarchy);

			roleHierarchyDAO.insert(roleHierarchy);

		} else {
			throw new BasicException("Invalid role inheritance.");
		}
	}

	public void deleteInheritance(Role ascendantRole, Role descendantRole) {

		RoleHierarchy roleHierarchy = roleHierarchyDAO.find(
				ascendantRole.getId(), descendantRole.getId());

		roleHierarchy.setAscendantRole(null);
		roleHierarchy.setDescendantRole(null);

		ascendantRole.removeAscendantHierarchy(roleHierarchy);
		descendantRole.removeDescendantHierarchy(roleHierarchy);

		roleHierarchyDAO.delete(roleHierarchy);
	}

	public void addAscendant(Role ascendantRole, Role descendantRole)
			throws BasicException {
		addRole(ascendantRole);
		addInheritance(ascendantRole, descendantRole);
	}

	public void addDescendant(Role ascendantRole, Role descendantRole)
			throws BasicException {
		addRole(descendantRole);
		addInheritance(ascendantRole, descendantRole);
	}
	
	public Session createSession(User user, List<Role> roles) {
		
		//if (existsUser(user) && existUserAssignments(user, roles)) {
		if (existsUser(user)) {
			
			Session session = new Session(user);
			sessionDAO.insert(session);
			
			for (Role i : roles) {
				SessionRole sessionRole = new SessionRole(session, i);
				sessionRoleDAO.insert(sessionRole);
				session.addSessionRole(sessionRole);
				i.addSessionRole(sessionRole);
			}
			
			sessionDAO.update(session);
			
			return session;

		} 
		return null;
	}
	
	public void deleteSession(Session session) {
		
		session = sessionDAO.find(session.getId());
		
		for (SessionRole i : session.getSessionRoles()) {
			sessionRoleDAO.delete(i);
		}
		
		sessionDAO.delete(session);
	}

	public void addActiveRole(Session session, Role role) {

		if (existsSession(session) && existsRole(role)) {
			
			SessionRole sessionRole = new SessionRole(session, role);
			sessionRoleDAO.insert(sessionRole);
			session.addSessionRole(sessionRole);
			role.addSessionRole(sessionRole);
			
		} else {
			throw new BasicException("Session or roles don't exist.");
		}
	}

	public void dropActiveRole(Session session, Role role) {

		if (existsSession(session) && existsRole(role)) {

			SessionRole sessionRole = sessionRoleDAO.find(
					session.getId(), role.getId());
			sessionRoleDAO.delete(sessionRole);
			session.removeSessionRole(sessionRole);
			role.removeSessionRole(sessionRole);

		} else {
			throw new BasicException("User or role doesn't exist.");
		}
	}
	
	public boolean checkAccess(Session session, Operation operation, Resource resource) {
		
		if (existsSession(session) && existsOperation(operation) && existsResource(resource)) {
			for(Role role: getSessionRoles(session)) {
				for(Permission permission: role.getAssignedPermissions()) {
					return (permission.getOperation().equals(operation) && permission.getResource().equals(resource));
				}
			}
		}
		
		return false ;
		
	}
	
	public List<Permission> getRolePermissions(Role role){
		if(existsRole(role)){
			return role.getPermissions();
		}
		return null;
	}
	
	public List<Permission> getUserPermissions(User user){
		if(existsUser(user)){
			return user.getPermissions();
		}
		return null;
	}
	
	public List<Permission> getSessionPermissions(Session session) {
		if(existsSession(session)){
			return session.getPermissions();
		}
		return null;
	}
	
	public List<Operation> getRoleOperationsOnResource(Role role, Resource resource) {
		if(existsRole(role) && existsResource(resource)){
			return role.getOperationsOnResource(resource);
		}
		return null;
	}
	
	public List<Operation> getUserOperationsOnResource(User user, Resource resource) {
		if(existsUser(user) && existsResource(resource)){
			return user.getOperationsOnResource(resource);
		}
		return null;
	}
	
}
