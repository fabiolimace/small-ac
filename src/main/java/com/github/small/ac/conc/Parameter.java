package com.github.small.ac.conc;

import com.github.small.ac.abst.AbstractEntity;

public class Parameter extends AbstractEntity {

	private static final long serialVersionUID = -6115318093725947626L;

	private String name;
	
	private String value;
	
	public Parameter() {
		super();
	}
	
	public Parameter(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
