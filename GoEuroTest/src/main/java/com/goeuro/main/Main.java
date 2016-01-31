package com.goeuro.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.goeuro.service.IGoEuroService;
import com.goeuro.service.impl.GoEuroServiceImpl;

public class Main {

	private static Log logger = LogFactory.getLog(Main.class);

	public static void main(String[] args) {

		logger.info("Application started");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		IGoEuroService service = context.getBean(GoEuroServiceImpl.class);
		service.startProcess(args);
		logger.info("Application completed!");
	}
}
