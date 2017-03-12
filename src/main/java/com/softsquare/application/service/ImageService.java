package com.softsquare.application.service;

import com.softsquare.application.domain.ImageMapping;

public interface ImageService {

	public void upLoad(ImageMapping imageMapping) throws Exception;
	public ImageMapping selectImage() throws Exception;
	
}
