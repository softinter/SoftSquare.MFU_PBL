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
import com.softsquare.application.domain.ManageMedicineMapping;
import com.softsquare.application.service.MedicineService;

@RestController
@RequestMapping("/manageMedicine.html")
@Configurable
public class ManageMedicineController {
	
@Autowired
private MedicineService medicineService;
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("manageMedicine");
	return ControllerDefault.DefaultModelAndView(mav, request);
}
 
@RequestMapping(params =  "method=create" , method=RequestMethod.POST)
public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManageMedicineMapping mapping) throws Throwable{
	medicineService.saveMedicine(mapping);
}

@RequestMapping(params =  "method=update" , method=RequestMethod.POST)
public void edit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManageMedicineMapping mapping) throws Throwable{
	medicineService.updateMedicine(mapping);
}

@RequestMapping(params =  "method=delete" , method=RequestMethod.POST)
public void delete(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManageMedicineMapping mapping) throws Throwable{
	medicineService.removeMedicine(mapping);
}

@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManageMedicineMapping mapping) throws Throwable{
	Gson gson = new Gson();
	String  json = gson.toJson(medicineService.findMedicine(mapping));
	try {
		response.getWriter().write(json);
	} catch (Exception e) {
			e.printStackTrace();
	}
}

}
