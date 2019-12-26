package com.capgemini.springboot.exceptions;

public class ValidationException extends RuntimeException {
	public String getMessage()
	{
		return "validation exception";

	}
}
