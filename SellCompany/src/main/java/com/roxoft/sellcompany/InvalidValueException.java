package com.roxoft.sellcompany;

/**
 * This is an Exception for invalid value of field
 * @author natalia.m
 * @version 1.0
 */
public class InvalidValueException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidValueException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
}
