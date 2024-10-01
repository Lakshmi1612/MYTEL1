<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ta.mytel.model.Plan" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Service Plans</title>
  <style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(45deg, #d2001a, #7462ff);
        margin: 0;
        padding: 20px; 
        color: #f5f5f5; 
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
        font-size: 14px; 
        color: #333; 
    }

    th {
        background-color: #ff4500; 
        color: white;    }

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
            padding: 15px; 
        }

        h1 {
            font-size: 24px; 
        }

        th, td {
            font-size: 12px; 
            padding: 10px; 
        }
    }
</style>
  
   
</head>
<body>
    <div class="table-container">
        <h1>All Plans</h1>
        <table>
            <thead>
                <tr>
                    <th>Plan ID</th>
                    <th>Plan Name</th>
                    <th>Price</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Plan> plans = (List<Plan>) request.getAttribute("plans");
                    for (Plan plan : plans) {
                %>
                <tr>
                    <td><%= plan.getPlanID() %></td>
                    <td><%= plan.getPlanName() %></td>
                    <td>$<%= plan.getPrice() %></td>
                    <td><%= plan.getDescription() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
