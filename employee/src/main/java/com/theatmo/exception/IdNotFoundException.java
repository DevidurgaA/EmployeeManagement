package com.theatmo.exception;

import com.theatmo.exception.CustomException;

public class IdNotFoundException extends CustomException {
	
	public IdNotFoundException(String message) {
		super(message);
	}
}
