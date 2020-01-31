package com.employee.search.exception;

/**
 * class to define employee not found exception
 * 
 * @author abdul.rahimanshaik
 *
 */
public class EmployeeNotfoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public EmployeeNotfoundException() {
		super();
	}
	
	public EmployeeNotfoundException(final String message) {
		super(message);
	}

}
