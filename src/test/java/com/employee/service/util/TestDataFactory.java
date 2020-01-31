package com.employee.service.util;

import java.util.ArrayList;
import java.util.List;

import com.employee.search.dto.EmployeeDTO;
import com.employee.search.model.Employee;

public class TestDataFactory {
	
	public static List<Employee> getEmployeeData(){
		List employeeList = new ArrayList<>();
		Employee employee1=new Employee((long) 1, "Chiru", "Java", "Manager", "CapGemini");
		Employee employee2=new Employee((long) 2, "Balayya", "C++", "Manager", "Tech Mahindra");
		Employee employee3=new Employee((long) 3, "Venky", "AI", "Sr.Architect", "Microsoft");
		Employee employee4=new Employee((long) 4, "Nag", "AWS", "Programmer", "Google");
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeList.add(employee4);
		
		return employeeList;
	}
	
	public static List<EmployeeDTO> getEmployeeDTOData(){
		List employeeDTOList = new ArrayList<>();
		EmployeeDTO employeeDTO1=new EmployeeDTO((long) 1, "Chiru", "Java", "Manager", "CapGemini");
		EmployeeDTO employeeDTO2=new EmployeeDTO((long) 2, "Balayya", "C++", "Manager", "Tech Mahindra");
		EmployeeDTO employeeDTO3=new EmployeeDTO((long) 3, "Venky", "AI", "Sr.Architect", "Microsoft");
		EmployeeDTO employeeDTO4=new EmployeeDTO((long) 4, "Nag", "AWS", "Programmer", "Google");
		employeeDTOList.add(employeeDTO1);
		employeeDTOList.add(employeeDTO2);
		employeeDTOList.add(employeeDTO3);
		employeeDTOList.add(employeeDTO4);
		
		return employeeDTOList;
	}
	public static List<String> getEmployeeFileData(){
		List<String> list=new ArrayList<String>();
		list.add("ID,Name,Domain,Designation.Company,Date");
		list.add("4,Chiru,Java,Manager,CapGemini, 10-11-2018");
		list.add("2,Balayya,C++,Manager, Tech Mahindra, 11-01-2016");
		list.add("1,Venky,AI,Sr.Architect, Microsoft, 09-03-2017");
		list.add("3,Nag,AWS,Programmer, Google, 05-05-2013");
		
		return list;
	}
	

}
