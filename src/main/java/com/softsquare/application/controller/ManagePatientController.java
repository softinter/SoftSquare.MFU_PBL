package com.softsquare.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.softsquare.application.domain.ManagePatientMapping;
import com.softsquare.application.service.PatientService;

@RestController
@RequestMapping("/managePatient.html")
@Configurable
public class ManagePatientController {
	
@Autowired
 PatientService patientSerivce;
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("managePatient");
	return ControllerDefault.DefaultModelAndView(mav, request);
}
 
@RequestMapping(params =  "method=create" , method=RequestMethod.POST)
public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManagePatientMapping mapping) throws Throwable{
	patientSerivce.savePatient(mapping);
}

@RequestMapping(params =  "method=update" , method=RequestMethod.POST)
public void edit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManagePatientMapping mapping) throws Throwable{
	patientSerivce.updatePatient(mapping);
}

@RequestMapping(params =  "method=delete" , method=RequestMethod.POST)
public void delete(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManagePatientMapping mapping) throws Throwable{
	patientSerivce.removePatient(mapping);
}

@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManagePatientMapping mapping) throws Throwable{
	Gson gson = new Gson();
	String  json = gson.toJson(patientSerivce.getPatient());
	try {
		response.getWriter().write(json);
	} catch (Exception e) {
			e.printStackTrace();
	}
}

}
