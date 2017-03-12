package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.ManageRoleMapping;
import com.softsquare.application.entity.Role;


public interface RoleService {
	
	public ArrayList<Role> getRole();
	public void saveRole(ManageRoleMapping mapping) throws Exception;
	public void removeRole(ManageRoleMapping mapping) throws Exception;
	public void updateRole(ManageRoleMapping mapping) throws Exception;
	
}
