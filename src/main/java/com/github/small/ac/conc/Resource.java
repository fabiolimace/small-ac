package com.github.small.ac.conc;

import static com.github.small.ac.other.BasicUtil.*;

import java.util.ArrayList;
import java.util.List;

import com.github.small.ac.abst.AbstractEntity;

public class Resource extends AbstractEntity { 

	private static final long serialVersionUID = -2178433618340576060L;

	private String name;

	private List<Permission> permissions;

	public Resource() {
		this(null);
	}

	public Resource(String name) {
		super();
		this.name = name;

		init();
	}

	private void init() {
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
				if (i.getResource() != this)
					i.setResource(this);
			}
		}
	}

	public void addPermission(Permission permission) {
		if (isNotIn(permissions, permission)) {
			permissions.add(permission);
			permission.setResource(this, false);
		}
	}

	public void removePermission(Permission permission) {
		if (isIn(permissions, permission)) {
			permissions.remove(permission);
			permission.setResource(null, false);
		}
	}
}
