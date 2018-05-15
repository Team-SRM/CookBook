package com.develop.xoriant.Exceptions;

public class UserValidationException extends Exception{
	
	private String message;
	
	public UserValidationException(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
