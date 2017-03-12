package com.softsquare.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.MedicineDao;
import com.softsquare.application.domain.LoginMapping;
import com.softsquare.application.domain.ManageMedicineMapping;
import com.softsquare.application.entity.Medicine;

@Service
public class MedicineServiceImp implements MedicineService {
	
	@Autowired
	private MedicineDao medicineDao;
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public ManageMedicineMapping getMedicine(String medicineName) {
		List<Map<String, Object>> medicine = medicineDao.findByMedicinename(medicineName);
		ManageMedicineMapping manageMedicineMapping = new ManageMedicineMapping();
		manageMedicineMapping.setMedicineName(medicine.get(0).get("medicineName").toString());
		manageMedicineMapping.setMedicineCost(Integer.parseInt(medicine.get(0).get("medicineCost").toString()));
		
		manageMedicineMapping.setType(medicine.get(0).get("typeCode").toString());
		return manageMedicineMapping;
		}
		
		@Override
		public  ArrayList<ManageMedicineMapping> findMedicine(ManageMedicineMapping manageMedicineMapping) {
			return medicineDao.findMedicine(manageMedicineMapping);
	}

	@Override
	public void saveMedicine(ManageMedicineMapping mapping) throws Exception {
		Medicine medicine = new Medicine();
		System.out.println(mapping.getMedicineName());
		System.out.println(mapping.getMedicineCost());


		
		medicine.setMedicineName(mapping.getMedicineName());
		medicine.setMedicineCost(mapping.getMedicineCost());
		
		medicine.setTypeID(mapping.getTypeID());
		medicineDao.saveMedicine(medicine);

	}

	@Override
	public void removeMedicine(ManageMedicineMapping mapping) throws Exception {
		Medicine medicine = new Medicine();
		medicine.setMedicineID(mapping.getMedicineID());
		medicineDao.deleteMedicine(medicine);

	}

	@Override
	public void updateMedicine(ManageMedicineMapping mapping) throws Exception {
		Medicine medicine = medicineDao.findMedicineForUpdate(mapping);
		medicine.setMedicineName(mapping.getMedicineName());
		medicine.setMedicineCost(mapping.getMedicineCost());
		
	
		medicineDao.updateMedicine(medicine);
		

	}

}