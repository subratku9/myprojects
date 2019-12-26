package com.capgemini.springrest.exceptions;

public class RemoveAssetException extends RuntimeException {
	public String getMessage()
	{
		return "enter valid asset id";
	}
}
