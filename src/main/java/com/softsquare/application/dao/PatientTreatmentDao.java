package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.softsquare.application.domain.ManagePatientTreatmentMapping;
import com.softsquare.application.entity.PatientTreatment;

public interface PatientTreatmentDao {
	
	public List<Map<String, Object>> findByPatientTreatDiseaseName(String patienttreatmentDiseaseName);
	public  ArrayList<ManagePatientTreatmentMapping> findPatientTreatment(ManagePatientTreatmentMapping mapping);
	public PatientTreatment findPatientTreatmentForUpdate(ManagePatientTreatmentMapping mapping);
	public void savePatientTreatment(PatientTreatment patienttreatment) throws Exception;
	public void updatePatientTreatment(PatientTreatment patienttreatment) throws Exception;
	public void deletePatientTreatment(PatientTreatment patienttreatment) throws Exception;
	List<Map<String, Object>> findPatientTreatmentId(Integer patientId);
	
	
	


}
