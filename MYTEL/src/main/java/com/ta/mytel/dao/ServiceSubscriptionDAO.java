package com.ta.mytel.dao;

import com.ta.mytel.model.ServiceSubscription;
import com.ta.mytel.utility.DatabaseConnection;
import com.ta.mytel.utility.Log4jUtil;

import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceSubscriptionDAO {
    private static final Logger logger = Log4jUtil.getLogservicesubscriptiondao();
    public ServiceSubscription getServiceById(int serviceID) {
        ServiceSubscription service = null;
        String query = "SELECT * FROM [dbo].[Service] WHERE ServiceID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, serviceID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    service = new ServiceSubscription();
                    service.setServiceID(rs.getInt("ServiceID"));
                   
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error retrieving service by ID", e);
        }
        return service;
    }
    public void addServiceSubscription(ServiceSubscription subscription) {
    	try {
			if (getServiceById(subscription.getServiceID()) != null) {
			    ServiceSubscription serviceSubscription;
				throw new SQLException("Service with ID " + subscription.getServiceID() + " already exists.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        String query = "INSERT INTO [dbo].[ServiceSubscription] (ServiceID, CustomerID, PlanID, StartDate, EndDate, Status, InvoiceID, InvoiceDate, Amount, Paid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, subscription.getServiceID());
            preparedStatement.setInt(2, subscription.getCustomerID());
            preparedStatement.setInt(3, subscription.getPlanID());
            preparedStatement.setDate(4, subscription.getStartDate());
            preparedStatement.setDate(5, subscription.getEndDate());
            preparedStatement.setString(6, subscription.getStatus());
            preparedStatement.setInt(7, subscription.getInvoiceID());
            preparedStatement.setDate(8, subscription.getInvoiceDate());
            preparedStatement.setInt(9, subscription.getAmount());
            preparedStatement.setBoolean(10, subscription.isPaid());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                logger.info("ServiceSubscription added successfully: {}", subscription);
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error adding ServiceSubscription", e);
        }
    }
    
    public List<ServiceSubscription> getAllServiceSubscriptions() {
        List<ServiceSubscription> subscriptions = new ArrayList<>();
        String query = "SELECT * FROM ServiceSubscription";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                ServiceSubscription subscription = new ServiceSubscription();
                subscription.setServiceID(resultSet.getInt("ServiceID"));
                subscription.setCustomerID(resultSet.getInt("CustomerID"));
                subscription.setPlanID(resultSet.getInt("PlanID"));
                subscription.setStartDate(resultSet.getDate("StartDate"));
                subscription.setEndDate(resultSet.getDate("EndDate"));
                subscription.setStatus(resultSet.getString("Status"));
                subscription.setInvoiceID(resultSet.getInt("InvoiceID"));
                subscription.setInvoiceDate(resultSet.getDate("InvoiceDate"));
                subscription.setAmount(resultSet.getInt("Amount"));
                subscription.setPaid(resultSet.getBoolean("Paid"));

                subscriptions.add(subscription);
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error retrieving service subscriptions", e);
        }
        return subscriptions;
    }
    
    public List<ServiceSubscription> getServiceSubscriptionsByCustomerID(int customerID) {
        List<ServiceSubscription> subscriptions = new ArrayList<>();
        String sql = "SELECT * FROM ServiceSubscription WHERE CustomerID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerID);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ServiceSubscription subscription = new ServiceSubscription(
                        rs.getInt("ServiceID"),
                        rs.getInt("CustomerID"),
                        rs.getInt("PlanID"),
                        rs.getDate("StartDate"),
                        rs.getDate("EndDate"),
                        rs.getString("Status"),
                        rs.getInt("InvoiceID"),
                        rs.getDate("InvoiceDate"),
                        rs.getInt("Amount"),
                        rs.getBoolean("Paid")
                    );
                    subscriptions.add(subscription);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error retrieving service subscriptions by customer ID", e);
        }
        return subscriptions;
    }
    
    public List<ServiceSubscription> getServiceReport() {
        List<ServiceSubscription> reports = new ArrayList<>();
        String query = "SELECT ServiceID, CustomerID, PlanID, StartDate, EndDate, Status FROM ServiceSubscription";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                ServiceSubscription report = new ServiceSubscription();
                report.setServiceID(resultSet.getInt("ServiceID"));
                report.setCustomerID(resultSet.getInt("CustomerID"));
                report.setPlanID(resultSet.getInt("PlanID"));
                report.setStartDate(resultSet.getDate("StartDate"));
                report.setEndDate(resultSet.getDate("EndDate"));
                report.setStatus(resultSet.getString("Status"));

                reports.add(report);
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error retrieving service report", e);
        }
        return reports;
    }
    public List<ServiceSubscription> getPaymentReport() {
        List<ServiceSubscription> paymentReports = new ArrayList<>();
        String query = "SELECT ServiceID, CustomerID, PlanID, InvoiceDate, Amount, Paid FROM ServiceSubscription";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                ServiceSubscription paymentReport = new ServiceSubscription();
                paymentReport.setServiceID(resultSet.getInt("ServiceID"));
                paymentReport.setCustomerID(resultSet.getInt("CustomerID"));
                paymentReport.setPlanID(resultSet.getInt("PlanID"));
                paymentReport.setInvoiceDate(resultSet.getDate("InvoiceDate"));
                paymentReport.setAmount(resultSet.getInt("Amount"));
                paymentReport.setPaid(resultSet.getBoolean("Paid"));

                paymentReports.add(paymentReport);
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error retrieving payment report", e);
        }
        return paymentReports;
    }


}
