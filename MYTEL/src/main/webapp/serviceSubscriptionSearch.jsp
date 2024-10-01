<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Service Subscriptions</title>
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

    .form-container {
        background-color: #ffffff; 
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 500px; 
        text-align: center;
    }

    h1 {
        color: #d2001a; 
        margin-bottom: 20px;
        font-size: 26px;
    }

    label {
        display: block;
        margin: 10px 0 5px;
        font-weight: bold;
        color: #333; 
    }

    input[type="text"] {
        width: calc(100% - 22px); 
        padding: 12px;
        margin-bottom: 15px;
        border: 1px solid #dcdcdc; 
        border-radius: 6px;
        font-size: 16px;
        color: #333; 
        background-color: #f9f9f9; 
    }

    input[type="submit"] {
        padding: 12px 25px;
        border: none;
        border-radius: 6px;
        background-color: #ff7043; 
        color: white;
        font-size: 18px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #e65c38; 
    }

    .error-message {
        color: #dc3545; 
        margin-top: 15px;
        font-size: 16px;
    }
</style>
   
    
    </head>
<body>
    <div class="form-container">
        <h1>Search Service Subscriptions by Customer ID</h1>
        <form action="getServiceSubscriptionsByCustomer" method="post">
            <label for="customerID">Customer ID:</label>
            <input type="text" id="customerID" name="customerID" required>
            <input type="submit" value="Search">
        </form>
        <p class="error-message">${errorMessage}</p>
    </div>
</body>
</html>
