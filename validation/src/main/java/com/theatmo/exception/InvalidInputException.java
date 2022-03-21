package com.theatmo.exception;

import com.theatmo.exception.CustomException;

public class InvalidInputException extends RuntimeException {

	public InvalidInputException(String message) {
		super(message);
	}

}
