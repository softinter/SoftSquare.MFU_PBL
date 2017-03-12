package com.softsquare.application.dao;

import com.softsquare.application.domain.ImageMapping;
import com.softsquare.application.entity.TestPBL;

public interface ImageDao {
	
	public void saveImage(TestPBL pbl) throws Exception;
	public void updateImage(TestPBL pbl) throws Exception;
	public void deleteImage(TestPBL pbl) throws Exception;
	public ImageMapping selectImage() throws Exception;
	
}
