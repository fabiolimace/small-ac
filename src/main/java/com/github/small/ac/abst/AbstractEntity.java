package com.github.small.ac.abst;

import java.io.Serializable;
import java.util.UUID;
import com.github.small.uuid.UUIDGenerator;

public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = -4889778148919221961L;

	protected UUID id;

	public AbstractEntity() {
		super();
		this.id = UUIDGenerator.getCustomUUID();
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractEntity)) {
			return false;
		}
		AbstractEntity other = (AbstractEntity) obj;
		return getId().equals(other.getId());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
