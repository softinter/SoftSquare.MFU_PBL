package com.softsquare.application.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.softsquare.application.entity.Login;
import com.softsquare.application.entity.Position;
import com.softsquare.application.entity.Role;
import com.softsquare.application.service.LoginService;
import com.softsquare.application.service.PositionService;
import com.softsquare.application.service.RoleService;
import com.softsquare.application.entity.Type;
import com.softsquare.application.service.TypeService;

@RestController
@RequestMapping("/combobox.html")
@Configurable
public class ComboboxController {
	
	@Autowired
	private RoleService roleSerivce;
	
	@RequestMapping(params =  "method=role" , method=RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response){
		ArrayList<Role> roleList =  roleSerivce.getRole();
		Gson gson = new Gson();
		String  json = gson.toJson(roleList);
		try {
//			response.getWriter().write("{records:"+json+"}");
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@Autowired
	private TypeService typeService;
	@RequestMapping(params =  "method=type" , method=RequestMethod.POST)
    public void medicine(HttpServletRequest request, HttpServletResponse response){
		ArrayList<Type> typeList =  typeService.getType();
		Gson gson = new Gson();
		String  json = gson.toJson(typeList);
		try {
//			response.getWriter().write("{records:"+json+"}");
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}
	
	
	@Autowired
	private PositionService positionService;
	@RequestMapping(params =  "method=position" , method=RequestMethod.POST)
    public void employee(HttpServletRequest request, HttpServletResponse response){
		ArrayList<Position> positionList =  positionService.getPosition();
		Gson gson = new Gson();
		String  json = gson.toJson(positionList);
		try {
//			response.getWriter().write("{records:"+json+"}");
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}
	
	@Autowired
	private LoginService loginService;
	@RequestMapping(params =  "method=login" , method=RequestMethod.POST)
    public void employee1(HttpServletRequest request, HttpServletResponse response){
		ArrayList<Login> loginList =  loginService.getLogin();
		Gson gson = new Gson();
		String  json = gson.toJson(loginList);
		try {
//			response.getWriter().write("{records:"+json+"}");
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}
//	@RequestMapping(params =  "method=period" , method=RequestMethod.POST)
//    public void period(@ModelAttribute PeriodMapping periodMapping, HttpServletRequest request, HttpServletResponse response){
//		try {
//			Gson gson = new Gson();
//			ArrayList<Period> periodList =  periodService.findPeriod(periodMapping);
//			Integer totalRecord = periodService.findPeriodPagingTotalRecord(periodMapping);
//			ArrayList<ComboBoxMapping> comboBoxMapping = new ArrayList<ComboBoxMapping>();
//			for (Period period : periodList) {
//				ComboBoxMapping boxMapping = new ComboBoxMapping();
//				boxMapping.setValueField(period.getHyPeriodId().toString());
//				boxMapping.setDisplayField(period.getHyPeriodName());
//				boxMapping.setDescriptionField(DateUtils.formatShortDate(period.getHyPeriodDate()));
//				boxMapping.setValueBigDecimal1(period.getHyPeriodPrice2());
//				boxMapping.setValueBigDecimal2(period.getHyPeriodPrice3());
//				comboBoxMapping.add(boxMapping);
//			}
//			String  json = gson.toJson(comboBoxMapping);
//			response.getWriter().write("{records:"+json+", total:"+totalRecord+"}");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@RequestMapping(params =  "method=period2" , method=RequestMethod.POST)
//    public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute PeriodMapping periodMapping) throws Throwable{
//	 Gson gson = new Gson();
//	 String  json = gson.toJson(periodService.findPeriod(periodMapping));
//	 response.getWriter().write("{records:"+json+"}");
//	}
//	
//	@RequestMapping(params =  "method=orderList" , method=RequestMethod.POST)
//    public void orderList(@ModelAttribute OrderHeaderMapping orderHeaderMapping, HttpServletRequest request, HttpServletResponse response){
//		try {
//			 Gson gson = new Gson();
//			 String  json = gson.toJson(orderHeaderService.search(orderHeaderMapping));
//			 Integer totalRecord = orderHeaderService.pagingTotalRecord(orderHeaderMapping);
//			response.getWriter().write("{records:"+json+", total:"+totalRecord+"}");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
}
