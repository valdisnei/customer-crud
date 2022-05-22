package com.webfin.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -2658643264403220076L;

	public BadRequestException() {
		super();
	}

	public BadRequestException(final String message) {
		super(message);
	}

	public BadRequestException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public BadRequestException(final Throwable cause) {
		super(cause);
	}

}
