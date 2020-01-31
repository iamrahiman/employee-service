package com.employee.search.config;


import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for the EmployeeBridge
 * 
 * @author abdul.rahimanshaik
 *
 */
@Configuration
public class EmployeeSearchConfig {

	/**
	 * method to get DozerBeanMapper
	 * 
	 * @return DozerBeanMapper
	 */
	@Bean
	public DozerBeanMapper dozerBeanMapper() {
		return new DozerBeanMapper();
	}


}
