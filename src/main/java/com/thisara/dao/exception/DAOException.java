package com.thisara.dao.exception;

import com.thisara.exception.ErrorCodes;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	private ErrorCodes errorCode;
	
	public DAOException(String message, ErrorCodes errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public ErrorCodes getErrorCode() {
		return errorCode;
	}
}
