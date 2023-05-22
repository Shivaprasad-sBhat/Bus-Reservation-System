package com.masai.exception;

public class CustomerException extends RuntimeException {
	
	public CustomerException(){
		
	}
	
	public CustomerException(String msg) {
		
		super(msg);
	}

}
