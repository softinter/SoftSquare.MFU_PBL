package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.ManagePositionMapping;
import com.softsquare.application.entity.Position;

public interface PositionService {
	
	public ArrayList<Position> getPosition();
	public void savePosition(ManagePositionMapping mapping) throws Exception;
	public void removePosition(ManagePositionMapping mapping) throws Exception;
	public void updatePosition(ManagePositionMapping mapping) throws Exception;

}
