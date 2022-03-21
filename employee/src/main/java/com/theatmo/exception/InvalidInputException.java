package com.theatmo.exception;

import com.theatmo.exception.CustomException;

public class InvalidInputException extends CustomException {
	
	public InvalidInputException(String message) {
        super(message);
    }
}
