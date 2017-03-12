package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.LoginMapping;
import com.softsquare.application.domain.ManageEmployeeMapping;
import com.softsquare.application.entity.Employee;

public interface EmployeeService {
	
	public ManageEmployeeMapping getEmployee(String employeeName);
	public  ArrayList<ManageEmployeeMapping> findEmployee(ManageEmployeeMapping manageEmployeeMapping); 
	public void saveEmployee(ManageEmployeeMapping employee) throws Exception;
	public void removeEmployee(ManageEmployeeMapping employee) throws Exception;
	public void updateEmployee(ManageEmployeeMapping employee) throws Exception;

}
