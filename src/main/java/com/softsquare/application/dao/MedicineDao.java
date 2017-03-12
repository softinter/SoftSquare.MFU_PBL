package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.softsquare.application.domain.ManageMedicineMapping;
import com.softsquare.application.entity.Medicine;

public interface MedicineDao {
	public List<Map<String, Object>> findByMedicinename(String medicineName);
	public  ArrayList<ManageMedicineMapping> findMedicine(ManageMedicineMapping manageMedicineMapping);
	public Medicine findMedicineForUpdate(ManageMedicineMapping manageMedicineMapping);
	public void saveMedicine(Medicine medicine) throws Exception;
	public void updateMedicine(Medicine medicine) throws Exception;
	public void deleteMedicine(Medicine medicine) throws Exception;

}
