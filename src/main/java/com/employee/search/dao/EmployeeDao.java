package com.employee.search.dao;

import java.io.IOException;
import java.util.List;

import com.employee.search.model.Employee;

public interface EmployeeDao {

	/**
	 * method to fetch employee details by employee id
	 * @param iEmployeeID
	 * @return Employee
	 * @throws IOException 
	 */
	Employee fetchEmployeeById(Long iEmployeeID) throws  IOException;
	
	/**
	 * method to fetch all employee details
	 * @return List<Employee>
	 * @throws IOException
	 */
	List<Employee> fetchEmployees() throws IOException;
	
}
