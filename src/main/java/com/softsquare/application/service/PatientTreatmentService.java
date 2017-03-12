package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.ManagePatientTreatmentMapping;

public interface PatientTreatmentService {
	
	public ManagePatientTreatmentMapping getPatientTreatment(String patienttreatmentDiseaseName);
	public  ArrayList<ManagePatientTreatmentMapping> findPatientTreatment(ManagePatientTreatmentMapping mapping); 
	public void savePatientTreatment(ManagePatientTreatmentMapping mapping) throws Exception;
	public void deletePatientTreatment(ManagePatientTreatmentMapping mapping) throws Exception;
	public void updatePatientTreatment(ManagePatientTreatmentMapping mapping) throws Exception;

}
