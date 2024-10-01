<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ta.mytel.model.Plan" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Plan Details</title>
    <style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(45deg, #d2001a, #7462ff);
        color: #f5f5f5; 
    }

    .details-container {
        background-color: #ffffff; 
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 100%;
        max-width: 600px;
    }

    h1 {
        margin-bottom: 20px;
        font-size: 24px;
        color: #d2001a; 
    }

    p {
        font-size: 18px;
        margin: 10px 0;
        color: #333; 
    }

    strong {
        font-weight: 600;
        color: #d2001a; 
    }

    .error-message {
        color: #e74c3c; 
        font-size: 18px;
    }
</style>
    
    </head>
<body>
    <div class="details-container">
        <h1>Plan Details</h1>
        <%
            Plan plan = (Plan) request.getAttribute("plan");
            if (plan != null) {
        %>
            <p><strong>Plan ID:</strong> <%= plan.getPlanID() %></p>
            <p><strong>Plan Name:</strong> <%= plan.getPlanName() %></p>
            <p><strong>Price:</strong> $<%= plan.getPrice() %></p>
            <p><strong>Description:</strong> <%= plan.getDescription() %></p>
        <% } else { %>
            <p class="error-message">No plan details found.</p>
        <% } %>
    </div>
</body>
</html>
