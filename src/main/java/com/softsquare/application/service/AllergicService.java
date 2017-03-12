package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.ManageAllergicMapping;

public interface AllergicService {
	public ManageAllergicMapping getAllergic(String allergicCode);
	public  ArrayList<ManageAllergicMapping> findAllergic(ManageAllergicMapping allergicMapping); 
	public void saveAllergic(ManageAllergicMapping allergicMapping) throws Exception;
	public void removeAllergic(ManageAllergicMapping allergicMapping) throws Exception;
	public void updateAllergic(ManageAllergicMapping allergicMapping) throws Exception;

}
