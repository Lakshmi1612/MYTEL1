package com.ta.mytel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;

import com.ta.mytel.dao.CustomerDAO;
import com.ta.mytel.model.Customer;
import com.ta.mytel.utility.Log4jUtil;

@WebServlet("/addcustomer")
public class customerregistration extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLogcustomerregistration();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String city = request.getParameter("city");

        logger.info("Attempting to register customer: Name={}, Email={}, PhoneNumber={}, City={}", name, email, phoneNumber, city);

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setCity(city);
        try {
            CustomerDAO customerDao = new CustomerDAO();
            customerDao.addCustomer(customer);
            logger.info("Customer added successfully with email: {}", email);
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            if (e.getMessage().contains("already exists")) {
            
                logger.error("Duplicate email detected: {}", email);
                request.setAttribute("errorMessage", "Customer with email " + email + " already exists.");
            } else {
           
                logger.error("Failed to add customer with email: {}. Error: {}", email, e.getMessage(), e);
                request.setAttribute("errorMessage", "Error adding customer: " + e.getMessage());
            }

   
            request.getRequestDispatcher("addcustomer1.jsp").forward(request, response);
        }
    }
}

        
