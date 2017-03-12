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
import com.softsquare.application.domain.ManagePositionMapping;
import com.softsquare.application.entity.Position;


@Repository()
@Component
public class PositionDaoImp extends AbstractDao<Integer, Position> implements PositionDao {

	@Override
	public ArrayList<Position> getPosition() {
		 Criteria criteria = getSession().createCriteria(Position.class, "position");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("position.positionID").as("positionID"))
		            .add(Projections.property("position.positionCode").as("positionCode"))
		            .add(Projections.property("position.positionName").as("positionName"))
		 			.add(Projections.property("position.positionDetail").as("positionDetail"));
		          
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(Position.class));
		 ArrayList<Position> positionList = (ArrayList<Position>) criteria.list();
		return positionList;
	}
	
	@Override
	public Position getPositionForUpdate(ManagePositionMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Position.class, "position");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("position.positionID").as("positionID"))
		            .add(Projections.property("position.positionCode").as("positionCode"))
		            .add(Projections.property("position.positionName").as("positionName"))
		            .add(Projections.property("position.positionDetail").as("positionDetail"));
		    
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(mapping.getPositionName())){
			 criteria.add(Restrictions.eq("position.positionID", mapping.getPositionID()));			 
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Position.class));
		 Position positionList = (Position) criteria.uniqueResult();
		return positionList;
	}

	@Override
	public void savePosition(Position position) throws Exception {
		save(position);

	}

	@Override
	public void removePosition(Position position) throws Exception {
		delete(position);

	}

	@Override
	public void updatePosition(Position position) throws Exception {
		merge(position);
		
	}

	

}
