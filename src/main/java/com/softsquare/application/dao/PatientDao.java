package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.ManagePatientMapping;
import com.softsquare.application.entity.Patient;

public interface PatientDao {
	public  ArrayList<Patient> getPatient();
	public  Patient getPatientForUpdate(ManagePatientMapping mapping);
	public void savePatient(Patient patient) throws Exception;
	public void removePatient(Patient patient) throws Exception;
	public void updatePatient(Patient patient) throws Exception;

}
