package com.goeuro.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.goeuro.exception.GoEuroApplicationException;
import com.goeuro.service.IGoEuroService;
import com.goeuro.service.impl.GoEuroServiceImpl;

public class Main {

	private static Log logger = LogFactory.getLog(Main.class);

	public static void main(String[] args) {

		logger.info("Application started");
		try {
			@SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"classpath:applicationContext.xml");
			IGoEuroService service = context.getBean(GoEuroServiceImpl.class);
			service.startProcess(args);
		} catch (BeansException e) {
			logger.error("ERROR!!!! Did you check the Internet connection?");
		} catch (GoEuroApplicationException e) {
			logger.error("Error occured while processing"+e.getMessage());
		}
		logger.info("Application completed!");
	}
}
