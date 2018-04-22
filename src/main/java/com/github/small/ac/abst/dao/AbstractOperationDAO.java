package com.github.small.ac.abst.dao;

import java.util.UUID;

import com.github.small.ac.conc.Operation;

public abstract class AbstractOperationDAO extends AbstractEntityDAO<Operation, UUID> {

	public AbstractOperationDAO() {
		super(Operation.class);
	}
}
