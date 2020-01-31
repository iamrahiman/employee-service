package com.employee.search.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.search.annotations.Logging;
import com.employee.search.dto.EmployeeDTO;
import com.employee.search.exception.EmployeeNotfoundException;
import com.employee.search.service.EmployeeSearchService;

/**
 * class rest controller to get employee details
 * 
 * @author abdul.rahimanshaik
 *
 */
@RestController
@RequestMapping(path="/employee")
public class EmployeeSearchController {
	
	private EmployeeSearchService employeeSearchService;
	
	@Autowired
	public EmployeeSearchController(EmployeeSearchService employeeSearchService) {
		this();
		this.employeeSearchService=employeeSearchService;
	}
	
	public EmployeeSearchController() {
		
	}
	
	/**
	 * method to get health
	 * @return "200 OK"
	 */
	@GetMapping
	@RequestMapping(path="/health")
	@Logging
	public String getHealth() {
		return "200 OK";
		
	}
	/**
	 * method to get employee details based in id
	 * 
	 * @param id
	 * @return EmployeeDTO
	 * @throws EmployeeNotfoundException
	 * @throws IOException 
	 */
	@GetMapping
	@RequestMapping(path="/find/{iEmployeeID}", produces=MediaType.APPLICATION_JSON_VALUE)
	@Logging
	public EmployeeDTO fetchempByID(@PathVariable Long iEmployeeID) throws EmployeeNotfoundException, IOException {
			return employeeSearchService.fetchEmployeeById(iEmployeeID);
			
	}

	/**
	 * method to get all employee details
	 * 
	 * @return List<EmployeeDTO>
	 * @throws IOException
	 * @throws EmployeeNotfoundException
	 */
	@GetMapping
	@RequestMapping("/fetch/all")
	@Logging
	public List<EmployeeDTO> fetchemp() throws EmployeeNotfoundException, IOException {
		return employeeSearchService.fetchEmployees();
	}
}
	