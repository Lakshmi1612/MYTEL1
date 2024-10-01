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

@WebServlet("/customerLogin")
public class CustomerLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLogCustomerLoginServlet();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");

        logger.info("Attempting customer login with email: {} and phone number: {}", email, phoneNumber);

        CustomerDAO customerDao = new CustomerDAO();
        Customer customer = customerDao.getCustomerByEmailAndPhone(email, phoneNumber);

        if (customer != null) {
            logger.info("Customer login successful for email: {}", email);
            request.getSession().setAttribute("customer", customer);
            response.sendRedirect("customerhome.jsp");
        } else {
            logger.warn("Customer login failed for email: {}", email);
            request.setAttribute("errorMessage", "Invalid login credentials");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
