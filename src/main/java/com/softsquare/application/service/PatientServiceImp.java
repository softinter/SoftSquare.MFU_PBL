package com.softsquare.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.AllergicDao;
import com.softsquare.application.dao.PatientDao;
import com.softsquare.application.dao.PatientTreatmentDao;
import com.softsquare.application.domain.ManagePatientMapping;
import com.softsquare.application.entity.Allergic;
import com.softsquare.application.entity.Patient;
import com.softsquare.application.entity.PatientTreatment;

@Service
public class PatientServiceImp implements PatientService {
	
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private AllergicDao allergicDao;
	@Autowired
	private PatientTreatmentDao patienttreatmentDao;
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public ArrayList<Patient> getPatient() {
		return patientDao.getPatient();
	}

	@Override
	public void savePatient(ManagePatientMapping mapping) throws Exception {
		Patient patient = new Patient();
		/*System.out.println(mapping.getPatientName());
		System.out.println(mapping.getPatientBirthday());
		System.out.println(mapping.getPatientAddress());
		System.out.println(mapping.getPatientPhone());
		System.out.println(mapping.getPatientEmail());
		System.out.println(mapping.getPatientGender());
		System.out.println(mapping.getPatientJob());
		System.out.println(mapping.getPatientBloodGroup());*/
		
		patient.setPatientName(mapping.getPatientName());
		patient.setPatientBirthday(mapping.getPatientBirthday());
		patient.setPatientAddress(mapping.getPatientAddress());
		patient.setPatientPhone(mapping.getPatientPhone());
		patient.setPatientEmail(mapping.getPatientEmail());
		patient.setPatientGender(mapping.getPatientGender());
		patient.setPatientJob(mapping.getPatientJob());
		patient.setPatientBloodGroup(mapping.getPatientBloodGroup());
		patientDao.savePatient(patient);

	}

	@Override
	public void removePatient(ManagePatientMapping mapping) throws Exception {
		
		/*get allergic id and delete*/
		List<Map<String, Object>> dataDtlid1 = allergicDao.findAllergicId(mapping.getPatientId());
		for (Map<String, Object> datadtlid : dataDtlid1) {
		Integer allergicId = (Integer) datadtlid.get("allergicId");
		Allergic allergic = new Allergic();
		allergic.setAllergicId(allergicId);
		allergicDao.deleteAllergic(allergic);
		}
		/*end allergic*/
		
		/*get PatientTreatment id and delete*/
		List<Map<String, Object>> dataDtlid2 = patienttreatmentDao.findPatientTreatmentId(mapping.getPatientId());
		for (Map<String, Object> datadtlid : dataDtlid2) {
		Integer patienttreatmentId = (Integer) datadtlid.get("patienttreatmentId");
		PatientTreatment patienttreatment = new PatientTreatment();
		patienttreatment.setPatienttreatmentId(patienttreatmentId);
		patienttreatmentDao.deletePatientTreatment(patienttreatment);
		}
		/*end PatientTreatment*/
		
		Patient patient = new Patient();
		patient.setPatientId(mapping.getPatientId());
		patientDao.removePatient(patient);
	}

	@Override
	public void updatePatient(ManagePatientMapping mapping) throws Exception {
		Patient patient = patientDao.getPatientForUpdate(mapping);
		patient.setPatientName(mapping.getPatientName());
		patient.setPatientBirthday(mapping.getPatientBirthday());
		patient.setPatientAddress(mapping.getPatientAddress());
		patient.setPatientPhone(mapping.getPatientPhone());
		patient.setPatientEmail(mapping.getPatientEmail());
		patient.setPatientGender(mapping.getPatientGender());
		patient.setPatientJob(mapping.getPatientJob());
		patient.setPatientBloodGroup(mapping.getPatientBloodGroup());
		patientDao.updatePatient(patient);
		

	}

}
