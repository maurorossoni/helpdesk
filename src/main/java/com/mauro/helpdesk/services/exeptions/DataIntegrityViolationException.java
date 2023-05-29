package com.mauro.helpdesk.services.exeptions;

public class DataIntegrityViolationException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityViolationException(String message) {
		super(message);
		}
	
	}
