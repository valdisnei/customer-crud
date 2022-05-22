package com.webfin.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

@RestControllerAdvice
public class RestExceptionHandler {

	@ResponseBody
	@ResponseStatus(INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ErrorResponse handleException(Exception exception, HttpServletRequest request) {
		return new ErrorResponse(new Date(), INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR.name(), exception.getMessage(),
				request.getServletPath());
	}

	@ResponseBody
	@ResponseStatus(INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Throwable.class)
	public ErrorResponse handleThrowable(Throwable exception, HttpServletRequest request) {
		return new ErrorResponse(new Date(), INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR.name(), exception.getMessage(),
				request.getServletPath());
	}

	@ResponseBody
	@ResponseStatus(INTERNAL_SERVER_ERROR)
	@ExceptionHandler(InternalServerErrorException.class)
	public ErrorResponse handleInternalServerError(InternalServerErrorException exception, HttpServletRequest request) {
		return new ErrorResponse(new Date(), INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR.name(), exception.getMessage(),
				request.getServletPath());
	}

	@ResponseBody
	@ResponseStatus(NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ErrorResponse handleNotFound(NotFoundException exception, HttpServletRequest request) {
		return new ErrorResponse(new Date(), NOT_FOUND.value(), NOT_FOUND.name(), exception.getMessage(), request.getServletPath());
	}

	@ResponseBody
	@ResponseStatus(BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public ErrorResponse handleBadRequest(BadRequestException exception, HttpServletRequest request) {
		return new ErrorResponse(new Date(), BAD_REQUEST.value(), BAD_REQUEST.name(), exception.getMessage(), request.getServletPath());
	}

	@ResponseBody
	@ResponseStatus(PRECONDITION_FAILED)
	@ExceptionHandler(PreconditionFailedException.class)
	public ErrorResponse handlePreconditionFailed(PreconditionFailedException exception, HttpServletRequest request) {
		return new ErrorResponse(new Date(), PRECONDITION_FAILED.value(), PRECONDITION_FAILED.name(), exception.getMessage(),
				request.getServletPath());
	}

	@ResponseBody
	@ResponseStatus(PRECONDITION_FAILED)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponse handleException(MethodArgumentNotValidException exception, HttpServletRequest request) {
		return new ErrorResponse(new Date(), BAD_REQUEST.value(), BAD_REQUEST.name(), exception.getMessage(), request.getServletPath());
	}

}
