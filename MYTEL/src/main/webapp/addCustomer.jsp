<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Customer</title>
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
        max-width: 500px;
        width: 100%;
        background: #ffffff;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); 
        text-align: center;
    }

    h1 {
        font-size: 24px;
        color: #5e22d0; 
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
        color: #4a148c; 
    }

    input[type="text"],
    input[type="email"] {
        width: calc(100% - 22px);
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #b39ddb; 
        border-radius: 8px;
        font-size: 16px;
        background-color: #f3e5f5; 
    }

    input[type="submit"] {
        padding: 10px 20px;
        border: none;
        border-radius: 8px;
        background-color: #d2001a;
        color: #ffffff;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #a64d79; 
    }

    @media (max-width: 768px) {
        .form-container {
            width: 90%;
            padding: 20px;
        }

        h1 {
            font-size: 20px;
        }

        input[type="text"],
        input[type="email"] {
            font-size: 14px;
            padding: 8px;
        }

        input[type="submit"] {
            font-size: 14px;
            padding: 8px 16px;
        }
    }
</style>
    
</head>
<body>
    <div class="form-container">
        <h1>Add New Customer</h1>
        <form action="addCustomer" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required>
            
            <label for="city">City:</label>
            <input type="text" id="city" name="city" required>
            
            <input type="submit" value="Add Customer">
        </form>
        <% 
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
    <div style="color:red;">
        <strong>Error:</strong> <%= errorMessage %>
    </div>
<% 
    }
%>
        
    </div>
</body>
</html>
