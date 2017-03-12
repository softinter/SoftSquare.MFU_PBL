package com.softsquare.application.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.domain.ImageMapping;
import com.softsquare.application.entity.TestPBL;

@Repository()
@Component
public class ImageDaoImp  extends AbstractDao<Integer, TestPBL> implements ImageDao {

	@Override
	public void saveImage(TestPBL pbl) throws Exception {
		save(pbl);
	}

	@Override
	public void updateImage(TestPBL pbl) throws Exception {
		merge(pbl);	
	}

	@Override
	public void deleteImage(TestPBL pbl) throws Exception {
		delete(pbl);
	}

	@Override
	public ImageMapping selectImage() throws Exception {
		Criteria criteria = getSession().createCriteria(TestPBL.class, "bpl");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("bpl.hid").as("hid"))
		            .add(Projections.property("bpl.did").as("did"))
		            .add(Projections.property("bpl.image").as("image"));
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(ImageMapping.class));
		 ArrayList<ImageMapping> imageMapping = (ArrayList<ImageMapping>) criteria.list();
		return imageMapping.get(0);
	}
	

}
