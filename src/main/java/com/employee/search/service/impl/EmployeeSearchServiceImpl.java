package com.employee.search.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.search.annotations.Logging;
import com.employee.search.config.BeanMapper;
import com.employee.search.dao.EmployeeDao;
import com.employee.search.dto.EmployeeDTO;
import com.employee.search.exception.EmployeeNotfoundException;
import com.employee.search.model.Employee;
import com.employee.search.service.EmployeeSearchService;

/**
 * @author abdul.rahimanshaik
 *
 */
@Service
public class EmployeeSearchServiceImpl implements EmployeeSearchService {
	
	private EmployeeDao employeeDao;
	
	private BeanMapper dozerBeanMapper;
	
	@Autowired
	public EmployeeSearchServiceImpl(EmployeeDao employeeDao, BeanMapper dozerBeanMapper) {
		this();
		this.employeeDao=employeeDao;
		this.dozerBeanMapper=dozerBeanMapper;
	}
	
	public EmployeeSearchServiceImpl() {
		
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@Logging
	public EmployeeDTO fetchEmployeeById(Long iEmployeeID) throws IOException {
		
		Employee aEmployee = employeeDao.fetchEmployeeById(iEmployeeID);
		EmployeeDTO aEmployeeDTO = new EmployeeDTO();

		if (aEmployee != null) {
			aEmployeeDTO = dozerBeanMapper.map(aEmployee, EmployeeDTO.class);
					//convertToEmployeeDTO(aEmployee);
		}else {
			throw new EmployeeNotfoundException("Employee Details Not Available for iEmployeeID : "+iEmployeeID);
		}
		
		return aEmployeeDTO;
	}
	

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@Logging
	public List<EmployeeDTO> fetchEmployees() throws IOException {
		
		List<Employee> aEmployeeList = employeeDao.fetchEmployees();
		//List<EmployeeDTO> aEmployeeDTOList= aEmployeeList.stream().map(emp -> convertToEmployeeDTO(emp)).collect(Collectors.toList());
		List<EmployeeDTO> aEmployeeDTOList=dozerBeanMapper.mapAsList(aEmployeeList, EmployeeDTO.class);
		if (aEmployeeList.isEmpty()) {
			throw new EmployeeNotfoundException("Employee Details Not Available");
		}
		aEmployeeDTOList.sort(Comparator.comparing(EmployeeDTO::getEmployeeName));
		return aEmployeeDTOList;
	}

	/**
	 * method to convert to EmployeeDTO
	 * @param emp
	 * @return
	 */
	private EmployeeDTO convertToEmployeeDTO(Employee emp) {
		return dozerBeanMapper.map(emp, EmployeeDTO.class);
	}

}