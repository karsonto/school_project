package com.karson.school.controller;
 

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import org.springframework.beans.factory.annotation.Value;
 
import org.springframework.stereotype.Controller;
 
import org.springframework.web.bind.annotation.RequestMapping;
 

 
 
@Controller
@RequestMapping("/")
public class BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	 @Value("${key.config.auth}")
    private  String  logoutUrl ;
    @Value("${server.servlet.context-path}")
    private String path ;
	
	@RequestMapping("/index")
	public String toindexView(HttpServletRequest req) {
				 
		return "home/index";
		
	}
	/*
	 * 登出系统清空cookies and session id
	 * **/
	 @RequestMapping("/logout")
	    public String logout(HttpServletRequest request, HttpServletResponse response) {
		 logger.info(logoutUrl);
		 logger.info(path);
		 Cookie[] cookies = request.getCookies();
		 for(Cookie cookie:cookies) {
			 logger.info(cookie.getName());
			    cookie.setValue("");
	            cookie.setPath(path);
	            cookie.setMaxAge(0);
	            response.addCookie(cookie);
		 }	 
			return "redirect:"+logoutUrl;
		 
	        
	    }
 

}
