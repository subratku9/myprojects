package com.capgemini.hibernate.exceptions;

public class AddAssetException extends RuntimeException
{
	private static final long serialVersionUID = -3084339430000692421L;

	public String getMessage()
	{
		return "Adding asset Exception";

	}
}
