package com.ta.mytel.utility;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseConnection {
	    private static BasicDataSource dataSource = new BasicDataSource();
	    private static Properties tempConfig = DbConfig.getProperties();
	    private static Logger logger=LogManager.getLogger();
	    private DatabaseConnection() {}
	    
	    static {
	        reloadProperties(tempConfig);
	    }
	    
	    private static void configureDataBase() {
	        Properties config = DbConfig.getProperties();
	        if (config != tempConfig) {
	            tempConfig = config;
	            reloadProperties(config);
	        }
	    }
	    
	    private static void reloadProperties(Properties config) {
	        dataSource = new BasicDataSource();
	        
	        dataSource.setDriverClassName(config.getProperty("db.driver"));
	        dataSource.setUrl(config.getProperty("db.url"));
	        dataSource.setUsername(config.getProperty("db.username"));
	        dataSource.setPassword(config.getProperty("db.password"));

	        dataSource.setInitialSize(Integer.parseInt(config.getProperty("db.initialSize")));
	        dataSource.setMaxTotal(Integer.parseInt(config.getProperty("db.maxTotal")));
	        dataSource.setMaxIdle(Integer.parseInt(config.getProperty("db.maxIdle")));
	        dataSource.setMaxWaitMillis(Long.parseLong(config.getProperty("db.maxWaitMillis")));

	        logger.info("successfully configured the database connection from properties file");
	    }

	    public static Connection getConnection() throws SQLException, ClassNotFoundException {
	        configureDataBase();
	        
	        Class.forName(dataSource.getDriverClassName());
	        return dataSource.getConnection();
	    }
	}
