<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Plan</title>
    <style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(45deg,#d2001a,#7462ff);
        color: #f5f5f5; 
    }

    .form-container {
        max-width: 600px;
        width: 100%;
        background: #ffffff;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15); 
        text-align: center;
    }

    h1 {
        font-size: 24px;
        color: #b71c1c; 
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
        color: #4a148c; 
    }

    input[type="text"], 
    input[type="number"], 
    textarea {
        width: calc(100% - 22px);
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #bbdefb; 
        border-radius: 8px;
        font-size: 16px;
        background-color: #f3e5f5; 
        color: #333;
    }

    textarea {
        resize: vertical; 
    }

    input[type="submit"] {
        padding: 10px 20px;
        border: none;
        border-radius: 8px;
        background-color: #d32f2f; 
        color: #ffffff;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #8e24aa; 
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
        input[type="number"], 
        textarea {
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
        <h1>Add New Plan</h1>
        <form action="addPlan" method="post">
            <label for="planName">Plan Name:</label>
            <input type="text" id="planName" name="planName" required>
            
            <label for="price">Price:</label>
            <input type="number" id="price" name="price" required>
            
            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="4" required></textarea>
            
            <input type="submit" value="Add Plan">
        </form>
        <c:if test="${not empty errorMessage}">
        <div style="color: red;">${errorMessage}</div>
    </c:if>
    </div>
</body>
</html>
