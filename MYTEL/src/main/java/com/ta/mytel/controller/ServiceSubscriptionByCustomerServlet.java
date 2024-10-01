package com.ta.mytel.controller;

import com.ta.mytel.dao.ServiceSubscriptionDAO;
import com.ta.mytel.model.Customer;
import com.ta.mytel.model.ServiceSubscription;
import com.ta.mytel.utility.Log4jUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

@WebServlet("/getServiceSubscriptionsByCustomer")
public class ServiceSubscriptionByCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLogservicesubscriptionbycustomerservlet();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer loggedInCustomer = (Customer) session.getAttribute("customer");

        if (loggedInCustomer == null) {
            logger.warn("No customer is logged in.");
            request.setAttribute("errorMessage", "You must be logged in to view service subscriptions.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        String customerIDParam = request.getParameter("customerID");
        int loggedInCustomerID = loggedInCustomer.getCustomerID(); // Get customer ID from the session

        logger.info("Received request to get service subscriptions for customer ID: {}", customerIDParam);

        if (customerIDParam != null && !customerIDParam.isEmpty()) {
            try {
                int enteredCustomerID = Integer.parseInt(customerIDParam);

                // Check if the entered customer ID matches the logged-in customer ID
                if (enteredCustomerID != loggedInCustomerID) {
                    logger.warn("Unauthorized attempt to access subscriptions for customer ID: {}", enteredCustomerID);
                    request.setAttribute("errorMessage", "You can only view your own service subscriptions.");
                    request.getRequestDispatcher("serviceSubscriptionSearch.jsp").forward(request, response);
                    return;
                }

                logger.info("Customer ID matches logged-in customer. Proceeding to retrieve subscriptions.");

                ServiceSubscriptionDAO serviceSubscriptionDao = new ServiceSubscriptionDAO();
                List<ServiceSubscription> subscriptions = serviceSubscriptionDao.getServiceSubscriptionsByCustomerID(enteredCustomerID);

                if (subscriptions != null && !subscriptions.isEmpty()) {
                    logger.info("Found {} service subscriptions for customer ID: {}", subscriptions.size(), enteredCustomerID);
                    request.setAttribute("customerID", enteredCustomerID);
                    request.setAttribute("subscriptions", subscriptions);
                    request.getRequestDispatcher("serviceSubscriptionDisplay.jsp").forward(request, response);
                } else {
                    logger.warn("No service subscriptions found for customer ID: {}", enteredCustomerID);
                    request.setAttribute("errorMessage", "No service subscriptions found for the provided customer ID.");
                    request.getRequestDispatcher("serviceSubscriptionSearch.jsp").forward(request, response);
                }

            } catch (NumberFormatException e) {
                logger.error("Invalid customer ID format: {}", customerIDParam, e);
                request.setAttribute("errorMessage", "Invalid customer ID format.");
                request.getRequestDispatcher("serviceSubscriptionSearch.jsp").forward(request, response);
            }
        } else {
            logger.warn("Customer ID is required but not provided.");
            request.setAttribute("errorMessage", "Customer ID is required.");
            request.getRequestDispatcher("serviceSubscriptionSearch.jsp").forward(request, response);
        }
    }
}
