package com.github.small.ac.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.github.small.ac.conc.Role;
import com.github.small.ac.conc.Session;
import com.github.small.ac.conc.SessionRole;
import com.github.small.ac.other.BasicUtil;

public class ExampleSessionRoleDAO extends ExampleBinaryRelationDAO<SessionRole, Session, Role> {

	public ExampleSessionRoleDAO() {
		super(SessionRole.class, Session.class, Role.class);
	}

	@Override
	public List<SessionRole> findByReferencedEntities(Session session, Role role) {
		List<SessionRole> list = new ArrayList<>();
		UUID referencedId1 = session.getId();
		UUID referencedId2 = role.getId();
		for (SessionRole entity : this.entities) {
			SessionRole sessionRole = (SessionRole) entity;
			UUID id1 = sessionRole.getSession().getId();
			UUID id2 = sessionRole.getRole().getId();
			if (referencedId1.equals(id1) && referencedId2.equals(id2)) {
				list.add(sessionRole);
			}
		}
		return list;
	}

	@Override
	public boolean existsByReferencedEntities(Session session, Role role) {
		return BasicUtil.isNotEmpty(findByReferencedEntities(session, role));
	}
}
