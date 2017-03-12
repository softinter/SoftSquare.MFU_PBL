package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.softsquare.application.domain.ManageEmployeeMapping;
import com.softsquare.application.entity.Employee;

public interface EmployeeDao {
	public List<Map<String, Object>> findByEmployeename(String employeeName);
	public  ArrayList<ManageEmployeeMapping> findEmployee(ManageEmployeeMapping manageEmployeeMapping);
	public Employee findEmployeeForUpdate(ManageEmployeeMapping manageEmployeeMapping);
	public void saveEmployee(Employee employee) throws Exception;
	public void updateEmployee(Employee employee) throws Exception;
	public void removeEmployee(Employee employee) throws Exception;

}
