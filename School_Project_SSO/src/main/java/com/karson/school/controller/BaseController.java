package com.karson.school.controller;
 
import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
 
import org.springframework.web.bind.annotation.RequestMapping;
 

 
 
@Controller
@RequestMapping("/")
public class BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	 @Value("${key.auth}")
    private  String  logoutUrl ;
    @Value("${server.context-path}")
    private String path ;
	
	@RequestMapping("/index")
	public String toindexView(HttpServletRequest req) {
				 
		return "home/index";
		
	}
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
