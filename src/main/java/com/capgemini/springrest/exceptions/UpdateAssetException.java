package com.capgemini.springrest.exceptions;

public class UpdateAssetException extends RuntimeException {
	public String getMessage()
	{
		return "enter valid asset id";
	}
}
