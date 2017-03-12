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
import com.softsquare.application.domain.LoginMapping;
import com.softsquare.application.entity.Login;
import com.softsquare.application.entity.OrderDetail;
import com.softsquare.application.entity.Position;

@Repository()
@Component
public class LoginDaoImp extends AbstractDao<Integer, Login> implements LoginDao  {

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findByUsername(String userName) {
		 Criteria criteria = getSession().createCriteria(Login.class, "login");
		 criteria.createAlias("login.role", "role");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("login.username").as("username"))
		            .add(Projections.property("login.password").as("password"))
		            .add(Projections.property("role.roleCode").as("roleCode"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(userName)){
			 criteria.add(Restrictions.eq("login.username", userName));			 
		 }
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 List<Map<String, Object>> loginList =  criteria.list();
		return loginList;
	}
	
	@Override
	public  ArrayList<LoginMapping> findUser(LoginMapping loginMapping) {
		Criteria criteria = getSession().createCriteria(Login.class, "login");
		 criteria.createAlias("login.role", "role");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("login.id").as("userId"))
		            .add(Projections.property("login.username").as("userName"))
		            .add(Projections.property("login.password").as("password"))
		            .add(Projections.property("role.roleCode").as("role"))
		            .add(Projections.property("role.roleId").as("roleId"));
		            
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(loginMapping.getRoleId())){
			 criteria.add(Restrictions.eq("role.roleId", loginMapping.getRoleId()));			 
		 }
		 if(BeanUtils.isNotEmpty(loginMapping.getUserId())){
			 criteria.add(Restrictions.eq("login.id", loginMapping.getUserId()));
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(LoginMapping.class));
		 ArrayList<LoginMapping> resultList =  (ArrayList<LoginMapping>) criteria.list();
		return resultList;
	}
	
	@Override
	public Login findUserForUpdate(LoginMapping loginMapping) {
		Criteria criteria = getSession().createCriteria(Login.class, "login");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("login.id").as("id"))
		            .add(Projections.property("login.username").as("username"))
		            .add(Projections.property("login.password").as("password"))
		            .add(Projections.property("login.roleId").as("roleId"));
		            
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(loginMapping.getUserName())){
			 criteria.add(Restrictions.eq("login.username", loginMapping.getUserName()));
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Login.class));
		 Login resultList =  (Login) criteria.uniqueResult();
		 
		return resultList;
	}

	@Override
	public void saveUser(Login user) throws Exception {
		save(user);
	}

	@Override
	public void updateUser(Login user) throws Exception {
		merge(user);		
	}

	@Override
	public void deleteUser(Login user) throws Exception  {
		delete(user);
	}

	@Override
	public ArrayList<Login> getLogin() {
		 Criteria criteria = getSession().createCriteria(Login.class, "login");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("login.id").as("id"))
		            .add(Projections.property("login.username").as("username"))
		            .add(Projections.property("login.password").as("password"));
		          
		 criteria.setProjection(projections);
		 
		 criteria.setResultTransformer(Transformers.aliasToBean(Login.class));
		 ArrayList<Login> loginList = (ArrayList<Login>) criteria.list();
		return loginList;
	}
		
	}
