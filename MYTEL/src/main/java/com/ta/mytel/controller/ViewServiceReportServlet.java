package com.ta.mytel.controller;

import com.ta.mytel.dao.ServiceSubscriptionDAO;
import com.ta.mytel.model.ServiceSubscription;
import com.ta.mytel.utility.Log4jUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewServiceReport")
public class ViewServiceReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLogViewServiceReportServlet();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Received request to view service report.");

        ServiceSubscriptionDAO subscriptionDao = new ServiceSubscriptionDAO();
        List<ServiceSubscription> reports = subscriptionDao.getServiceReport();

        if (reports != null && !reports.isEmpty()) {
            logger.info("Retrieved {} service reports from the database.", reports.size());
            request.setAttribute("reports", reports);
            request.getRequestDispatcher("viewServiceReport.jsp").forward(request, response);
        } else {
            logger.warn("No service reports found.");
            request.setAttribute("errorMessage", "No service reports available.");
            request.getRequestDispatcher("viewServiceReport.jsp").forward(request, response);
        }
    }
}
