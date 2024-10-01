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

@WebServlet("/viewPaymentReport")
public class ViewPaymentReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLogViewPaymentReportServlet();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Received request to view payment report.");

        ServiceSubscriptionDAO subscriptionDao = new ServiceSubscriptionDAO();
        List<ServiceSubscription> paymentReports = subscriptionDao.getPaymentReport();

        if (paymentReports != null && !paymentReports.isEmpty()) {
            logger.info("Retrieved {} payment reports from the database.", paymentReports.size());
            request.setAttribute("paymentReports", paymentReports);
            request.getRequestDispatcher("viewPaymentReport.jsp").forward(request, response);
        } else {
            logger.warn("No payment reports found.");
            request.setAttribute("errorMessage", "No payment reports available.");
            request.getRequestDispatcher("viewPaymentReport.jsp").forward(request, response);
        }
    }
}
