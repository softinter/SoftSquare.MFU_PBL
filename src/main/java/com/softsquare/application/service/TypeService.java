package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.ManageTypeMapping;
import com.softsquare.application.entity.Type;


public interface TypeService {
	
	public ArrayList<Type> getType();
	public void saveType(ManageTypeMapping mapping) throws Exception;
	public void removeType(ManageTypeMapping mapping) throws Exception;
	public void updateType(ManageTypeMapping mapping) throws Exception;
	
}
