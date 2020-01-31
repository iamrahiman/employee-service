 	package com.employee.search.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employee.search.constants.EmployeeSearchConstants;
import com.employee.search.exception.EmployeeNotfoundException;

/**
 * class for the customized messages for the exceptions
 * @author abdul.rahimanshaik
 *
 */
@ControllerAdvice //to handle the exceptions globally.
public class EmployeeSearchExceptionHandler{
	
	/**
	 * method to throw message on Employee not found exception
	 * @param exception
	 * @return Employee Record Not found
	 */
   @ExceptionHandler(value = EmployeeNotfoundException.class)//used to handle the specific exceptions and sending the custom responses to the client.
   public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotfoundException employeeNotfoundException) {
	   //EmployeeSearchExceptionResponse errorDetails=new EmployeeSearchExceptionResponse(new Date(),employeeNotfoundException.getMessage());
	   
      return new ResponseEntity<>(employeeNotfoundException.getMessage(), HttpStatus.NOT_FOUND);
   }
}