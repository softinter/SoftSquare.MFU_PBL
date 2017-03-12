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
import com.softsquare.application.domain.ManageAllergicMapping;
import com.softsquare.application.entity.Allergic;

@Repository()
@Component
public class AllergicDaoImp extends AbstractDao<Integer, Allergic> implements AllergicDao {
	
//	@PersistenceContext
//	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	
	@Override
	public List<Map<String, Object>> findByAllergicCode(String allergicCode) {
		Criteria criteria = getSession().createCriteria(Allergic.class, "allergic");
		 criteria.createAlias("allergic.patient", "patient");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("allergic.allergicCode").as("allergicCode"))
		            .add(Projections.property("allergic.allergicName").as("allergicName"))
		            .add(Projections.property("allergic.allergicDetail").as("allergicDetail"))
		            .add(Projections.property("patient.patientId").as("patientId"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(allergicCode)){
			 criteria.add(Restrictions.eq("allergic.allergiccode", allergicCode));			 
		 }
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 List<Map<String, Object>> allergicList =  criteria.list();
		return allergicList;
	}

	@Override
	public ArrayList<ManageAllergicMapping> findAllergic(ManageAllergicMapping allergicMapping) {
		Criteria criteria = getSession().createCriteria(Allergic.class, "allergic");
		 criteria.createAlias("allergic.patient", "patient");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("allergic.allergicId").as("allergicId"))
		            .add(Projections.property("allergic.allergicCode").as("allergicCode"))
		            .add(Projections.property("allergic.allergicName").as("allergicName"))
		            .add(Projections.property("allergic.allergicDetail").as("allergicDetail"))
		            .add(Projections.property("patient.patientId").as("patientId"));
		            
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(allergicMapping.getPatientId())){
			 criteria.add(Restrictions.eq("patient.patientId", allergicMapping.getPatientId()));			 
		 }
		 if(BeanUtils.isNotEmpty(allergicMapping.getAllergicId())){
			 criteria.add(Restrictions.eq("allergic.allergicId", allergicMapping.getAllergicId()));
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(ManageAllergicMapping.class));
		 ArrayList<ManageAllergicMapping> allergicList =  (ArrayList<ManageAllergicMapping>) criteria.list();
		return allergicList;
	}

	@Override
	public Allergic findAllergicForUpdate(ManageAllergicMapping allergicMapping) {
		Criteria criteria = getSession().createCriteria(Allergic.class, "allergic");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("allergic.allergicId").as("allergicId"))
		            .add(Projections.property("allergic.allergicCode").as("allergicCode"))
		            .add(Projections.property("allergic.allergicName").as("allergicName"))
		            .add(Projections.property("allergic.allergicDetail").as("allergicDetail"))
		            .add(Projections.property("allergic.patientId").as("patientId"));
		            
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(allergicMapping.getAllergicId())){
			 criteria.add(Restrictions.eq("allergic.allergicId", allergicMapping.getAllergicId()));
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Allergic.class));
		 Allergic allergicList =  (Allergic) criteria.uniqueResult();
		 
		return allergicList;
	}

//	@Override
//	public ArrayList<ManageAllergicMapping> findAllergicId(Integer patientId) {
//		Criteria criteria = getSession().createCriteria(Allergic.class, "allergic");
//		 ProjectionList projections = Projections.projectionList()
//				 	.add(Projections.property("allergic.allergicId").as("allergicId"));
//		 			criteria.setProjection(projections);
//		 criteria.add(Restrictions.eq("allergic.patientId", patientId));			 
//		 criteria.setResultTransformer(Transformers.aliasToBean(ManageAllergicMapping.class));
//		 ArrayList<ManageAllergicMapping> allergicList =  (ArrayList<ManageAllergicMapping>) criteria.list();
//		return allergicList;
//	}
	
	/*send patient id to search allergic id*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findAllergicId(Integer patientId) {
		Criteria criteria = getSession().createCriteria(Allergic.class, "allergic");
	
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("allergic.allergicId"), "allergicId");
		
		criteria.add(Restrictions.eq("allergic.patientId",patientId));
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<Map<String, Object>> arrayMap = new ArrayList<Map<String, Object>>();
		arrayMap.addAll((ArrayList<Map<String, Object>>) criteria.list());
		return arrayMap;
	}

	@Override
	public void saveAllergic(Allergic allergic) throws Exception {
		save(allergic);
		
	}

	@Override
	public void updateAllergic(Allergic allergic) throws Exception {
		merge(allergic);
		
	}

	@Override
	public void deleteAllergic(Allergic allergic) throws Exception {
		delete(allergic);
	}
	

//	@Override
//	public void deleteAllergicWithMom(Integer patientId) throws Exception {
//		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
//		CriteriaDelete<Allergic> delete = cb.createCriteriaDelete(Allergic.class);
//		Root e = delete.from(Allergic.class);
//		delete.where(cb.equal(e.get("patientId"), patientId));
//		this.entityManager.createQuery(delete).executeUpdate();
//		
//	}

}
