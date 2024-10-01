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
import java.util.List;

@WebServlet("/getAllPlans")
public class GetAllPlansServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLogGetAllPlansServlet();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        logger.info("Received request to retrieve all plans.");

        PlanDAO planDao = new PlanDAO();
        List<Plan> plans = null;
        try {
            plans = planDao.retrieveAllPlans();
            if (plans == null || plans.isEmpty()) {
                logger.warn("No plans found in the database.");
            } else {
                logger.info("Retrieved {} plans from the database.", plans.size());
            }
        } catch (Exception e) {
            logger.error("Error retrieving plans: {}", e.getMessage());
            request.setAttribute("errorMessage", "An error occurred while retrieving the plans.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        request.setAttribute("plans", plans);
        request.getRequestDispatcher("displayAllPlans.jsp").forward(request, response);
    }
}
