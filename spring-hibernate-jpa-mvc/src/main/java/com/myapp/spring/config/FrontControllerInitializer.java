package com.myapp.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FrontControllerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
              //Intialzed dispatcher servlet & started spring container
	
	       // these methods are abstract  & are called automatically
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}
                      
	@Override // firts entry point after tomact open the war file
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {AppConfig.class};
	}
            //dispactcher servlet( front controller } to controller mapping
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
