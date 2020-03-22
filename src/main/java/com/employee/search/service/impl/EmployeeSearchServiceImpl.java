package com.employee.search.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.employee.search.annotations.Logging;
import com.employee.search.config.BeanMapper;
import com.employee.search.constants.EmployeeSearchConstants;
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
    private JavaMailSender javaMailSender;
	
	
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
		
		//sendEmail();
//		try {
//			sendEmailWithAttachment();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
	
	/*
	 * void sendEmail() {
	 * 
	 * SimpleMailMessage msg = new SimpleMailMessage();
	 * msg.setTo("iamshaiksha2019@gmail.com", "jayasreecherukunuru@gmail.com",
	 * "to_3@yahoo.com");
	 * 
	 * msg.setSubject("Hi"); msg.setText("How are you doing??");
	 * 
	 * javaMailSender.send(msg);
	 * 
	 * }
	 */
	

	void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		
        helper.setTo("iamshaiksha2019@gmail.com");

        helper.setSubject("Passpot size-Photo");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1><marquee>Check photo!</marquee></h1>", true);

		// hard coded a file path
        //FileSystemResource file = new FileSystemResource(new File("path/android.png"));

        helper.addAttachment("download.png", new ClassPathResource("download.png"));

        javaMailSender.send(msg);

    }

}