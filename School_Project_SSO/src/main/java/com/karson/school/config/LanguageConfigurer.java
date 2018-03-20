package com.karson.school.config;

import java.util.Locale;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
 
@Configuration
public class LanguageConfigurer extends WebMvcConfigurerAdapter{
	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        // 多个拦截器组成一个拦截器链
	       // registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login**");
	        //super.addInterceptors(registry);
		  registry.addInterceptor(localeChangeInterceptor());
	    }

	    @Bean  
	    public LocaleResolver localeResolver() {  
	    	   SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
	    	    sessionLocaleResolver.setDefaultLocale(Locale.US);
	        return sessionLocaleResolver;  
	    }  
	  
	    @Bean  
	    public LocaleChangeInterceptor localeChangeInterceptor() {  
	        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();  
	        lci.setParamName("lang");  
	        return lci;  
	    }  

}
