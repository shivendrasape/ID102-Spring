package com.myapp.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


//@Component
//@Aspect
@EnableAspectJAutoProxy
public class SecurityAspect {
	
	@Autowired
	private LoginManagerBean loginManagerBean;
	
	//@Before("execution (* com.myapp.spring.dao.*.*(..))") // any return type under dao for any classes any method and any  arg// Point cut
	public void verify() {
		
		LoginBean loginBean=loginManagerBean.getLoggedInUser();
		if(loginBean==null) {
			
			throw new SecurityException("Please Login To Acess the methods");
		}
		
		else {
			
			if(loginBean.getUsername().equals("admin")) {
				System.out.println("*****************");
				System.out.println("*****************");
				System.out.println("Welcome User "+loginBean.getUsername());
				System.out.println("*****************");
				System.out.println("*****************");
			}
			else
			throw new SecurityException("Invalid Username");
		}
	}
	
	

}
