package com.softsquare.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.AllergicDao;
import com.softsquare.application.domain.ManageAllergicMapping;
import com.softsquare.application.entity.Allergic;

@Service
public class AllergicServiceImp implements AllergicService {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private AllergicDao allergicDao;

	@Override
	public ManageAllergicMapping getAllergic(String allergicCode) {
		List<Map<String, Object>> allergic = allergicDao.findByAllergicCode(allergicCode);
		ManageAllergicMapping allergicMapping = new ManageAllergicMapping();
		allergicMapping.setAllergicCode(allergic.get(0).get("allergicCode").toString());
		allergicMapping.setAllergicName(allergic.get(0).get("allergicName").toString());
		allergicMapping.setAllergicDetail(allergic.get(0).get("allergicDetail").toString());
		allergicMapping.setPatient(allergic.get(0).get("patientName").toString());
		return allergicMapping;
	}

	@Override
	public ArrayList<ManageAllergicMapping> findAllergic(ManageAllergicMapping allergicMapping) {
		return allergicDao.findAllergic(allergicMapping);
	}

	@Override
	public void saveAllergic(ManageAllergicMapping mapping) throws Exception {
		Allergic allergic = new Allergic();
		allergic.setAllergicCode(mapping.getAllergicCode());
		allergic.setAllergicName(mapping.getAllergicName());
		allergic.setAllergicDetail(mapping.getAllergicDetail());
		allergic.setPatientId(mapping.getPatientId());
		
		allergicDao.saveAllergic(allergic);

	}

	@Override
	public void removeAllergic(ManageAllergicMapping mapping) throws Exception {
		Allergic allergic = new Allergic();
		allergic.setAllergicId(mapping.getAllergicId());
		allergicDao.deleteAllergic(allergic);
	}

	@Override
	public void updateAllergic(ManageAllergicMapping mapping) throws Exception {
		
		Allergic allergic = allergicDao.findAllergicForUpdate(mapping);
		allergic.setAllergicCode(mapping.getAllergicCode());
		allergic.setAllergicName(mapping.getAllergicName());
		allergic.setAllergicDetail(mapping.getAllergicDetail());
		
		allergicDao.updateAllergic(allergic);

	}

}
