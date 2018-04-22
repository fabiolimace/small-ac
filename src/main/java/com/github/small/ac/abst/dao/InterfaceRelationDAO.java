package com.github.small.ac.abst.dao;

public interface InterfaceRelationDAO<T, K, A, B> {

	T find(K referencedId1, K referencedId2);
	
}
