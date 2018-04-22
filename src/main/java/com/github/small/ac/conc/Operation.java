package com.github.small.ac.conc;

import static com.github.small.ac.other.BasicUtil.*;

import java.util.ArrayList;
import java.util.List;

import com.github.small.ac.abst.AbstractEntity;

public class Operation extends AbstractEntity {

	private static final long serialVersionUID = -8916973203411754846L;

	private String name;

	private List<Permission> permissions;

	public Operation() {
		this(null);
	}

	public Operation(String name) {
		super();
		this.name = name;
		this.setPermissions(permissions);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {

		if (isEmpty(permissions)) {
			this.permissions = new ArrayList<Permission>();
		} else {

			this.permissions = permissions;
			for (Permission i : permissions) {
				if (i.getOperation() != this)
					i.setOperation(this);
			}
		}
	}

	public void addPermission(Permission permission) {
		if (isNotIn(permissions, permission)) {
			this.permissions.add(permission);
			permission.setOperation(this, false);
		}
	}

	public void removePermission(Permission permission) {
		if (isIn(permissions, permission)) {
			this.permissions.remove(permission);
			permission.setOperation(null, false);
		}
	}

}
