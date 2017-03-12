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
import com.softsquare.application.domain.ManagePatientTreatmentMapping;
import com.softsquare.application.entity.PatientTreatment;

@Repository()
@Component
public class PatientTreatmentDaoImp extends AbstractDao<Integer, PatientTreatment> implements PatientTreatmentDao {
	@SuppressWarnings("unchecked")
	
	@Override
	public List<Map<String, Object>> findByPatientTreatDiseaseName(String patienttreatmentDiseaseName) {
		Criteria criteria = getSession().createCriteria(PatientTreatment.class, "patienttreatment");
		 criteria.createAlias("patienttreatment.patient", "patient");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("patienttreatment.patienttreatmentDiseaseName").as("patienttreatmentDiseaseName"))
		            .add(Projections.property("patienttreatment.patienttreatmentDate").as("patienttreatmentDate"))
		            .add(Projections.property("patienttreatment.patienttreatmentHeartRate").as("patienttreatmentHeartRate"))
		            .add(Projections.property("patienttreatment.patienttreatmentPressure").as("patienttreatmentPressure"))
		            .add(Projections.property("patienttreatment.patienttreatmentAge").as("patienttreatmentAge"))
		            .add(Projections.property("patienttreatment.patienttreatmentWeight").as("patienttreatmentWeight"))
		            .add(Projections.property("patienttreatment.patienttreatmentHeight").as("patienttreatmentHeight"))
		            .add(Projections.property("patienttreatment.patienttreatmentStatus").as("patienttreatmentStatus"))
		            .add(Projections.property("patient.patientId").as("patientId"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(patienttreatmentDiseaseName)){
			 criteria.add(Restrictions.eq("patienttreatment.patienttreatmentDiseaseName", patienttreatmentDiseaseName));			 
		 }
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 List<Map<String, Object>> patienttreatmentList =  criteria.list();
		return patienttreatmentList;
	}

	@Override
	public ArrayList<ManagePatientTreatmentMapping> findPatientTreatment(ManagePatientTreatmentMapping mapping) {
		Criteria criteria = getSession().createCriteria(PatientTreatment.class, "patienttreatment");
		 criteria.createAlias("patienttreatment.patient", "patient");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("patienttreatment.patienttreatmentId").as("patienttreatmentId"))
		            .add(Projections.property("patienttreatment.patienttreatmentDiseaseName").as("patienttreatmentDiseaseName"))
		            .add(Projections.property("patienttreatment.patienttreatmentDate").as("patienttreatmentDate"))
		            .add(Projections.property("patienttreatment.patienttreatmentHeartRate").as("patienttreatmentHeartRate"))
		            .add(Projections.property("patienttreatment.patienttreatmentPressure").as("patienttreatmentPressure"))
		            .add(Projections.property("patienttreatment.patienttreatmentAge").as("patienttreatmentAge"))
		            .add(Projections.property("patienttreatment.patienttreatmentWeight").as("patienttreatmentWeight"))
		            .add(Projections.property("patienttreatment.patienttreatmentHeight").as("patienttreatmentHeight"))
		            .add(Projections.property("patienttreatment.patienttreatmentStatus").as("patienttreatmentStatus"))
		            .add(Projections.property("patient.patientName").as("patient"))
		            .add(Projections.property("patient.patientId").as("patientId"));
		            
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(mapping.getPatientId())){
			 criteria.add(Restrictions.eq("patient.patientId", mapping.getPatientId()));			 
		 }
		 if(BeanUtils.isNotEmpty(mapping.getPatienttreatmentId())){
			 criteria.add(Restrictions.eq("patienttreatment.patienttreatmentId", mapping.getPatienttreatmentId()));
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(ManagePatientTreatmentMapping.class));
		 ArrayList<ManagePatientTreatmentMapping> resultList =  (ArrayList<ManagePatientTreatmentMapping>) criteria.list();
		return resultList;
	}

	@Override
	public PatientTreatment findPatientTreatmentForUpdate(ManagePatientTreatmentMapping mapping) {
		Criteria criteria = getSession().createCriteria(PatientTreatment.class, "patienttreatment");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("patienttreatment.patienttreatmentId").as("patienttreatmentId"))
		            .add(Projections.property("patienttreatment.patienttreatmentDiseaseName").as("patienttreatmentDiseaseName"))
		            .add(Projections.property("patienttreatment.patienttreatmentDate").as("patienttreatmentDate"))
		            .add(Projections.property("patienttreatment.patienttreatmentHeartRate").as("patienttreatmentHeartRate"))
		            .add(Projections.property("patienttreatment.patienttreatmentPressure").as("patienttreatmentPressure"))
		            .add(Projections.property("patienttreatment.patienttreatmentAge").as("patienttreatmentAge"))
		            .add(Projections.property("patienttreatment.patienttreatmentWeight").as("patienttreatmentWeight"))
		            .add(Projections.property("patienttreatment.patienttreatmentHeight").as("patienttreatmentHeight"))
		            .add(Projections.property("patienttreatment.patienttreatmentStatus").as("patienttreatmentStatus"))
		            .add(Projections.property("patienttreatment.patientId").as("patientId"));
		            
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(mapping.getPatienttreatmentId())){
			 criteria.add(Restrictions.eq("patienttreatment.patienttreatmentId", mapping.getPatienttreatmentId()));
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(PatientTreatment.class));
		 PatientTreatment resultList =  (PatientTreatment) criteria.uniqueResult();
		 
		return resultList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findPatientTreatmentId(Integer patientId) {
		Criteria criteria = getSession().createCriteria(PatientTreatment.class, "patienttreatment");
	
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("patienttreatment.patienttreatmentId"), "patienttreatmentId");
		
		criteria.add(Restrictions.eq("patienttreatment.patientId",patientId));
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<Map<String, Object>> arrayMap = new ArrayList<Map<String, Object>>();
		arrayMap.addAll((ArrayList<Map<String, Object>>) criteria.list());
		return arrayMap;
	}

	@Override
	public void savePatientTreatment(PatientTreatment patienttreatment) throws Exception {
		save(patienttreatment);

	}

	@Override
	public void updatePatientTreatment(PatientTreatment patienttreatment) throws Exception {
		merge(patienttreatment);

	}

	@Override
	public void deletePatientTreatment(PatientTreatment patienttreatment) throws Exception {
		delete(patienttreatment);

	}

	

}
