<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Service Subscription</title>
   <style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        font-family: Arial, sans-serif;
        background: linear-gradient(45deg,#d2001a,#7462ff);
        color: #f5f5f5; 
    }

    .form-container {
        background-color: #ffffff;
        padding: 8px;
        border: 1px solid #dcdcdc;
        border-radius: 4px;
        text-align: center;
        width: 100%;
        max-width: 350px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
        font-size: 1.2em;
        margin-bottom: 8px;
        color: #d2001a; 
    }

    label {
        display: block;
        font-size: 0.9em;
        margin-bottom: 4px;
        font-weight: normal;
        color: #7462ff;
    }

    input[type="text"], input[type="date"], input[type="number"], input[type="checkbox"] {
        width: calc(100% - 18px);
        padding: 6px;
        margin-bottom: 8px;
        border-radius: 3px;
        border: 1px solid #bbb; 
        font-size: 0.9em;
        background-color: #f3e5f5; 
        color: #333;
    }

    input[type="submit"] {
        padding: 6px 12px;
        background-color: #d32f2f; 
        color: #ffffff;
        border: none;
        border-radius: 3px;
        cursor: pointer;
        font-size: 0.9em;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #8e24aa; 
    }

    .error-message {
        color: #ff1744; 
        font-size: 0.9em;
        margin-top: 8px;
    }
</style>
   
</head>
<body>
    <div class="form-container">
        <h1>Add Service Subscription</h1>
        <% 
            String errorMessage = (String) request.getAttribute("errorMessage"); 
            if (errorMessage != null) { 
        %>
            <div class="error-message">
                <p><%= errorMessage %></p>
            </div>
        <% 
            } 
        %>
        <form action="addServiceSubscription" method="post">
            <label for="serviceID">Service ID:</label>
            <input type="number" id="serviceID" name="serviceID" required>

            <label for="customerID">Customer ID:</label>
            <input type="number" id="customerID" name="customerID" required>

            <label for="planID">Plan ID:</label>
            <input type="number" id="planID" name="planID" required>

            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" required>

            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" required>

            <label for="status">Status:</label>
            <input type="text" id="status" name="status" required>

            <label for="invoiceID">Invoice ID:</label>
            <input type="number" id="invoiceID" name="invoiceID" required>

            <label for="invoiceDate">Invoice Date:</label>
            <input type="date" id="invoiceDate" name="invoiceDate" required>

            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" required>

            <label for="paid">Paid:</label>
            <input type="checkbox" id="paid" name="paid" value="1">

            <input type="hidden" name="paid" value="0"> 

            <input type="submit" value="Add">
        </form>     
    </div>
</body>
</html>
