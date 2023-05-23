package com.mauro.helpdesk.services.exeptions;

public class ObjectNotFoundExcepetion  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundExcepetion(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundExcepetion(String message) {
		super(message);
		}
	
	}
