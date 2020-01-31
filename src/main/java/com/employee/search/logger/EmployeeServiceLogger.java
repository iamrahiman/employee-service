package com.employee.search.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect

@Component
public class EmployeeServiceLogger {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * @Pointcut(value = "execution(* com.apple.employee.search.*.*.*(..))") public
	 * void logMessages() {
	 * 
	 * }
	 * 
	 * @Around("logMessages()") public Object applicationLoggger(ProceedingJoinPoint
	 * proceedingJoinPoint) throws Throwable { ObjectMapper objectMapper = new
	 * ObjectMapper(); Signature methodName = proceedingJoinPoint.getSignature();
	 * Object[] inputData = proceedingJoinPoint.getArgs(); logger.info("Method : " +
	 * methodName + ":" + " arguments: " +
	 * objectMapper.writeValueAsString(inputData)); Object object =
	 * proceedingJoinPoint.proceed(); logger.info("Method Name : " + methodName +
	 * " :" + " Response: " + objectMapper.writeValueAsString(object)); return
	 * object; }
	 */
	
	/**
	 * method to perform log 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(com.employee.search.annotations.Logging)")//Logging is custom annotation
	public Object employeeRequestData(ProceedingJoinPoint joinPoint) throws Throwable {
		ObjectMapper objectMapper = new ObjectMapper();
		Signature methodName = joinPoint.getSignature();
		Object[] inputData = joinPoint.getArgs();
		logger.info("Method : " + methodName + ":" + " arguments: " + objectMapper.writeValueAsString(inputData));
		Object object = joinPoint.proceed();
		logger.info("Method Name : " + methodName + " :" + " Response: " + objectMapper.writeValueAsString(object));
		return object;

	}
	/**
	 * method to log exceptions
	 * @param joinPoint
	 * @param ex
	 * @throws Throwable
	 */
    @AfterThrowing (pointcut = "@annotation(com.employee.search.annotations.Logging)", throwing = "ex")
	public void logThrowExceptions(JoinPoint joinPoint, Exception ex) throws Throwable {
		logger.info("Method Name : " + joinPoint.getSignature() + " :" + " Response: " + ex.getMessage());

	}
}
