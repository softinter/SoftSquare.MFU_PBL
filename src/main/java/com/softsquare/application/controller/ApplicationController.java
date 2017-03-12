package com.softsquare.application.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {
	protected final Logger log = LoggerFactory.getLogger(getClass());

	
    @RequestMapping(value="/*",method=RequestMethod.GET)
    public ModelAndView etc(HttpServletRequest httpServletRequest){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("index");
    	return ControllerDefault.DefaultModelAndView(mav, httpServletRequest);
    }
	
	@RequestMapping(value={"/","/index.html"},method=RequestMethod.GET)
    public ModelAndView login(HttpServletRequest httpServletRequest){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("index");
    	return ControllerDefault.DefaultModelAndView(mav, httpServletRequest);
    }
	
	@RequestMapping(value={"/pageTest", "/pageTest.html"},method=RequestMethod.GET)
    public ModelAndView tess(HttpServletRequest httpServletRequest){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("pageTest");
    	return ControllerDefault.DefaultModelAndView(mav, httpServletRequest);
    }
    
    @RequestMapping(value={"/loginfail.html"},method=RequestMethod.GET)
    public ModelAndView loginfail(HttpServletRequest httpServletRequest){
    	ModelAndView mav = new ModelAndView();
		mav.addObject("error", "Invalid username and password!");
    	mav.setViewName("index");
    	return ControllerDefault.DefaultModelAndView(mav, httpServletRequest);
    }
    
    @RequestMapping(value={"/logoutpage.html"},method=RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest httpServletRequest){
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("msg", "You've been logged out successfully.");
    	mav.setViewName("logoutpage");
    	HttpSession session= httpServletRequest.getSession(false);
        SecurityContextHolder.clearContext();
             session= httpServletRequest.getSession(false);
            if(session != null) {
                session.invalidate();
            }
            for(Cookie cookie : httpServletRequest.getCookies()) {
                cookie.setMaxAge(0);
            }
    	return ControllerDefault.DefaultModelAndView(mav, httpServletRequest);
    }
    
    @RequestMapping(value="/home.html",method=RequestMethod.GET)
    public ModelAndView home(HttpServletRequest httpServletRequest){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("home");
    	return ControllerDefault.DefaultModelAndView(mav, httpServletRequest);
    }
    
    @RequestMapping(value="/error.html",method=RequestMethod.GET)
    public ModelAndView error(HttpServletRequest httpServletRequest){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("error");
    	return  ControllerDefault.DefaultModelAndView(mav, httpServletRequest);
    }
    
}
