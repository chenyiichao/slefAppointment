package com.cyc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.cyc.util.TimerManager;

public class NFDFlightDataTaskListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		new TimerManager();
	}

}
