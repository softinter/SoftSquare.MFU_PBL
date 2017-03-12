package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.domain.ManageEmployeeMapping;
import com.softsquare.application.entity.Employee;

@Repository()
@Component
public class EmployeeDaoImp extends AbstractDao<Integer, Employee> implements EmployeeDao  {

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findByEmployeename(String employeeName) {
		 Criteria criteria = getSession().createCriteria(Employee.class, "employee");
		 criteria.createAlias("employee.position", "position");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("employee.employeeID").as("employeeID"))
		            .add(Projections.property("employee.employeeName").as("employeeName"))
		            .add(Projections.property("employee.employeeBirthday").as("employeeBirthday"))
		            .add(Projections.property("employee.employeeAddress").as("employeeAddress"))
		            .add(Projections.property("employee.employeePhone").as("employeePhone"))
		            .add(Projections.property("employee.employeeEmail").as("employeeEmail"))
		            .add(Projections.property("employee.employeeCost").as("employeeCost"))
		            .add(Projections.property("position.positionCode").as("positionCode"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(employeeName)){
			 criteria.add(Restrictions.eq("employee.employeeName", employeeName));			 
		 }
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 List<Map<String, Object>> employeeList =  criteria.list();
		return employeeList;
	}
	
	@Override
	public  ArrayList<ManageEmployeeMapping> findEmployee(ManageEmployeeMapping manageEmployeeMapping) {
		Criteria criteria = getSession().createCriteria(Employee.class, "employee");
		 criteria.createAlias("employee.position", "position");
		 criteria.createAlias("employee.login", "login");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("employee.employeeID").as("employeeID"))
		            .add(Projections.property("employee.employeeName").as("employeeName"))
		            .add(Projections.property("employee.employeeBirthday").as("employeeBirthday"))
		            .add(Projections.property("employee.employeeAddress").as("employeeAddress"))
		            .add(Projections.property("employee.employeePhone").as("employeePhone"))
		            .add(Projections.property("employee.employeeEmail").as("employeeEmail"))
		            .add(Projections.property("employee.employeeCost").as("employeeCost"))
		            .add(Projections.property("position.positionName").as("positionName"))
		 			.add(Projections.property("login.username").as("username"));
		            
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(manageEmployeeMapping.getPositionID())){
			 criteria.add(Restrictions.eq("position.positionID", manageEmployeeMapping.getPositionID()));			 
		 }
//		 if(BeanUtils.isNotEmpty(manageEmployeeMapping.getEmployeeID())){
//			 criteria.add(Restrictions.eq("employee.employeeID", manageEmployeeMapping.getEmployeeID()));
//		 }
//		 if(BeanUtils.isNotEmpty(manageEmployeeMapping.getLoginID())){
//			 criteria.add(Restrictions.eq("employee.loginID", manageEmployeeMapping.getLoginID()));
//		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(ManageEmployeeMapping.class));
		 ArrayList<ManageEmployeeMapping> employeeList =  (ArrayList<ManageEmployeeMapping>) criteria.list();
		return employeeList;
	}
	
	@Override
	public Employee findEmployeeForUpdate(ManageEmployeeMapping manageEmployeeMapping) {
		Criteria criteria = getSession().createCriteria(Employee.class, "employee");
		 ProjectionList projections = Projections.projectionList()
				 		.add(Projections.property("employee.employeeID").as("employeeID"))
				       .add(Projections.property("employee.employeeName").as("employeeName"))
			            .add(Projections.property("employee.employeeBirthday").as("employeeBirthday"))
			            .add(Projections.property("employee.employeeAddress").as("employeeAddress"))
			            .add(Projections.property("employee.employeePhone").as("employeePhone"))
			            .add(Projections.property("employee.employeeEmail").as("employeeEmail"))
			            .add(Projections.property("employee.employeeCost").as("employeeCost"))
			            .add(Projections.property("employee.positionID").as("positionID"))
		 				.add(Projections.property("employee.loginID").as("loginID"));
		            
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(manageEmployeeMapping.getEmployeeID())){
			 criteria.add(Restrictions.eq("employee.employeeID", manageEmployeeMapping.getEmployeeID()));
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Employee.class));
		 Employee employeeList =  (Employee) criteria.uniqueResult();
		 
		return employeeList;
	}

	@Override
	public void saveEmployee(Employee employee) throws Exception {
		save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		merge(employee);		
	}

	@Override
	public void removeEmployee(Employee employee) throws Exception  {
		delete(employee);
	}

	
	
}
