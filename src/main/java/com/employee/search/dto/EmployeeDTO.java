package com.employee.search.dto;
/**
 * class of employee dto
 * @author abdul.rahimanshaik
 *
 */
public class EmployeeDTO {
	private Long employeeID;
	private String employeeName;
	private String employeePracticeArea;
	private String employeeDesignation;
	private String employeeCompanyInfo;
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeDTO(Long employeeID, String employeeName, String employeePracticeArea, String employeeDesignation,
			String employeeCompanyInfo) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeePracticeArea = employeePracticeArea;
		this.employeeDesignation = employeeDesignation;
		this.employeeCompanyInfo = employeeCompanyInfo;
	}
	
	public Long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePracticeArea() {
		return employeePracticeArea;
	}
	public void setEmployeePracticeArea(String employeePracticeArea) {
		this.employeePracticeArea = employeePracticeArea;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public String getEmployeeCompanyInfo() {
		return employeeCompanyInfo;
	}
	public void setEmployeeCompanyInfo(String employeeCompanyInfo) {
		this.employeeCompanyInfo = employeeCompanyInfo;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeePracticeArea="
				+ employeePracticeArea + ", employeeDesignation=" + employeeDesignation + ", employeeCompanyInfo="
				+ employeeCompanyInfo + "]";
	}
	
	
	
	
}
