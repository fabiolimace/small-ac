package com.github.small.ac.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.github.small.ac.abst.AbstractEntity;
import com.github.small.ac.conc.Role;
import com.github.small.ac.conc.User;
import com.github.small.ac.conc.UserAssignment;
import com.github.small.ac.other.BasicUtil;

public class DemoUserAssignment extends DemoBinaryRelationDAO<UserAssignment, User, Role> {

	public DemoUserAssignment() {
		super(UserAssignment.class, User.class, Role.class);
	}

	@Override
	public List<UserAssignment> findByReferencedEntities(User user, Role role) {
		List<UserAssignment> list = new ArrayList<>();
		UUID referencedId1 = user.getId();
		UUID referencedId2 = role.getId();
		for (AbstractEntity entity : this.entities) {
			UserAssignment userAssignment = (UserAssignment) entity;
			UUID id1 = userAssignment.getUser().getId();
			UUID id2 = userAssignment.getRole().getId();
			if (referencedId1.equals(id1) && referencedId2.equals(id2)) {
				list.add(userAssignment);
			}
		}
		return list;
	}

	@Override
	public boolean existsByReferencedEntities(User user, Role role) {
		return BasicUtil.isNotEmpty(findByReferencedEntities(user, role));
	}
}
