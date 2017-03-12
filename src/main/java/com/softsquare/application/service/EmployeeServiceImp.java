package com.softsquare.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.EmployeeDao;
import com.softsquare.application.domain.ManageEmployeeMapping;
import com.softsquare.application.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public ManageEmployeeMapping getEmployee(String employeeName) {
		List<Map<String, Object>> employee = employeeDao.findByEmployeename(employeeName);
		ManageEmployeeMapping manageEmployeeMapping = new ManageEmployeeMapping();
		manageEmployeeMapping.setEmployeeName(employee.get(0).get("employeeName").toString());
		manageEmployeeMapping.setEmployeeBirthday(employee.get(0).get("employeeBirthday").toString());
		manageEmployeeMapping.setEmployeeAddress(employee.get(0).get("employeeAddress").toString());
		manageEmployeeMapping.setEmployeePhone(employee.get(0).get("employeePhone").toString());
		manageEmployeeMapping.setEmployeeEmail(employee.get(0).get("employeeEmail").toString());
		manageEmployeeMapping.setEmployeeCost(employee.get(0).get("employeeCost").toString());
		manageEmployeeMapping.setPosition(employee.get(0).get("positionCode").toString());
				return manageEmployeeMapping;
		}
		
		@Override
		public  ArrayList<ManageEmployeeMapping> findEmployee(ManageEmployeeMapping manageEmployeeMapping) {
			return employeeDao.findEmployee(manageEmployeeMapping);
	}

	@Override
	public void saveEmployee(ManageEmployeeMapping mapping) throws Exception {
		Employee employee = new Employee();
		System.out.println(mapping.getEmployeeName());
		System.out.println(mapping.getEmployeeBirthday());
		System.out.println(mapping.getEmployeeAddress());
		System.out.println(mapping.getEmployeePhone());
		System.out.println(mapping.getEmployeeEmail());
		System.out.println(mapping.getEmployeeCost());
		System.out.println(mapping.getPositionID());
		System.out.println(mapping.getLoginID());

		System.out.println("55555555555555");
		employee.setEmployeeName(mapping.getEmployeeName());
		employee.setEmployeeBirthday(mapping.getEmployeeBirthday());
		employee.setEmployeeAddress(mapping.getEmployeeAddress());
		employee.setEmployeePhone(mapping.getEmployeePhone());
		employee.setEmployeeEmail(mapping.getEmployeeEmail());
		employee.setEmployeeCost(mapping.getEmployeeCost());
		employee.setPositionID(mapping.getPositionID());
		employee.setLoginID(mapping.getLoginID());
		employeeDao.saveEmployee(employee);

	}

	@Override
	public void removeEmployee(ManageEmployeeMapping mapping) throws Exception {
		Employee employee = new Employee();
		employee.setEmployeeID(mapping.getEmployeeID());
		employeeDao.removeEmployee(employee);

	}

	@Override
	public void updateEmployee(ManageEmployeeMapping mapping) throws Exception {
		Employee employee = employeeDao.findEmployeeForUpdate(mapping);
		employee.setEmployeeID(mapping.getEmployeeID());
		employee.setEmployeeName(mapping.getEmployeeName());
		employee.setEmployeeBirthday(mapping.getEmployeeBirthday());
		employee.setEmployeeAddress(mapping.getEmployeeAddress());
		employee.setEmployeePhone(mapping.getEmployeePhone());
		employee.setEmployeeEmail(mapping.getEmployeeEmail());
		employee.setEmployeeCost(mapping.getEmployeeCost());
		employee.setPositionID(mapping.getPositionID());
		employee.setLoginID(mapping.getLoginID());
		employeeDao.updateEmployee(employee);
	}
}

