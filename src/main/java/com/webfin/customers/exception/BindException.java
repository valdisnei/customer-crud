package com.webfin.customers.exception;

public class BindException extends RuntimeException {

	private static final long serialVersionUID = -7537893710779049592L;

	public BindException() {
		super();
	}

	public BindException(final String message) {
		super(message);
	}

	public BindException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public BindException(final Throwable cause) {
		super(cause);
	}
}
