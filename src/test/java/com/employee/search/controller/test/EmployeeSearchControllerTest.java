package com.employee.search.controller.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.employee.search.controller.EmployeeSearchController;
import com.employee.search.dto.EmployeeDTO;
import com.employee.search.service.EmployeeSearchService;
import com.employee.service.util.TestDataFactory;

@ExtendWith(MockitoExtension.class)
public class EmployeeSearchControllerTest {
	private EmployeeSearchController employeeSearchController;
	private EmployeeSearchService employeeSearchService;
	private MockMvc mockMvc;
	
	@BeforeEach
	private void setup() {
		employeeSearchService=Mockito.mock(EmployeeSearchService.class);
		employeeSearchController=new EmployeeSearchController(employeeSearchService);
		this.mockMvc=MockMvcBuilders.standaloneSetup(employeeSearchController).build();
	}
	
	@Test
	public void testFetchemp() throws IOException {
		Mockito.when(employeeSearchService.fetchEmployees()).thenReturn(TestDataFactory.getEmployeeDTOData());
		List<EmployeeDTO> employeeDTO=employeeSearchController.fetchemp();
		assertEquals(4, employeeDTO.size());
		
	}
	
	@Test
	public void testFetchempById() throws IOException {
		Mockito.when(employeeSearchService.fetchEmployeeById(Mockito.anyLong())).thenReturn(TestDataFactory.getEmployeeDTOData().get(0));
		EmployeeDTO employeeDTO=employeeSearchController.fetchempByID((long)1);
		assertEquals("Java", employeeDTO.getEmployeePracticeArea());
		
	}
	
}
