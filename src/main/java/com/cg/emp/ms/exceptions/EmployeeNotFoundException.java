package com.cg.emp.ms.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException() {
		
	}
	
	public EmployeeNotFoundException(String message){
		super(message);
	}

}
