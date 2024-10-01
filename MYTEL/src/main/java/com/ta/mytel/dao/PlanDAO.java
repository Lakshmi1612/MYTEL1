package com.ta.mytel.dao;

import com.ta.mytel.model.Plan;
import com.ta.mytel.utility.DatabaseConnection;
import com.ta.mytel.utility.Log4jUtil;

import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanDAO {
    private static final Logger logger = Log4jUtil.getLogPlandao();
    
    public boolean planExists(String planName) throws SQLException, ClassNotFoundException {
        String query = "SELECT COUNT(*) FROM [dbo].[Plan] WHERE PlanName = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, planName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0; // If count > 0, plan exists
                }
            }
        } 
        return false;
    }
    public void addPlan(Plan plan) {
        String query = "INSERT INTO [dbo].[Plan] (PlanName, Price, Description) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, plan.getPlanName().trim());
            preparedStatement.setInt(2, plan.getPrice());
            preparedStatement.setString(3, plan.getDescription().trim());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                logger.info("Plan added successfully: {}", plan);
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error adding plan", e);
        }
    }

    public Plan getPlanByName(String planName) {
        Plan plan = null;
        String query = "SELECT * FROM [dbo].[Plan] WHERE PlanName = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, planName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    plan = new Plan();
                    plan.setPlanID(rs.getInt("PlanID"));
                    plan.setPlanName(rs.getString("PlanName"));
                    plan.setPrice(rs.getInt("Price"));
                    plan.setDescription(rs.getString("Description"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error retrieving plan by name", e);
        }
        return plan;
    }

 
    public List<Plan> retrieveAllPlans() {
        List<Plan> plans = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[Plan]";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Plan plan = new Plan();
                plan.setPlanID(rs.getInt("PlanID"));
                plan.setPlanName(rs.getString("PlanName"));
                plan.setPrice(rs.getInt("Price"));
                plan.setDescription(rs.getString("Description"));
                plans.add(plan);
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error retrieving all plans", e);
        }
        return plans;
    }
	
}
