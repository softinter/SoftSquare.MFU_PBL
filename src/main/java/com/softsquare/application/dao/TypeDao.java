package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.ManageTypeMapping;
import com.softsquare.application.entity.Type;

public interface TypeDao {
	public  ArrayList<Type> getType();
	public  Type getTypeForUpdate(ManageTypeMapping mapping);
	public void saveType(Type type) throws Exception;
	public void removeType(Type type) throws Exception;
	public void updateType(Type type) throws Exception;
}
