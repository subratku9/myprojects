package com.capgemini.hibernate.exceptions;

public class StatusException extends RuntimeException {
	public String getMessage()
	{
		return " Exception in status - enter valid allocation id";
	}
}
