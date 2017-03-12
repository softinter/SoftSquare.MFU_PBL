package com.softsquare.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.softsquare.application.domain.ManageAllergicMapping;
import com.softsquare.application.service.AllergicService;

@RestController
@RequestMapping("/manageAllergic.html")
@Configurable
public class ManageAllergicController {
	
	@Autowired
	AllergicService allergicService;
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response, @RequestParam("patientId") Integer patientId){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("manageAllergic");
    	mav.addObject("headerId", patientId);
    	return ControllerDefault.DefaultModelAndView(mav, request);
    }
	
	@RequestMapping(params =  "method=create" , method=RequestMethod.POST)
    public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManageAllergicMapping mapping) throws Throwable{
		allergicService.saveAllergic(mapping);
	}
	
	@RequestMapping(params =  "method=update" , method=RequestMethod.POST)
    public void edit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManageAllergicMapping mapping) throws Throwable{
		allergicService.updateAllergic(mapping);
	}
	
	@RequestMapping(params =  "method=delete" , method=RequestMethod.POST)
    public void delete(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManageAllergicMapping mapping) throws Throwable{
		allergicService.removeAllergic(mapping);
	}
	
	@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
    public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManageAllergicMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(allergicService.findAllergic(mapping));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

}
