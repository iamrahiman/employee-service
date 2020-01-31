package com.employee.search.exception.response;

import java.util.Date;

public class EmployeeSearchExceptionResponse {
	
	private Date timestamp;
	private String message;
	private String requestURI;
	
	public EmployeeSearchExceptionResponse(Date timestamp,String message) {
		this.timestamp=timestamp;
		this.message=message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRequestURI() {
		return requestURI;
	}
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}
	

}
