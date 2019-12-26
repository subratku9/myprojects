package com.capgemini.hibernate.exceptions;

public class GetAssetException extends RuntimeException {
	public String getMessage()
	{
		return "There are no assets available";
	}
}



