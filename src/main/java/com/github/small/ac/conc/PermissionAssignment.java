package com.github.small.ac.conc;

import com.github.small.ac.abst.AbstractEntity;

public class PermissionAssignment extends AbstractEntity {

	private static final long serialVersionUID = 8147721080580819873L;

	private Role role;

	private Permission permission;

	public PermissionAssignment() {
		this(null, null);
	}

	public PermissionAssignment(Permission permission, Role role) {
		super();
		setPermission(permission);
		setRole(role);
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.setRole(role, true);
	}

	public void setRole(Role role, boolean bidirectional) {
		if (bidirectional) {
			if (this.role != null) {
				this.role.removePermissionAssignment(this);
			}
			if (role != null) {
				role.addPermissionAssignment(this);
			}
		} else {
			this.role = role;
		}
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.setPermission(permission, true);
	}

	public void setPermission(Permission permission, boolean bidirectional) {
		if (bidirectional) {
			if (this.permission != null) {
				this.permission.removePermissionAssignment(this);
			}
			if (permission != null) {
				permission.addPermissionAssignment(this);
			}
		} else {
			this.permission = permission;
		}
	}
}
