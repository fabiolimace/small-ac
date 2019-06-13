package com.github.small.ac.conc;

import static com.github.small.ac.other.BasicUtil.*;

import java.util.ArrayList;
import java.util.List;

import com.github.f4b6a3.uuid.UuidCreator;
import com.github.small.ac.abst.AbstractEntity;

public class Permission extends AbstractEntity {

	protected static final long serialVersionUID = 9442952295444958L;

	private String name;

	private Resource resource;

	private Operation operation;

	private List<PermissionAssignment> permissionAssignments;

	public Permission() {
		this(null);
	}

	public Permission(String name) {
		this(name, null, null);
	}

	public Permission(Resource resource, Operation operation) {
		this(null, resource, operation);
	}

	public Permission(String name, Resource resource, Operation operation) {
		super();
		
		if (name != null)
			this.name = name;
		else
			this.name = getNameSuggestion();
			
		setResource(resource);
		setOperation(operation);
		setPermissionAssignments(permissionAssignments);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Resource getResource() {
		return resource;
	}

	public Operation getOperation() {
		return operation;
	}
	
	public void setResource(Resource resource) {
		this.setResource(resource, true);
	}

	public List<PermissionAssignment> getPermissionAssignments() {
		return permissionAssignments;
	}

	public void setResource(Resource resource, boolean bidirectional) {
		if (bidirectional) {
			if (this.resource != null) {
				this.resource.removePermission(this);
			}
			if (resource != null) {
				resource.addPermission(this);
			}
		} else {
			this.resource = resource;
		}
	}

	public void setOperation(Operation operation) {
		this.setOperation(operation, true);
	}
	
	public void setOperation(Operation operation, boolean bidirectional){
		if(bidirectional){
			if(this.operation !=null){
				this.operation.removePermission(this);
			}
			if(operation!=null){
				operation.addPermission(this);
			}
		} else {
			this.operation = operation;
		}
	}

	public void setPermissionAssignments(
			List<PermissionAssignment> permissionAssignments) {
		if (isEmpty(permissionAssignments)) {
			this.permissionAssignments = new ArrayList<PermissionAssignment>();
		} else {
			this.permissionAssignments = permissionAssignments;
			for (PermissionAssignment i : permissionAssignments) {
				if (i.getPermission() != this)
					i.setPermission(this);
			}
		}
	}

	public void addPermissionAssignment(
			PermissionAssignment permissionAssignment) {
		if(isNotIn(permissionAssignments, permissionAssignment)){
			permissionAssignments.add(permissionAssignment);
			permissionAssignment.setPermission(this, false);
		}
	}

	public void removePermissionAssignment(
			PermissionAssignment permissionAssignment) {
		if(isIn(permissionAssignments, permissionAssignment)){
			permissionAssignments.remove(permissionAssignment);
			permissionAssignment.setPermission(null, false);
		}
	}

	public List<Role> getRoles() {
		ArrayList<Role> roles = new ArrayList<Role>();
		for (PermissionAssignment i : this.getPermissionAssignments()) {
			roles.add(i.getRole());
		}
		return roles;
	}

	public String getNameSuggestion() {
		String nameSuggestion = "";

		if ((this.resource != null) && (this.operation != null)) {
			nameSuggestion = resource.getName() + "." + operation.getName();
		} else {
			if (this.resource != null) {
				nameSuggestion = resource.getName();
			} else if (this.operation != null) {
				nameSuggestion = operation.getName();
			} else {
				nameSuggestion = UuidCreator.getFastRandom().toString();
			}
		}

		return nameSuggestion;
	}
}
