package com.pitech.order_app_backend.exceptions;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		super();
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
}