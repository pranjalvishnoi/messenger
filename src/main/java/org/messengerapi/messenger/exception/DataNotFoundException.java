package org.messengerapi.messenger.exception;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1537765602986874362L;

	public DataNotFoundException(String exp)
	{
		super(exp);
	}
}
