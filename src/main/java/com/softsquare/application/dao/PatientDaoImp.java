package com.softsquare.application.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.domain.ManagePatientMapping;
import com.softsquare.application.entity.Patient;


@Repository()
@Component
public class PatientDaoImp extends AbstractDao<Integer, Patient> implements PatientDao {

	@Override
	public ArrayList<Patient> getPatient() {
		 Criteria criteria = getSession().createCriteria(Patient.class, "patient");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("patient.patientId").as("patientId"))
		            .add(Projections.property("patient.patientName").as("patientName"))
		            .add(Projections.property("patient.patientBirthday").as("patientBirthday"))
		            .add(Projections.property("patient.patientAddress").as("patientAddress"))
		            .add(Projections.property("patient.patientPhone").as("patientPhone"))
		            .add(Projections.property("patient.patientEmail").as("patientEmail"))
		            .add(Projections.property("patient.patientGender").as("patientGender"))
		            .add(Projections.property("patient.patientJob").as("patientJob"))
		            .add(Projections.property("patient.patientBloodGroup").as("patientBloodGroup"));
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(Patient.class));
		 ArrayList<Patient> patientList = (ArrayList<Patient>) criteria.list();
		return patientList;
	}
	
	@Override
	public Patient getPatientForUpdate(ManagePatientMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Patient.class, "patient");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("patient.patientId").as("patientId"))
		            .add(Projections.property("patient.patientName").as("patientName"))
		            .add(Projections.property("patient.patientBirthday").as("patientBirthday"))
		            .add(Projections.property("patient.patientAddress").as("patientAddress"))
		            .add(Projections.property("patient.patientPhone").as("patientPhone"))
		            .add(Projections.property("patient.patientEmail").as("patientEmail"))
		            .add(Projections.property("patient.patientGender").as("patientGender"))
		            .add(Projections.property("patient.patientJob").as("patientJob"))
		            .add(Projections.property("patient.patientBloodGroup").as("patientBloodGroup"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(mapping.getPatientName())){
			 criteria.add(Restrictions.eq("patient.patientId", mapping.getPatientId()));			 
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Patient.class));
		 Patient patientList = (Patient) criteria.uniqueResult();
		return patientList;
	}

	@Override
	public void savePatient(Patient patient) throws Exception {
		save(patient);

	}

	@Override
	public void removePatient(Patient patient) throws Exception {
		delete(patient);

	}

	@Override
	public void updatePatient(Patient patient) throws Exception {
		merge(patient);
		
	}

	

}
