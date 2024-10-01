package com.ta.mytel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class MyTelApp {
	 private static final Logger logger = LogManager.getLogger(MyTelApp.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("Application started.");
        logger.debug("Debugging information.");
        logger.error("An error occurred.");
	}

}
