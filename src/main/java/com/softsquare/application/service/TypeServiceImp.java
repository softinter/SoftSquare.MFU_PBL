package com.softsquare.application.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.TypeDao;
import com.softsquare.application.domain.ManageTypeMapping;
import com.softsquare.application.entity.Type;


@Service
public class TypeServiceImp implements TypeService{
	
	@Autowired
	private TypeDao typeDao;
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public ArrayList<Type> getType() {
		return typeDao.getType();
	}
	
	@Override
	public void saveType(ManageTypeMapping mapping) throws Exception {
		Type type = new Type();
		System.out.println(mapping.getTypeCode());
		System.out.println(mapping.getTypeName());
		type.setTypeCode(mapping.getTypeCode());
		type.setTypeName(mapping.getTypeName());
		typeDao.saveType(type);		
	}

	@Override
	public void removeType(ManageTypeMapping mapping) throws Exception {
		Type type = new Type();
		type.setTypeID(mapping.getTypeID());
		typeDao.removeType(type);
	}

	@Override
	public void updateType(ManageTypeMapping mapping) throws Exception {
		Type type = typeDao.getTypeForUpdate(mapping);
		type.setTypeCode(mapping.getTypeCode());
		type.setTypeName(mapping.getTypeName());
		typeDao.updateType(type);
	}
	
}