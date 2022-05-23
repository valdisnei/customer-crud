package com.webfin.customers.exception;

public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = -3351478993169404910L;

	public InternalServerErrorException() {
		super();
	}

	public InternalServerErrorException(final String message) {
		super(message);
	}

	public InternalServerErrorException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public InternalServerErrorException(final Throwable cause) {
		super(cause);
	}
}
