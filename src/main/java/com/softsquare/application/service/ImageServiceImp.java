package com.softsquare.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.codec.Base64;
import com.softsquare.application.dao.ImageDao;
import com.softsquare.application.domain.ImageMapping;
import com.softsquare.application.entity.TestPBL;

@Service
public class ImageServiceImp implements ImageService{
 
	@Autowired
	private ImageDao imageDao;
	
	@Override
	public void upLoad(ImageMapping imageMapping) throws Exception {
		byte[] imageDataBytes = Base64.decode(imageMapping.getImageString());
		TestPBL testPBL = new TestPBL();
		testPBL.setHid(imageMapping.getHid());
		testPBL.setDid(imageMapping.getDid());
		testPBL.setImage(imageDataBytes);
		imageDao.saveImage(testPBL);
	}
	
	@Override
	public ImageMapping selectImage() throws Exception {
		return imageDao.selectImage();
	}
	
//	private  byte[] readBytesFromFile(String filePath) throws Exception{
//		 	File inputFile = new File(filePath);
//	        FileInputStream inputStream = new FileInputStream(inputFile);
//	         
//	        byte[] fileBytes = new byte[(int) inputFile.length()];
//	        inputStream.read(fileBytes);
//	        inputStream.close();
//	         
//	        return fileBytes;
//	}

}
