package com.mahidhar.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6156575836703728606L;

	public EmployeeNotFoundException(String msg){
		super(msg);
	}

}
