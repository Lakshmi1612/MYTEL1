<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Login</title>
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

    .login-container {
        background-color: #ffffff; 
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 100%;
        max-width: 400px;
    }

    h1 {
        font-size: 24px;
        color: #d2001a; 
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
        color: #333; 
    }

    input[type="email"],
    input[type="text"] {
        width: calc(100% - 20px);
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ddd; 
        border-radius: 8px;
        font-size: 16px;
    }

    input[type="submit"] {
        background-color: #ff7043; 
        color: #ffffff;
        border: none;
        padding: 12px 20px;
        border-radius: 8px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s, transform 0.2s;
    }

    input[type="submit"]:hover {
        background-color: #e64a19;
        transform: translateY(-2px);
    }

    input[type="submit"]:active {
        background-color: #e64a19; 
        transform: translateY(0);
    }

    p {
        color: #dc3545; 
        margin-top: 20px;
        font-size: 14px;
    }
</style>
    
</head>
<body>
    <div class="login-container">
        <h1>Customer Login</h1>
        <form action="customerLogin" method="post">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>
            
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required><br>
            
            <input type="submit" value="Login">
        </form>
    </div>
     <div style="color:red;">
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
                out.println("<p>" + errorMessage + "</p>");
            }
        %>
    </div>
</body>
</html>
