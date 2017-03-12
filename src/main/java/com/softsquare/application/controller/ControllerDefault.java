package com.softsquare.application.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.common.util.LoginUtils;

@Component
public class ControllerDefault {
	
	public static  ModelAndView DefaultModelAndView(ModelAndView mav, HttpServletRequest httpServletRequest){
		Properties prop = new Properties();
		InputStream input = null;
		String domainName = null;
		
		final String[] roleAll = new String[]{"admin", "user"};
		final String[] pageAdmin = new String[]{"home", "registerList", "register", "manageRole", "manageType", "manageMedicine"
				, "manageEmployee", "managePosition", "managePatient", "manageAllergic", "managePatientTreatment"};
		final String[] pageUser = new String[]{"home"};
		
		final String[] pageNoLogin = new String[]{"index", "pageTest"};
		int count = 0;
		
		if(BeanUtils.isNotEmpty(mav.getViewName())){
			if("logoutpage".equals(mav.getViewName())){
				mav.setViewName("index");
				mav.addObject("userNameUserSystem", "");
				mav.addObject("roleUserSystem", "");
			}else{
				
				if(BeanUtils.isNotEmpty(LoginUtils.getRole()) && BeanUtils.isNotEmpty(LoginUtils.getUsername())){
					try{
						//Strat Condition zone add page of role
						if(roleAll[0].equals(LoginUtils.getRole())){ //Admin
							for (String string : pageAdmin) {
								if(string.equals(mav.getViewName())){
									count = 1;
								}
							}
						}else if(roleAll[1].equals(LoginUtils.getRole())){ //User
							for (String string : pageUser) {
								if(string.equals(mav.getViewName())){
									count = 1;
								}
							}
						}else{
							throw new Exception();
						}
						//End Condition zone add page of role
						
						if(count == 0){
							for (String string : pageNoLogin) {
								if(string.equals(mav.getViewName())){
									count = 1;
								}
							}
						}
						
						if(count == 0){
							throw new Exception();
						}
						
						mav.addObject("userNameUserSystem", LoginUtils.getUsername());
						mav.addObject("roleUserSystem", LoginUtils.getRole());
					} catch(Exception ex){
						mav.addObject("userNameUserSystem", LoginUtils.getUsername());
						mav.addObject("roleUserSystem", LoginUtils.getRole());
						mav.setViewName("home");
					}
					
				}else{
					try{
						for (String string : pageNoLogin) {
							if(string.equals(mav.getViewName())){
								count = 1;
							}
						}
						if(count == 0){
							throw new Exception();
						}
					}catch(Exception ex){
						mav.setViewName("index");
					}
				}
			}
		}
		
		try {
			input = new FileInputStream("src/main/resources/application.properties");
			prop.load(input);
			domainName = prop.getProperty("server.contextPath");
		} catch (Exception e) {
			System.out.println("Load file application.properties not found.");
		}
		
		try {
			mav.addObject("nameDomainSystem", domainName);
			mav.addObject("ipDomainSystem", InetAddress.getLocalHost().getHostAddress()+":"+httpServletRequest.getServerPort());
		} catch (Exception e) {
			mav.addObject("nameDomainSystem", domainName);
			mav.addObject("ipDomainSystem", "http://127.0.0.1:"+httpServletRequest.getServerPort());
		}
		
		return mav;
	}
}
