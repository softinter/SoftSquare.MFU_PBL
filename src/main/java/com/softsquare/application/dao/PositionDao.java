package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.ManagePositionMapping;
import com.softsquare.application.entity.Position;

public interface PositionDao {
	public  ArrayList<Position> getPosition();
	public  Position getPositionForUpdate(ManagePositionMapping mapping);
	public void savePosition(Position position) throws Exception;
	public void removePosition(Position position) throws Exception;
	public void updatePosition(Position position) throws Exception;

}
