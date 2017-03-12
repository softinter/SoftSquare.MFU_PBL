package com.softsquare.application.domain;

public class ManageEmployeeMapping {
	private Integer employeeID;
	private String employeeName;
	private String employeeBirthday;
	private String employeeAddress;
	private String employeePhone;
	private String employeeEmail;
	private String employeeCost;
	private String position;
	private Integer positionID;
	private String positionName;
	private String login;
	private Integer loginID;
	private String username;
	public Integer getEmployeeID() {
		return employeeID;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeBirthday() {
		return employeeBirthday;
	}
	public void setEmployeeBirthday(String employeeBirthday) {
		this.employeeBirthday = employeeBirthday;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeCost() {
		return employeeCost;
	}
	public void setEmployeeCost(String employeeCost) {
		this.employeeCost = employeeCost;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getPositionID() {
		return positionID;
	}
	public void setPositionID(Integer positionID) {
		this.positionID = positionID;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Integer getLoginID() {
		return loginID;
	}
	public void setLoginID(Integer loginID) {
		this.loginID = loginID;
	}
}