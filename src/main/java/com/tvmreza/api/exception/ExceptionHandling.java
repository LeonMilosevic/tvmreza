package com.tvmreza.api.exception;

import java.util.Objects;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tvmreza.api.entities.HttpResponse;
import com.tvmreza.api.exception.domain.CategoryDoesNotExistException;
import com.tvmreza.api.exception.domain.CategoryException;
import com.tvmreza.api.exception.domain.HtppRequestMethodNotSupportedException;
import com.tvmreza.api.exception.domain.NotEnoughPermissionException;

@RestControllerAdvice
public class ExceptionHandling {
	private static final String METHOD_IS_NOT_ALLOWED = "This request method is not allowed on this endpoint. Please send a '%s' request.";
	private static final String INTERNAL_SERVER_ERROR_MSG = "An error has occured while processing the request";
	private static final String NOT_ENOUGH_PERMISSION = "You do not have permission to view this";
	private static final String CATEGORY_ERROR = "Error, order must be bigger than 0, category name must not be empty, category name must be unique.";
	private static final String CATEGORY_DOES_NOT_EXIST = "Category does not exist, please try again.";

	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<HttpResponse> categoryErrorException() {
		return createHttpResponse(HttpStatus.BAD_REQUEST, CATEGORY_ERROR);
	}

	@ExceptionHandler(CategoryDoesNotExistException.class)
	public ResponseEntity<HttpResponse> categoryDoesNotExistErrorException() {
		return createHttpResponse(HttpStatus.NOT_FOUND, CATEGORY_DOES_NOT_EXIST);
	}

	@ExceptionHandler(NotEnoughPermissionException.class)
	public ResponseEntity<HttpResponse> notEnoughPermissionException() {
		return createHttpResponse(HttpStatus.FORBIDDEN, NOT_ENOUGH_PERMISSION);
	}

	@ExceptionHandler(HtppRequestMethodNotSupportedException.class)
	public ResponseEntity<HttpResponse> methodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
		HttpMethod supportedMethod = Objects.requireNonNull(exception.getSupportedHttpMethods()).iterator().next();
		return createHttpResponse(HttpStatus.METHOD_NOT_ALLOWED, String.format(METHOD_IS_NOT_ALLOWED, supportedMethod));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<HttpResponse> internalServerErrorException(Exception exception) {
		return createHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MSG);
	}

	private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message) {
		return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus,
				httpStatus.getReasonPhrase().toUpperCase(), message.toUpperCase()), httpStatus);
	}
}
