package com.softsquare.application.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.PositionDao;
import com.softsquare.application.domain.ManagePositionMapping;
import com.softsquare.application.entity.Position;

@Service
public class PositionServiceImp implements PositionService {
	
	@Autowired
	private PositionDao positionDao;
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public ArrayList<Position> getPosition() {
		return positionDao.getPosition();
	}

	@Override
	public void savePosition(ManagePositionMapping mapping) throws Exception {
		Position position = new Position();
		System.out.println(mapping.getPositionCode());
		System.out.println(mapping.getPositionName());
		System.out.println(mapping.getPositionDetail());
	
		position.setPositionCode(mapping.getPositionCode());
		position.setPositionName(mapping.getPositionName());
		position.setPositionDetail(mapping.getPositionDetail());
	
		positionDao.savePosition(position);

	}

	@Override
	public void removePosition(ManagePositionMapping mapping) throws Exception {
		Position position = new Position();
		position.setPositionID(mapping.getPositionID());
		positionDao.removePosition(position);

	}

	@Override
	public void updatePosition(ManagePositionMapping mapping) throws Exception {
		Position position = positionDao.getPositionForUpdate(mapping);
		position.setPositionCode(mapping.getPositionCode());
		position.setPositionName(mapping.getPositionName());
		position.setPositionDetail(mapping.getPositionDetail());
	
		positionDao.updatePosition(position);
		

	}

}
