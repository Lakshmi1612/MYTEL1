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

@WebServlet("/adminlogout")
public class adminLogout extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLogadminLogout();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            logger.info("Admin is logging out", session.getAttribute("adminUsername")); 
            session.invalidate();
            logger.info("Admin logged out successfully.");
        } else {
            logger.warn("No active session found for logout.");
        }

        response.sendRedirect("adminlogin.jsp");
    }
}
