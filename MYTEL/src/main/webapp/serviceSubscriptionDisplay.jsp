<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ta.mytel.model.ServiceSubscription" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Service Subscriptions</title>
   <style>
    body {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(45deg, #d2001a, #7462ff);
        color: #f5f5f5; 
    }

    .container {
        width: 90%;
        max-width: 1200px;
        margin: 20px auto;
        padding: 20px;
        background-color: #ffffff; 
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
        text-align: center;
    }

    h1 {
        color: #ff4500;
        margin-bottom: 20px;
        font-size: 24px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
        background-color: #ffffff; 
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    th, td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd; 
        color: #333;
    }

    th {
        background-color: #ff4500; 
        color: white; 
    }

    tr:hover {
        background-color: #ffcccc;
    }

    .error-message {
        color: #dc3545; 
        margin-top: 20px;
        font-size: 18px;
    }
</style>
   
</head>
<body>
    <div class="container">
        <h1>Service Subscriptions for Customer ID: <%= request.getAttribute("customerID") %></h1>
        <%
            List<ServiceSubscription> subscriptions = (List<ServiceSubscription>) request.getAttribute("subscriptions");
            if (subscriptions != null && !subscriptions.isEmpty()) {
        %>
            <table>
                <thead>
                    <tr>
                        <th>Service ID</th>
                        <th>Customer ID</th>
                        <th>Plan ID</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Status</th>
                        <th>Invoice ID</th>
                        <th>Invoice Date</th>
                        <th>Amount</th>
                        <th>Paid</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (ServiceSubscription subscription : subscriptions) {
                    %>
                        <tr>
                            <td><%= subscription.getServiceID() %></td>
                            <td><%= subscription.getCustomerID() %></td>
                            <td><%= subscription.getPlanID() %></td>
                            <td><%= subscription.getStartDate() %></td>
                            <td><%= subscription.getEndDate() %></td>
                            <td><%= subscription.getStatus() %></td>
                            <td><%= subscription.getInvoiceID() %></td>
                            <td><%= subscription.getInvoiceDate() %></td>
                            <td><%= subscription.getAmount() %></td>
                            <td><%= subscription.isPaid() ? "Yes" : "No" %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } else { %>
            <p class="error-message">No service subscriptions found for the provided customer ID.</p>
        <% } %>
    </div>
</body>
</html>
