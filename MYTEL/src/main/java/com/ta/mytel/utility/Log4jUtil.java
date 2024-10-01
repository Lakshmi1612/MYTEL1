package com.ta.mytel.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import com.ta.mytel.controller.adminLogin;
import com.ta.mytel.controller.adminLogout;
import com.ta.mytel.controller.customerLogout;
import com.ta.mytel.controller.customerregistration;
import com.ta.mytel.dao.CustomerDAO;
import com.ta.mytel.dao.PlanDAO;
import com.ta.mytel.dao.ServiceSubscriptionDAO;
import com.ta.mytel.controller.AddCustomerServlet;
import com.ta.mytel.controller.AddPlanServlet;
import com.ta.mytel.controller.AddServiceSubscriptionServlet;
import com.ta.mytel.controller.CustomerByNameServlet;
import com.ta.mytel.controller.CustomerLoginServlet;
import com.ta.mytel.controller.GetAllPlansServlet;
import com.ta.mytel.controller.GetCustomerByEmailServlet;
import com.ta.mytel.controller.GetCustomersServlet;
import com.ta.mytel.controller.GetPlanByNameServlet;
import com.ta.mytel.controller.ServiceSubscriptionByCustomerServlet;
import com.ta.mytel.controller.ViewAllServiceSubscriptionsServlet;
import com.ta.mytel.controller.ViewPaymentReportServlet;
import com.ta.mytel.controller.ViewServiceReportServlet;


public class Log4jUtil {

	private Log4jUtil() {
	}

	static {
		System.setProperty("log4j.configurationFile", "D:\\MYTEL\\config\\log4j2.xml");
		Configurator.initialize(null, System.getProperty("log4j.configurationFile"));
	}

	public static Logger getLogadminLogin() {
		return LogManager.getLogger(adminLogin.class);
	}

	public static Logger getLogAddCustomerServlet() {
		return LogManager.getLogger(AddCustomerServlet.class);
	}

	public static Logger getLogAddPlanServlet() {
		return LogManager.getLogger(AddPlanServlet.class);
	}

	public static Logger getLogAddServiceSubscriptionServlet() {
		return LogManager.getLogger(AddServiceSubscriptionServlet.class);
	}

	public static Logger getLogadminLogout() {
		return LogManager.getLogger(adminLogout.class);
	}

	public static Logger getLogCustomerByNameServlet() {
		return LogManager.getLogger(CustomerByNameServlet.class);
	}

	public static Logger getLogCustomerLoginServlet() {
		return LogManager.getLogger(CustomerLoginServlet.class);
	}

	public static Logger getLogCustomerLogout() {
		return LogManager.getLogger(customerLogout.class);
	}

	public static Logger getLogcustomerregistration() {
		return LogManager.getLogger(customerregistration.class);
	}

	public static Logger getLogGetAllPlansServlet() {
		return LogManager.getLogger(GetAllPlansServlet.class);
	}

	public static Logger getLogGetCustomersServlet() {
		return LogManager.getLogger(GetCustomersServlet.class);
	}

	public static Logger getLoggetplanbynameservlet() {
		return LogManager.getLogger(GetPlanByNameServlet.class);
	}

	public static Logger getLogservicesubscriptionbycustomerservlet() {
		return LogManager.getLogger(ServiceSubscriptionByCustomerServlet.class);
	}

	public static Logger getLogviewallservicesubscriptionservlet() {
		return LogManager.getLogger(ViewAllServiceSubscriptionsServlet.class);
	}

	public static Logger getLogCustomerdao() {
		return LogManager.getLogger(CustomerDAO.class);
	}

	public static Logger getLogPlandao() {
		return LogManager.getLogger(PlanDAO.class);
	}

	public static Logger getLogservicesubscriptiondao() {
		return LogManager.getLogger(ServiceSubscriptionDAO.class);
	}

	public static Logger getLogCustomerbyemailservlet() {
		return LogManager.getLogger(GetCustomerByEmailServlet.class);
	}

	public static Logger getLogViewServiceReportServlet() {
		return LogManager.getLogger(ViewServiceReportServlet.class);
	}

	public static Logger getLogViewPaymentReportServlet() {
		return LogManager.getLogger(ViewPaymentReportServlet.class);
	}
}