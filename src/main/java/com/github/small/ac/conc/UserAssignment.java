package com.github.small.ac.conc;

import com.github.small.ac.abst.AbstractEntity;

public class UserAssignment extends AbstractEntity {

	private static final long serialVersionUID = 8336610593295917795L;

	private User user;

	private Role role;

	public UserAssignment() {
		this(null, null);
	}

	public UserAssignment(User user, Role role) {
		super();
		setUser(user);
		setRole(role);
	}

	public User getUser() {
		return user;
	}
	
	void internalSetUser(User user){
		this.user = user;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setUser(User user) {
		this.setUser(user, true);
	}
	
	public void setRole(Role role) {
		this.setRole(role, true);
	}
	
	public void setUser(User user, boolean bidirectional) {
		if (bidirectional) {
			if (this.user != null) {
				this.user.removeUserAssignment(this);
			}
			if (user != null) {
				user.addUserAssignment(this);
			}
		} else {
			this.user = user;
		}
	}
	
	public void setRole(Role role, boolean bidirectional) {
		if (bidirectional) {
			if (this.role != null) {
				role.removeUserAssignment(this);
			}
			if (role != null) {
				role.addUserAssignment(this);
			}
		} else {
			this.role = role;
		}
	}
}
