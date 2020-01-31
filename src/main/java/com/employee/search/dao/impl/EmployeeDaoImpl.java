package com.employee.search.dao.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.search.annotations.Logging;
import com.employee.search.constants.EmployeeSearchConstants;
import com.employee.search.dao.EmployeeDao;
import com.employee.search.exception.EmployeeNotfoundException;
import com.employee.search.model.Employee;
import com.employee.search.util.FileUtils;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	private FileUtils fileUtils;
	
	@Autowired
	public EmployeeDaoImpl(FileUtils fileUtils) {
		this();
		this.fileUtils=fileUtils;
	}

	public EmployeeDaoImpl() {
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@Logging
	public Employee fetchEmployeeById(Long iEmployeeID) throws IOException {
		
		List<String> aFileList=fileUtils.getFileContent(EmployeeSearchConstants.EMPLOYEE_DETAILS_PATH);
		
		List<Employee> aEmployeList = getEmployee(aFileList);
		
		if (aEmployeList.isEmpty()) {
			throw new EmployeeNotfoundException("Employee Details Not Available for iEmployeeID : "+iEmployeeID);
		}
		
		return aEmployeList.stream().filter(employee -> employee.getEmployeeID().equals(iEmployeeID)).findAny()
				.orElse(null);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@Logging
	public List<Employee> fetchEmployees() throws IOException {
		
		List<String> aFileList=fileUtils.getFileContent(EmployeeSearchConstants.EMPLOYEE_DETAILS_PATH);
		
		List<Employee> aEmployeList = getEmployee(aFileList);
		
		if (aEmployeList.isEmpty()) {
			throw new EmployeeNotfoundException("Employee Details Not Available");
		}

		return aEmployeList;
	}
	
	/**
	 * method to set data into the Employee 
	 * @param aFileList
	 * @return aEmployeList
	 */
	@Logging
	private List<Employee> getEmployee(List<String> aFileList) {
		
		List<Employee> aEmployeList = aFileList.stream()
				.skip(1) // skip the header line
				.map(line -> line.split(",")) // transform each line to an array
				.map(employeeData -> new Employee(Long.parseLong(employeeData[0]), employeeData[1], employeeData[2],
						employeeData[3], employeeData[4])) // transform each array to an entity
				.collect(Collectors.toList());
		
		return aEmployeList;
		
	}

}
