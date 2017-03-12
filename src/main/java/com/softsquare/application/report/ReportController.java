package com.softsquare.application.report;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softsquare.application.controller.ControllerDefault;
import com.softsquare.application.domain.ReportMapping;

@Controller
public class ReportController {

    @Autowired
    private JasperGenerateReport jasperGenerateReport;
    
    @RequestMapping(value="/report.html", method = RequestMethod.GET)
    public ModelAndView generateReport(@ModelAttribute ReportMapping reportMapping,HttpServletRequest request,HttpServletResponse response){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName(reportMapping.getReportName());
    	return ControllerDefault.DefaultModelAndView(mav, request);
    }
	
	@RequestMapping(value="/reportGen.html", method=RequestMethod.GET)
    public void report01Generate(@RequestParam("reportParameter") String reportParameter, HttpServletRequest request, HttpServletResponse response){
		try {
			jasperGenerateReport.generateMainReport(reportParameter, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}