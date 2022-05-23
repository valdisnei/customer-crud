package com.webfin.customers.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4114772604227292944L;

	public NotFoundException() {
		super();
	}

	public NotFoundException(final String message) {
		super(message);
	}

	public NotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NotFoundException(final Throwable cause) {
		super(cause);
	}
}
