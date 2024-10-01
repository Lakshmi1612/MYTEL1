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

@WebServlet("/adminlogin")
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Log4jUtil.getLogadminLogin();
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        logger.info("Admin login attempt with email: {}", email);
        if ("admin@gmail.com".equals(email) && "password".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);  
            session.setMaxInactiveInterval(30 * 60);  

            logger.info("Admin login successful for email: {}", email);
            response.sendRedirect("home.jsp");
        } else {
            logger.warn("Admin login failed for email: {}", email);
            request.setAttribute("errorMessage", "Invalid email or password");
            request.getRequestDispatcher("adminlogin.jsp").include(request, response);
        }
    }

   }
