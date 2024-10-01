<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ta.mytel.model.ServiceSubscription" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Service Report</title>
  <style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(45deg, #d2001a, #7462ff);
        color: #f5f5f5; 
        margin: 0;
        padding: 20px;
    }

    .container {
        max-width: 1200px;
        margin: 0 auto;
        background-color: #ffffff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15); 
    }

    h1 {
        color: #ff4500; 
        margin-bottom: 20px;
        font-size: 28px;
        text-align: center;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
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
</style>
  
</head>
<body>
    <div class="container">
        <h1>Service Report</h1>
        <table>
            <thead>
                <tr>
                    <th>Service ID</th>
                    <th>Customer ID</th>
                    <th>Plan ID</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<ServiceSubscription> reports = (List<ServiceSubscription>) request.getAttribute("reports");
                    if (reports != null && !reports.isEmpty()) {
                        for (ServiceSubscription report : reports) {
                %>
                <tr>
                    <td><%= report.getServiceID() %></td>
                    <td><%= report.getCustomerID() %></td>
                    <td><%= report.getPlanID() %></td>
                    <td><%= report.getStartDate() %></td>
                    <td><%= report.getEndDate() %></td>
                    <td><%= report.getStatus() %></td>
                </tr>
                <% 
                        }
                    } else {
                %>
                <tr>
                    <td colspan="6" class="no-data">No service reports available.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
