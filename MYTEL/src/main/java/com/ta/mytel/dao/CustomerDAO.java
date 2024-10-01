package com.ta.mytel.dao;

import com.ta.mytel.model.Customer;
import com.ta.mytel.utility.DatabaseConnection;
import com.ta.mytel.utility.Log4jUtil;

import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static final Logger logger = Log4jUtil.getLogCustomerdao();

    public void addCustomer(Customer customer) throws SQLException {
    	if (getCustomerByEmail(customer.getEmail()) != null) {
            throw new SQLException("Customer with email " + customer.getEmail() + " already exists.");
        }
        String query = "INSERT INTO [dbo].[Customer] (Name, Email, PhoneNumber, City) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, customer.getName().trim());
            preparedStatement.setString(2, customer.getEmail().trim());
            preparedStatement.setString(3, customer.getPhoneNumber().trim());
            preparedStatement.setString(4, customer.getCity().trim());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                logger.info("Customer added successfully: {}", customer);
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error adding customer", e);
        }
    }
    
   
   
    public Customer getCustomerByEmailAndPhone(String email, String phoneNumber) {
        Customer customer = null;
        String query = "SELECT * FROM [dbo].[Customer] WHERE Email = ? AND PhoneNumber = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, email);
            pstmt.setString(2, phoneNumber);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer();
                    customer.setCustomerID(rs.getInt("CustomerID"));
                    customer.setName(rs.getString("Name"));
                    customer.setEmail(rs.getString("Email"));
                    customer.setPhoneNumber(rs.getString("PhoneNumber"));
                    customer.setCity(rs.getString("City"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error retrieving customer by email and phonenumber", e);
        }
        return customer;
    }
    
    public Customer getCustomerByName(String name) {
        Customer customer = null;
        String query = "SELECT * FROM [dbo].[Customer] WHERE Name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer();
                    customer.setCustomerID(rs.getInt("CustomerID"));
                    customer.setName(rs.getString("Name"));
                    customer.setEmail(rs.getString("Email"));
                    customer.setPhoneNumber(rs.getString("PhoneNumber"));
                    customer.setCity(rs.getString("City"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error retrieving customer by name", e);
        }
        return customer;
    }
   
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[Customer]";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rs.getInt("CustomerID"));
                customer.setName(rs.getString("Name"));
                customer.setEmail(rs.getString("Email"));
                customer.setPhoneNumber(rs.getString("PhoneNumber"));
                customer.setCity(rs.getString("City"));

                customers.add(customer);
            }
            logger.info("Retrieved {} customers", customers.size());
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error retrieving customers", e);
        }

        return customers;
    }
    
    public Customer getCustomerByEmail(String email) {
        Customer customer = null;
        String query = "SELECT * FROM [dbo].[Customer] WHERE Email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer();
                    customer.setCustomerID(rs.getInt("CustomerID"));
                    customer.setName(rs.getString("Name"));
                    customer.setEmail(rs.getString("Email"));
                    customer.setPhoneNumber(rs.getString("PhoneNumber"));
                    customer.setCity(rs.getString("City"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error retrieving customer by email", e);
        }
        return customer;
    }

}
