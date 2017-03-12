package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.softsquare.application.domain.ManageAllergicMapping;
import com.softsquare.application.domain.ManagePatientMapping;
import com.softsquare.application.entity.Allergic;

public interface AllergicDao {
	
	public List<Map<String, Object>> findByAllergicCode(String allergicCode);
	public  ArrayList<ManageAllergicMapping> findAllergic(ManageAllergicMapping mapping);
	public Allergic findAllergicForUpdate(ManageAllergicMapping mapping);
	public void saveAllergic(Allergic allergic) throws Exception;
	public void updateAllergic(Allergic allergic) throws Exception;
	public void deleteAllergic(Allergic allergic) throws Exception;
	List<Map<String, Object>> findAllergicId(Integer patientId);
	

}
