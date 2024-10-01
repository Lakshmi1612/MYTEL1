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

@WebServlet("/getCustomerByName")
public class CustomerByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Log4jUtil.getLogCustomerByNameServlet();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");

            logger.info("Searching for customer with name: {}", name);

            CustomerDAO customerDao = new CustomerDAO();
            Customer customer = customerDao.getCustomerByName(name);

            if (customer != null) {
                logger.info("Customer found: {}", customer.getName());
                request.setAttribute("customer", customer);
                request.getRequestDispatcher("customerDetails.jsp").forward(request, response);
            } else {
                logger.warn("Customer not found: {}", name);
                request.setAttribute("errorMessage", "Customer not found");
                request.getRequestDispatcher("customerSearch.jsp").forward(request, response);
            }
        } catch (Exception e) {
            logger.error("Error occurred while searching for customer. Error: {}", e.getMessage(), e);
            request.setAttribute("errorMessage", "An error occurred while searching for the customer.");
            request.getRequestDispatcher("customerSearch.jsp").forward(request, response);
        }
    }
}
