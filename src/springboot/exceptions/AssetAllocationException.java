package com.capgemini.springboot.exceptions;

public class AssetAllocationException extends RuntimeException {
	public String getMessage()
	{
		return "raised request list is empty";
	}
}
