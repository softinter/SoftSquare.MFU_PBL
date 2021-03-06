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
import com.softsquare.application.domain.ManageEmployeeMapping;
import com.softsquare.application.service.EmployeeService;

@RestController
@RequestMapping("/manageEmployee.html")
@Configurable
public class ManageEmployeeController {
	
@Autowired
private EmployeeService employeeService;
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("manageEmployee");
	return ControllerDefault.DefaultModelAndView(mav, request);
}
 
@RequestMapping(params =  "method=save" , method=RequestMethod.POST)
public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManageEmployeeMapping mapping) throws Throwable{
	employeeService.saveEmployee(mapping);
}

@RequestMapping(params =  "method=update" , method=RequestMethod.POST)
public void edit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManageEmployeeMapping mapping) throws Throwable{
	employeeService.updateEmployee(mapping);
}

@RequestMapping(params =  "method=remove" , method=RequestMethod.POST)
public void delete(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManageEmployeeMapping mapping) throws Throwable{
	employeeService.removeEmployee(mapping);
}

@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ManageEmployeeMapping mapping) throws Throwable{
	Gson gson = new Gson();
	String  json = gson.toJson(employeeService.findEmployee(mapping));
	try {
		response.getWriter().write(json);
	} catch (Exception e) {
			e.printStackTrace();
	}
}

}
