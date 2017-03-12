package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.LoginMapping;
import com.softsquare.application.entity.Login;


public interface LoginService {
	
	public LoginMapping getUser(String userName);
	public  ArrayList<LoginMapping> findUser(LoginMapping loginMapping); 
	public void saveUser(LoginMapping user) throws Exception;
	public void removeUser(LoginMapping user) throws Exception;
	public void updateUser(LoginMapping user) throws Exception;
	public ArrayList<Login> getLogin();
	
}
