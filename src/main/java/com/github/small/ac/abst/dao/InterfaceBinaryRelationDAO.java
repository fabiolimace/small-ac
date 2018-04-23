package com.github.small.ac.abst.dao;

import java.util.List;

public interface InterfaceBinaryRelationDAO<T, A, B> {
	List<T> findByReferencedEntities(A referencedEntity1, B referencedEntity2);
	boolean existsByReferencedEntities(A referencedEntity1, B referencedEntity2);
}
