package com.employee.search.service;
import java.io.IOException;
/**
 * Interface to get employee details
 * @author abdul.rahimanshaik
 */
import java.util.List;

import com.employee.search.dto.EmployeeDTO;


public interface EmployeeSearchService {
	/**
	 * to get employee details
	 * @return 
	 * @throws IOException 
	 */
    public List<EmployeeDTO> fetchEmployees() throws IOException;
    
    /**
     * to fetch employee details based on employee id
     * @param id
     * @return
     * @throws IOException 
     */
    public EmployeeDTO fetchEmployeeById(Long iEmployeeID) throws IOException ;

}
