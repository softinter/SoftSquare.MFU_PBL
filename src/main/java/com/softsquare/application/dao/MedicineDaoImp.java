package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.domain.ManageMedicineMapping;
import com.softsquare.application.entity.Medicine;
import com.softsquare.application.entity.OrderDetail;
import com.softsquare.application.domain.ManageTypeMapping;

@Repository()
@Component
public class MedicineDaoImp extends AbstractDao<Integer, Medicine> implements MedicineDao  {

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findByMedicinename(String medicineName) {
		 Criteria criteria = getSession().createCriteria(Medicine.class, "medicine");
		 criteria.createAlias("medicine.type", "type");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("medicine.medicineID").as("medicineID"))
		            .add(Projections.property("medicine.medicineName").as("medicineName"))
		            .add(Projections.property("medicine.medicineCost").as("medicineCost"))
		            .add(Projections.property("type.typeCode").as("typeCode"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(medicineName)){
			 criteria.add(Restrictions.eq("medicine.username", medicineName));			 
		 }
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 List<Map<String, Object>> medicineList =  criteria.list();
		return medicineList;
	}
	
	@Override
	public  ArrayList<ManageMedicineMapping> findMedicine(ManageMedicineMapping manageMedicineMapping) {
		Criteria criteria = getSession().createCriteria(Medicine.class, "medicine");
		 criteria.createAlias("medicine.type", "type");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("medicine.medicineID").as("medicineID"))
		            .add(Projections.property("medicine.medicineName").as("medicineName"))
		            .add(Projections.property("medicine.medicineCost").as("medicineCost"))
		            .add(Projections.property("medicine.typeID").as("typeID"))
		            .add(Projections.property("type.typeName").as("typeName"));
		            
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(manageMedicineMapping.getTypeID())){
			 criteria.add(Restrictions.eq("type.typeID", manageMedicineMapping.getTypeID()));			 
		 }
		 if(BeanUtils.isNotEmpty(manageMedicineMapping.getMedicineID())){
			 criteria.add(Restrictions.eq("medicine.medicineID", manageMedicineMapping.getMedicineID()));
		 }
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<ManageMedicineMapping> resultList =  (ArrayList<ManageMedicineMapping>) criteria.list();
		return resultList;
	}
	
	@Override
	public Medicine findMedicineForUpdate(ManageMedicineMapping manageMedicineMapping) {
		Criteria criteria = getSession().createCriteria(Medicine.class, "medicine");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("medicine.medicineID").as("medicineID"))
		            .add(Projections.property("medicine.medicineName").as("medicineName"))
		            .add(Projections.property("medicine.medicineCost").as("medicineCost"))
		     //       .add(Projections.property("type.typeCode").as("typeCode"))
		            .add(Projections.property("type.typeID").as("typeID"));
		            
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(manageMedicineMapping.getMedicineName())){
			 criteria.add(Restrictions.eq("medicine.medicineName", manageMedicineMapping.getMedicineName()));
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Medicine.class));
		 Medicine resultList =  (Medicine) criteria.uniqueResult();
		 
		return resultList;
	}

	@Override
	public void saveMedicine(Medicine medicine) throws Exception {
		save(medicine);
	}

	@Override
	public void updateMedicine(Medicine medicine) throws Exception {
		merge(medicine);		
	}

	@Override
	public void deleteMedicine(Medicine medicine) throws Exception  {
		delete(medicine);
	}

	
	
}
