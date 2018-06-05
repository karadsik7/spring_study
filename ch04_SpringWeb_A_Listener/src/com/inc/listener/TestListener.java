package com.inc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("app destroy");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("app init");
	}
	
}
