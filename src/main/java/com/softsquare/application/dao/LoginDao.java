package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.softsquare.application.domain.LoginMapping;
import com.softsquare.application.entity.Login;
import com.softsquare.application.entity.Position;

public interface LoginDao {
	public  ArrayList<Login> getLogin();
	public List<Map<String, Object>> findByUsername(String userName);
	public  ArrayList<LoginMapping> findUser(LoginMapping loginMapping);
	public Login findUserForUpdate(LoginMapping loginMapping);
	public void saveUser(Login user) throws Exception;
	public void updateUser(Login user) throws Exception;
	public void deleteUser(Login user) throws Exception;

}
