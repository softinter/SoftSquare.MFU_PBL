package com.softsquare.application.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "EMPLOYEE")
public class Employee extends BaseEntity  implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7085427867395980605L;

	@Id
    @GeneratedValue
    @Column(name = "EMPLOYEEID")
	private Integer employeeID;
	
	@NotEmpty
	@Column(name = "EMPLOYEENAME",  nullable = false)
	private String employeeName;
	
	@Column(name = "EMPLOYEEBIRTHDAY", nullable = false)
	private String employeeBirthday;
	
	@Column(name = "EMPLOYEEADDRESS",  nullable = false)
	private String employeeAddress;

	@Column(name = "EMPLOYEEPHONE",  nullable = false)
	private String employeePhone;
	
	@Column(name = "EMPLOYEEEMAIL",  nullable = false)
	private String employeeEmail;
	
	@Column(name = "EMPLOYEECOST",  nullable = false)
	private String employeeCost;

	@Column(name = "POSITIONID", nullable = false)
    private Integer positionID;
	
	@Column(name = "LOGINID", nullable = false)
    private Integer loginID;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSITIONID", referencedColumnName = "POSITIONID", insertable=false, updatable=false)
    private Position position;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOGINID", referencedColumnName = "LGID", insertable=false, updatable=false)
    private Login login;

	public Integer getEmployeeID() {
		return employeeID;
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

	public Integer getLoginID() {
		return loginID;
	}

	public void setLoginID(Integer loginID) {
		this.loginID = loginID;
	}

	public Integer getPositionID() {
		return positionID;
	}

	public void setPositionID(Integer positionID) {
		this.positionID = positionID;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	
}
		