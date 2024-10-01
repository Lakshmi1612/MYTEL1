package com.ta.mytel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;

import com.ta.mytel.dao.ServiceSubscriptionDAO;
import com.ta.mytel.model.ServiceSubscription;
import com.ta.mytel.utility.Log4jUtil;

@WebServlet("/addServiceSubscription")
public class AddServiceSubscriptionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLogAddServiceSubscriptionServlet();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
       
            int serviceID = Integer.parseInt(request.getParameter("serviceID"));
            int customerID = Integer.parseInt(request.getParameter("customerID"));
            int planID = Integer.parseInt(request.getParameter("planID"));
            java.sql.Date startDate = java.sql.Date.valueOf(request.getParameter("startDate"));
            java.sql.Date endDate = java.sql.Date.valueOf(request.getParameter("endDate"));
            String status = request.getParameter("status");
            int invoiceID = Integer.parseInt(request.getParameter("invoiceID"));
            java.sql.Date invoiceDate = java.sql.Date.valueOf(request.getParameter("invoiceDate"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            boolean paid = request.getParameter("paid") != null && request.getParameter("paid").equals("1");

            logger.info("Received service subscription details: ServiceID: {}, CustomerID: {}, PlanID: {}, StartDate: {}, EndDate: {}, Status: {}, InvoiceID: {}, InvoiceDate: {}, Amount: {}, Paid: {}", 
                        serviceID, customerID, planID, startDate, endDate, status, invoiceID, invoiceDate, amount, paid);

    
            ServiceSubscription subscription = new ServiceSubscription();
            subscription.setServiceID(serviceID);
            subscription.setCustomerID(customerID);
            subscription.setPlanID(planID);
            subscription.setStartDate(startDate);
            subscription.setEndDate(endDate);
            subscription.setStatus(status);
            subscription.setInvoiceID(invoiceID);
            subscription.setInvoiceDate(invoiceDate);
            subscription.setAmount(amount);
            subscription.setPaid(paid);

     
            ServiceSubscriptionDAO subscriptionDao = new ServiceSubscriptionDAO();
       
            if (subscriptionDao.getServiceById(serviceID) != null) {
                logger.error("Service with ID {} already exists.", serviceID);
                request.setAttribute("errorMessage", "A subscription for this service already exists.");
                request.getRequestDispatcher("addServiceSubscription.jsp").forward(request, response);
                return;
            }
            subscriptionDao.addServiceSubscription(subscription);

            logger.info("Service subscription added successfully for ServiceID: {}, CustomerID: {}", serviceID, customerID);
            response.sendRedirect("home.jsp");

        } catch (NumberFormatException e) {
      
            logger.error("Failed to parse form inputs for service subscription. Error: {}", e.getMessage(), e);
            request.setAttribute("errorMessage", "Invalid input format. Please enter valid numbers where required.");
            request.getRequestDispatcher("addServiceSubscription.jsp").forward(request, response);

        } catch (Exception e) {
        
            if (e.getMessage().contains("already exists")) {
                logger.error("Duplicate service subscription detected: ServiceID: {}, CustomerID: {}", request.getParameter("serviceID"), request.getParameter("customerID"));
                request.setAttribute("errorMessage", "A subscription for this service and customer already exists.");
            } else {
         
                logger.error("Unexpected error while adding service subscription. Error: {}", e.getMessage(), e);
                request.setAttribute("errorMessage", "An unexpected error occurred while adding the service subscription. Please try again.");
            }

     
            request.getRequestDispatcher("addServiceSubscription.jsp").forward(request, response);
        }
    }
}
