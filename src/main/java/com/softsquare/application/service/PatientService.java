package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.ManagePatientMapping;
import com.softsquare.application.entity.Patient;

public interface PatientService {
	
	public ArrayList<Patient> getPatient();
	public void savePatient(ManagePatientMapping mapping) throws Exception;
	public void removePatient(ManagePatientMapping mapping) throws Exception;
	public void updatePatient(ManagePatientMapping mapping) throws Exception;

}
