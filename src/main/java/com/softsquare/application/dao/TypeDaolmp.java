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
import com.softsquare.application.domain.ManageTypeMapping;
import com.softsquare.application.entity.Type;

@Repository()
@Component
public class TypeDaolmp extends AbstractDao<Integer, Type> implements TypeDao{
	
	@Override
	public ArrayList<Type> getType() {
		 Criteria criteria = getSession().createCriteria(Type.class, "type");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("type.typeID").as("typeID"))
		            .add(Projections.property("type.typeCode").as("typeCode"))
		            .add(Projections.property("type.typeName").as("typeName"));
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(Type.class));
		 ArrayList<Type> typeList = (ArrayList<Type>) criteria.list();
		return typeList;
	}

	@Override
	public Type getTypeForUpdate(ManageTypeMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Type.class, "type");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("type.typeID").as("typeID"))
		            .add(Projections.property("type.typeCode").as("typeCode"))
		            .add(Projections.property("type.typeName").as("typeName"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(mapping.getTypeCode())){
			 criteria.add(Restrictions.eq("type.typeID", mapping.getTypeID()));			 
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Type.class));
		 Type typeList = (Type) criteria.uniqueResult();
		return typeList;
	}
	
	@Override
	public void saveType(Type type) throws Exception {
		save(type);
	}

	@Override
	public void removeType(Type type) throws Exception {
		delete(type);
	}

	@Override
	public void updateType(Type type) throws Exception {
		merge(type);
	}

}
