package com.ta.mytel.controller;

import com.ta.mytel.dao.CustomerDAO;
import com.ta.mytel.model.Customer;
import com.ta.mytel.utility.Log4jUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet("/getCustomerByEmail")
public class GetCustomerByEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLogCustomerbyemailservlet();
    private CustomerDAO customerDAO;

    @Override
    public void init() throws ServletException {
        customerDAO = new CustomerDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if customer is logged in
        HttpSession session = request.getSession(false); // 'false' prevents creating a new session if one doesn't exist
        Customer loggedInCustomer = (Customer) (session != null ? session.getAttribute("customer") : null);

        if (loggedInCustomer == null) {
            // No customer is logged in, redirect to login page
            logger.warn("Unauthorized access attempt to get customer by email");
            response.sendRedirect("index.jsp");
            return;
        }

        // If the customer is logged in, proceed with the request
        String email = request.getParameter("email");
        logger.info("Received request to get customer by email: " + email);

        try {
            // Ensure the email belongs to the logged-in customer
            if (!email.equals(loggedInCustomer.getEmail())) {
                logger.warn("Customer email mismatch. Logged-in customer: " + loggedInCustomer.getEmail() + ", Requested email: " + email);
                request.setAttribute("message", "You are not authorized to view details of another customer.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
                return;
            }

            Customer customer = customerDAO.getCustomerByEmail(email);

            if (customer != null) {
                logger.info("Customer found: " + customer.getName() + " (Email: " + email + ")");
                request.setAttribute("customer", customer);
                RequestDispatcher dispatcher = request.getRequestDispatcher("customerdetails1.jsp");
                dispatcher.forward(request, response);
            } else {
                logger.warn("Customer not found for email: " + email);
                request.setAttribute("message", "Customer not found!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("customerSearchByEmail.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            logger.error("Error retrieving customer by email: " + email, e);
            request.setAttribute("message", "An error occurred while processing your request.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("customerSearchByEmail.jsp");
            dispatcher.forward(request, response);
        }

        logger.info("Completed request for customer by email: " + email);
    }
}
