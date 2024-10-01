<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ta.mytel.model.ServiceSubscription" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Service Subscriptions</title>
    <style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin: 0;
        padding: 0;
        background: linear-gradient(45deg, #d2001a, #7462ff);
        color: #f5f5f5; 
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        max-width: 800px;
        width: 100%;
        background: #ffffff; 
        padding: 15px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.15);
    }

    h1 {
        text-align: center;
        color: #ff4500; 
        margin-bottom: 10px;
        font-size: 20px; 
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    table, th, td {
        border: 1px solid #ddd; 
    }

    th, td {
        padding: 8px; 
        text-align: left;
        font-size: 14px; 
        color: #333;
    }

    th {
        background-color: #ff4500; 
        color: white; 
    }

    tr:nth-child(even) {
        background-color: #f0f0f0; 
            }

    tr:nth-child(odd) {
        background-color: #ffffff; 
    }

    tr:hover {
        background-color: #ffcccc; 
    }

    .no-data {
        text-align: center;
        color: #dc3545; 
        font-size: 16px;
        margin-top: 20px;
    }

    @media (max-width: 768px) {
        .container {
            width: 95%;
            padding: 10px;
        }

        h1 {
            font-size: 18px; 
        }

        th, td {
            font-size: 12px; 
            padding: 6px;
        }
    }
</style>
    
    
</head>
<body>
    <div class="container">
        <h1>All Service Subscriptions</h1>
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
                    List<ServiceSubscription> subscriptions = (List<ServiceSubscription>) request.getAttribute("subscriptions");
                    if (subscriptions != null && !subscriptions.isEmpty()) {
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
                <% 
                        }
                    } else {
                %>
                <tr>
                    <td colspan="10" class="no-data">No service subscriptions available.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
