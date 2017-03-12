package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.LoginMapping;
import com.softsquare.application.domain.ManageMedicineMapping;
import com.softsquare.application.entity.Medicine;

public interface MedicineService {
	
	public ManageMedicineMapping getMedicine(String medicineName);
	public  ArrayList<ManageMedicineMapping> findMedicine(ManageMedicineMapping manageMedicineMapping); 
	public void saveMedicine(ManageMedicineMapping medicine) throws Exception;
	public void removeMedicine(ManageMedicineMapping medicine) throws Exception;
	public void updateMedicine(ManageMedicineMapping medicine) throws Exception;

}
