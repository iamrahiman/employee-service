package com.employee.search.dao.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employee.search.dao.EmployeeDao;
import com.employee.search.dao.impl.EmployeeDaoImpl;
import com.employee.search.model.Employee;
import com.employee.search.util.FileUtils;
import com.employee.service.util.TestDataFactory;

@ExtendWith(MockitoExtension.class)
public class EmployeeDaoTest {

	private EmployeeDao employeeDao;
	private FileUtils fileUtils;
	
	@BeforeEach
	private void setup() {
		fileUtils=Mockito.mock(FileUtils.class);
		employeeDao=new EmployeeDaoImpl(fileUtils);
	}
	
	@Test
	public void testFetchEmployees() throws IOException {
		when(fileUtils.getFileContent(Mockito.anyString())).thenReturn(TestDataFactory.getEmployeeFileData());
		List<Employee> aEmployeList=employeeDao.fetchEmployees();
		assertEquals(4, aEmployeList.size());
		
	}
	
	@Test
	public void testFetchEmployeesById() throws IOException {
		when(fileUtils.getFileContent(Mockito.anyString())).thenReturn(TestDataFactory.getEmployeeFileData());
		Employee aEmployee=employeeDao.fetchEmployeeById((long)1);
		assertEquals("AI", aEmployee.getEmployeePracticeArea());
		
	}
}
