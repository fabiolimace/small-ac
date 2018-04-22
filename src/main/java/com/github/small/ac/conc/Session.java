package com.github.small.ac.conc;

import static com.github.small.ac.other.BasicUtil.*;

import java.util.ArrayList;
import java.util.List;

import com.github.small.ac.abst.AbstractEntity;

public class Session extends AbstractEntity {

	private static final long serialVersionUID = 2779920911468962187L;

	private User user;

	private List<SessionRole> sessionRoles;

	public Session() {
		this(null);
	}

	public Session(User user) {
		super();
		setUser(user);
		setSessionRoles(sessionRoles);
	}

	// session_user(s:SESSIONS)
	public User getUser() {
		return user;
	}
	
	public List<SessionRole> getSessionRoles() {
		return sessionRoles;
	}
	
	public void setUser(User user) {
		this.setUser(user, true);
	}

	public void setUser(User user, boolean bidirectional) {
		if (bidirectional) {
			if(this.user != null) {
				this.user.removeSession(this);
			}
			if(user != null) {
				user.addSession(this);
			}
		} else {
			this.user = user;
		}
	}

	public void setSessionRoles(List<SessionRole> sessionRoles) {
		this.sessionRoles = sessionRoles;
		
		if (isEmpty(sessionRoles)){
			this.sessionRoles = new ArrayList<SessionRole>();
		} else {
			this.sessionRoles = sessionRoles;
			for (SessionRole i : sessionRoles) {
				if(i != null && i.getSession() != this)
					i.setSession(this);
			}
		}
	}

	public void addSessionRole(SessionRole sessionRole) {
		if(isNotIn(sessionRoles, sessionRole)) {
			sessionRoles.add(sessionRole);
			sessionRole.setSession(this, false);
		}
	}
	
	public void removeSessionRole(SessionRole sessionRole) {
		if(isIn(sessionRoles, sessionRole)) {
			sessionRoles.remove(sessionRole);
			sessionRole.setSession(null, false);
		}
	}
	
	public boolean containsSessionRole(SessionRole sessionRole) {
		return isNotEmpty(sessionRoles)
				&& sessionRoles.contains(sessionRole);
	}

	// session_roles(s:SESSIONS)
	public List<Role> getRoles() {
		ArrayList<Role> roles = new ArrayList<Role>();
		for (SessionRole i : this.getSessionRoles()) {
			roles.add(i.getRole());
		}
		return roles;
	}

	public List<Permission> getPermissions(){
		List<Permission> permissions = new ArrayList<Permission>();
		
		for(Role i : this.getRoles()) {
			for(Permission j : i.getAssignedPermissions()){
				if(isNotIn(permissions, j)){
					permissions.add(j);
				}
			}
		}
		return permissions;
	}
	// TODO
	// avail_session_perms(s:SESSIONS)
	public List<Permission> getAvailablePermissions() throws Exception{
		throw new Exception("Not implemented.");
	}
}
