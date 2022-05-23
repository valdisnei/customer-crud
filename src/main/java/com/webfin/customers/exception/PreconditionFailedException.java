package com.webfin.customers.exception;

public class PreconditionFailedException extends RuntimeException {

	private static final long serialVersionUID = -3443006490853186494L;

	public PreconditionFailedException() {
		super();
	}

	public PreconditionFailedException(final String message) {
		super(message);
	}

	public PreconditionFailedException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public PreconditionFailedException(final Throwable cause) {
		super(cause);
	}
}
