package com.softsquare.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.PatientTreatmentDao;
import com.softsquare.application.domain.ManagePatientTreatmentMapping;
import com.softsquare.application.entity.PatientTreatment;

@Service
public class PatientTreatmentServiceImp implements PatientTreatmentService {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private PatientTreatmentDao patienttreatmentDao;

	@Override
	public ManagePatientTreatmentMapping getPatientTreatment(String patienttreatmentDiseaseName) {
		List<Map<String, Object>> patienttreatment = patienttreatmentDao.findByPatientTreatDiseaseName(patienttreatmentDiseaseName);
		ManagePatientTreatmentMapping mapping = new ManagePatientTreatmentMapping();
		mapping.setPatienttreatmentDiseaseName(patienttreatment.get(0).get("patienttreatmentDiseaseName").toString());
		mapping.setPatienttreatmentDate(patienttreatment.get(0).get("allergicName").toString());
		mapping.setPatienttreatmentHeartRate(patienttreatment.get(0).get("patienttreatmentHeartRate").toString());
		mapping.setPatienttreatmentPressure(patienttreatment.get(0).get("patienttreatmentPressure").toString());
		mapping.setPatienttreatmentAge(Integer.parseInt(patienttreatment.get(0).get("patienttreatmentAge").toString()));
		mapping.setPatienttreatmentWeight(patienttreatment.get(0).get("patienttreatmentWeight").toString());
		mapping.setPatienttreatmentHeight(patienttreatment.get(0).get("patienttreatmentHeight").toString());
		mapping.setPatienttreatmentStatus(patienttreatment.get(0).get("patienttreatmentStatus").toString());
		mapping.setPatient(patienttreatment.get(0).get("patientName").toString());
		return mapping;
	}

	@Override
	public ArrayList<ManagePatientTreatmentMapping> findPatientTreatment(ManagePatientTreatmentMapping mapping) {
		return patienttreatmentDao.findPatientTreatment(mapping);
	}

	@Override
	public void savePatientTreatment(ManagePatientTreatmentMapping mapping) throws Exception {
		PatientTreatment patienttreatment = new PatientTreatment();
		patienttreatment.setPatienttreatmentDiseaseName(mapping.getPatienttreatmentDiseaseName());
		patienttreatment.setPatienttreatmentDate(mapping.getPatienttreatmentDate());
		patienttreatment.setPatienttreatmentHeartRate(mapping.getPatienttreatmentHeartRate());
		patienttreatment.setPatienttreatmentPressure(mapping.getPatienttreatmentPressure());
		patienttreatment.setPatienttreatmentAge(mapping.getPatienttreatmentAge());
		patienttreatment.setPatienttreatmentWeight(mapping.getPatienttreatmentWeight());
		patienttreatment.setPatienttreatmentHeight(mapping.getPatienttreatmentHeight());
		patienttreatment.setPatienttreatmentStatus(mapping.getPatienttreatmentStatus());
		patienttreatment.setPatientId(mapping.getPatientId());
		
		patienttreatmentDao.savePatientTreatment(patienttreatment);

	}

	@Override
	public void deletePatientTreatment(ManagePatientTreatmentMapping mapping) throws Exception {
		PatientTreatment patienttreatment = new PatientTreatment();
		patienttreatment.setPatienttreatmentId(mapping.getPatienttreatmentId());
		patienttreatmentDao.deletePatientTreatment(patienttreatment);

	}

	@Override
	public void updatePatientTreatment(ManagePatientTreatmentMapping mapping) throws Exception {
		PatientTreatment patienttreatment = patienttreatmentDao.findPatientTreatmentForUpdate(mapping);
		patienttreatment.setPatienttreatmentDiseaseName(mapping.getPatienttreatmentDiseaseName());
		patienttreatment.setPatienttreatmentDate(mapping.getPatienttreatmentDate());
		patienttreatment.setPatienttreatmentHeartRate(mapping.getPatienttreatmentHeartRate());
		patienttreatment.setPatienttreatmentPressure(mapping.getPatienttreatmentPressure());
		patienttreatment.setPatienttreatmentAge(mapping.getPatienttreatmentAge());
		patienttreatment.setPatienttreatmentWeight(mapping.getPatienttreatmentWeight());
		patienttreatment.setPatienttreatmentHeight(mapping.getPatienttreatmentHeight());
		patienttreatment.setPatienttreatmentStatus(mapping.getPatienttreatmentStatus());
		patienttreatment.setPatientId(mapping.getPatientId());
		
		patienttreatmentDao.updatePatientTreatment(patienttreatment);

	}

}
