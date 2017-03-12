package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.ManageRoleMapping;
import com.softsquare.application.entity.Role;

public interface RoleDao {
	public  ArrayList<Role> getRole();
	public  Role getRoleForUpdate(ManageRoleMapping mapping);
	public void saveRole(Role role) throws Exception;
	public void removeRole(Role role) throws Exception;
	public void updateRole(Role role) throws Exception;
}
