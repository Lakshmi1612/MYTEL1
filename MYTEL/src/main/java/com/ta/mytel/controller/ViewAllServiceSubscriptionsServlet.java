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

@WebServlet("/viewAllServiceSubscriptions")
public class ViewAllServiceSubscriptionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLogviewallservicesubscriptionservlet();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Received request to view all service subscriptions.");

        ServiceSubscriptionDAO subscriptionDao = new ServiceSubscriptionDAO();
        List<ServiceSubscription> subscriptions = subscriptionDao.getAllServiceSubscriptions();

        if (subscriptions != null && !subscriptions.isEmpty()) {
            logger.info("Retrieved {} service subscriptions from the database.", subscriptions.size());
            request.setAttribute("subscriptions", subscriptions);
            request.getRequestDispatcher("viewAllServiceSubscriptions.jsp").forward(request, response);
        } else {
            logger.warn("No service subscriptions found.");
            request.setAttribute("errorMessage", "No service subscriptions available.");
            request.getRequestDispatcher("viewAllServiceSubscriptions.jsp").forward(request, response);
        }
    }
}
