package com.capgemini.springrest.exceptions;

public class ValidationException extends RuntimeException {
	public String getMessage()
	{
		return "validation exception";

	}
}
