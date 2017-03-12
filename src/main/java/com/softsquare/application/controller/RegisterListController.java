package com.softsquare.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.softsquare.application.domain.OrderDetailMapping;

@RestController
@RequestMapping("/registerList.html")
@Configurable
public class RegisterListController {

	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("registerList");
    	return ControllerDefault.DefaultModelAndView(mav, request);
    }
	 
	@RequestMapping(params =  {"method=search"} , method=RequestMethod.POST)
    public void orderDetailSumPrice(HttpServletRequest request, HttpServletResponse response, @ModelAttribute OrderDetailMapping orderDetailMapping) throws Throwable{
//	 Gson gson = new Gson();
//	 String  json = gson.toJson(orderDetailService.orderDetailSumPrice(orderDetailMapping.getHyOrdhId()));
//	 response.getWriter().write(json);
	}
	
	
}
