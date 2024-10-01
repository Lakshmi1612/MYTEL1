package com.ta.mytel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;

import com.ta.mytel.utility.Log4jUtil;

@WebServlet("/customerlogout")
public class customerLogout extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLogCustomerLogout();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);  
        if (session != null) {
            logger.info("Customer with session ID: {} is logging out.", session.getId());
            session.invalidate();
            logger.info("Session invalidated successfully.");
        } else {
            logger.warn("No active session found during logout attempt.");
        }
        response.sendRedirect("index.jsp");
    }
}
