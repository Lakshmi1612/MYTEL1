package com.ta.mytel.controller;

import com.ta.mytel.dao.PlanDAO;
import com.ta.mytel.model.Plan;
import com.ta.mytel.utility.Log4jUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

@WebServlet("/getPlanByName")
public class GetPlanByNameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLoggetplanbynameservlet();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            String planName = request.getParameter("planName");

            logger.info("Searching for plan with name: {}", planName);

            PlanDAO planDao = new PlanDAO();
            Plan plan = planDao.getPlanByName(planName);

            if (plan != null) {
                logger.info("Plan found: {}", plan.getPlanName());
                request.setAttribute("plan", plan);
                request.getRequestDispatcher("displayPlan.jsp").forward(request, response);
            } else {
                logger.warn("Plan not found: {}", planName);
                request.setAttribute("errorMessage", "Plan not found");
                request.getRequestDispatcher("searchPlan.jsp").forward(request, response);
            }
        } catch (Exception e) {
            logger.error("Error occurred while searching for plan. Error: {}", e.getMessage(), e);
            request.setAttribute("errorMessage", "An error occurred while searching for the plan: " + e.getMessage());
            request.getRequestDispatcher("searchPlan.jsp").forward(request, response);
        }
    }
}
