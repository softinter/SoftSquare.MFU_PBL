package com.softsquare.application.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.RoleDao;
import com.softsquare.application.domain.ManageRoleMapping;
import com.softsquare.application.entity.Role;


@Service
public class RoleServiceImp implements RoleService{
	
	@Autowired
	private RoleDao roleDao;
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public ArrayList<Role> getRole() {
		return roleDao.getRole();
	}
	
	@Override
	public void saveRole(ManageRoleMapping mapping) throws Exception {
		Role role = new Role();
		System.out.println(mapping.getRoleCode());
		System.out.println(mapping.getRoleName());
		role.setRoleCode(mapping.getRoleCode());
		role.setRoleName(mapping.getRoleName());
		roleDao.saveRole(role);		
	}

	@Override
	public void removeRole(ManageRoleMapping mapping) throws Exception {
		Role role = new Role();
		role.setRoleId(mapping.getRoleId());
		roleDao.removeRole(role);
	}

	@Override
	public void updateRole(ManageRoleMapping mapping) throws Exception {
		Role role = roleDao.getRoleForUpdate(mapping);
		role.setRoleCode(mapping.getRoleCode());
		role.setRoleName(mapping.getRoleName());
		roleDao.updateRole(role);
	}
	
}