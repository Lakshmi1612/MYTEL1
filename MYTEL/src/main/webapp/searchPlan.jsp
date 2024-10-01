<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Plan by Name</title>
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

    .search-container {
        background-color: #ffffff; 
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 100%;
        max-width: 400px;
    }

    h1 {
        color: #d2001a; 
        margin-bottom: 20px;
        font-size: 24px;
    }

    label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
        color: #333; 
    }

    input[type="text"] {
        width: calc(100% - 22px);
        padding: 12px;
        margin-bottom: 20px;
        border: 1px solid #ddd; 
        border-radius: 8px;
        font-size: 16px;
        box-sizing: border-box;
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
        width: 100%;
    }

    input[type="submit"]:hover {
        background-color: #e64a19; 
        transform: translateY(-2px);
    }

    input[type="submit"]:active {
        background-color: #e64a19;
        transform: translateY(0);
    }

    @media (max-width: 600px) {
        .search-container {
            width: 90%;
            padding: 20px;
        }

        input[type="submit"] {
            font-size: 14px;
        }
    }
</style>
    
</head>
<body>
    <div class="search-container">
        <h1>Search Plan by Name</h1>
        <form action="getPlanByName" method="post">
            <label for="planName">Plan Name:</label>
            <input type="text" id="planName" name="planName" required>
            <input type="submit" value="Search">
        </form>
    </div>
    <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
<% if (errorMessage != null) { %>
    <div class="error-message">
        <p><%= errorMessage %></p>
    </div>
<% } %>
    
</body>
</html>
