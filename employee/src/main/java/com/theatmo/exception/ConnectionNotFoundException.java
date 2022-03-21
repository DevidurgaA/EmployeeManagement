package com.theatmo.exception;

import com.theatmo.exception.CustomException;

public class ConnectionNotFoundException extends CustomException {

	public ConnectionNotFoundException(String message) {
		super(message);
	}

}
