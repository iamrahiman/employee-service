package com.employee.search.service.test;


import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employee.search.config.BeanMapper;
import com.employee.search.dao.EmployeeDao;
import com.employee.search.dto.EmployeeDTO;
import com.employee.search.model.Employee;
import com.employee.search.service.EmployeeSearchService;
import com.employee.search.service.impl.EmployeeSearchServiceImpl;
import com.employee.service.util.TestDataFactory;


@ExtendWith(MockitoExtension.class)
public class EmployeeSearchServiceTest {
	private EmployeeSearchService employeeSearchService;
	private EmployeeDao employeeDao;
	
	@InjectMocks
	private static BeanMapper dozerBeanMapper;
	
	@BeforeEach
	private void setup() {
		employeeDao=Mockito.mock(EmployeeDao.class);
		employeeSearchService= new EmployeeSearchServiceImpl(employeeDao,dozerBeanMapper);
	}
	
	@Test
	public void testFetchEmployee() throws IOException {
		List<Employee> aEmployeeList = TestDataFactory.getEmployeeData();
		Mockito.when(employeeDao.fetchEmployees()).thenReturn(aEmployeeList);
		List<EmployeeDTO> aEmployeeDTOList=employeeSearchService.fetchEmployees();
		aEmployeeDTOList.forEach(e->System.out.println(e.getEmployeeCompanyInfo()));
		assertEquals(4, aEmployeeDTOList.size());
		
	}
	
	@Test
	public void testFetchEmployeeById() throws IOException {
		List<Employee> aEmployeeList = TestDataFactory.getEmployeeData();
		Mockito.when(employeeDao.fetchEmployeeById(Mockito.anyLong())).thenReturn(aEmployeeList.get(0));
		EmployeeDTO aEmployeeDTO=employeeSearchService.fetchEmployeeById((long)1);
		System.out.println(aEmployeeDTO.getEmployeeName());
		assertEquals("Java", aEmployeeDTO.getEmployeePracticeArea());
		
	}
}
