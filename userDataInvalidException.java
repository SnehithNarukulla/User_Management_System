package com.user.exception;

public class userDataInvalidException extends RuntimeException{
	private String exceptionmsg;
	
	public userDataInvalidException() {
		
	}

	public userDataInvalidException(String exceptionmsg) {
		super();
		this.exceptionmsg = exceptionmsg;
	}

	public String getExceptionmsg() {
		return exceptionmsg;
	}

	public void setExceptionmsg(String exceptionmsg) {
		this.exceptionmsg = exceptionmsg;
	}

	@Override
	public String toString() {
		return "userDataInvalidException [exceptionmsg=" + exceptionmsg + "]";
	}
	
}
