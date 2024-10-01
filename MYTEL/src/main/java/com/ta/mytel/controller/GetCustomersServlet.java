package com.ta.mytel.controller;

import com.ta.mytel.dao.CustomerDAO;
import com.ta.mytel.model.Customer;
import com.ta.mytel.utility.Log4jUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.List;

@WebServlet("/getCustomers")
public class GetCustomersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLogGetCustomersServlet();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Received request to retrieve all customers.");

        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = null;
        try {
            customers = customerDAO.getAllCustomers();
            if (customers == null || customers.isEmpty()) {
                logger.warn("No customers found in the database.");
            } else {
                logger.info("Retrieved {} customers from the database.", customers.size());
            }
        } catch (Exception e) {
            logger.error("Error retrieving customers: {}", e.getMessage());
            request.setAttribute("errorMessage", "An error occurred while retrieving customers.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("customers.jsp").forward(request, response);
    }
}
