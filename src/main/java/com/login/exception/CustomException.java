package com.login.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	private HttpStatus statusCode;

	public CustomException(String message, HttpStatus statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "CustomException [message=" + message + ", statusCode=" + statusCode + "]";
	}

}
