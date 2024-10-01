package com.ta.mytel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;

import com.ta.mytel.dao.PlanDAO;
import com.ta.mytel.model.Plan;
import com.ta.mytel.utility.Log4jUtil;

@WebServlet("/addPlan")
public class AddPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Log4jUtil.getLogAddPlanServlet();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            String planName = request.getParameter("planName");
            String priceParam = request.getParameter("price");
            String description = request.getParameter("description");
            if (planName == null || planName.trim().isEmpty() ||
                priceParam == null || priceParam.trim().isEmpty() ||
                description == null || description.trim().isEmpty()) {
                
                request.setAttribute("errorMessage", "All fields are required.");
                request.getRequestDispatcher("addPlan.jsp").forward(request, response);
                return;
            }

            int price;
            try {
                price = Integer.parseInt(priceParam);
            } catch (NumberFormatException e) {
                logger.error("Invalid price format. Error: {}", e.getMessage(), e);
                request.setAttribute("errorMessage", "Invalid price format. Please enter a valid number.");
                request.getRequestDispatcher("addPlan.jsp").forward(request, response);
                return;
            }
            PlanDAO planDao = new PlanDAO();
            if (planDao.planExists(planName)) {
                logger.warn("Plan with the name '{}' already exists.", planName);
                request.setAttribute("errorMessage", "Plan with the name '" + planName + "' already exists.");
                request.getRequestDispatcher("addPlan.jsp").forward(request, response);
                return;
            }

            logger.info("Received plan details: Plan Name: {}, Price: {}, Description: {}", planName, price, description);
            Plan plan = new Plan();
            plan.setPlanName(planName);
            plan.setPrice(price);
            plan.setDescription(description);

            PlanDAO planDao1 = new PlanDAO();
            planDao1.addPlan(plan);

            logger.info("Plan added successfully: Plan Name: {}", planName);
            response.sendRedirect("home.jsp");

        } catch (Exception e) {
            logger.error("Failed to add plan. Error: {}", e.getMessage(), e);
            request.setAttribute("errorMessage", "Error adding plan: " + e.getMessage());
            request.getRequestDispatcher("addPlan.jsp").forward(request, response);
        }
    }
}
