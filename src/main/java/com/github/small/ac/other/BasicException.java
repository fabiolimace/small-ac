package com.github.small.ac.other;

public class BasicException extends RuntimeException {

	private static final long serialVersionUID = -6322141382910309264L;

	public BasicException() {
	}

	public BasicException(String message) {
		super(message);
	}

	public BasicException(String message, Throwable cause) {
		super(message, cause);
	}

	public BasicException(Throwable cause) {
		super(cause);
	}

}
