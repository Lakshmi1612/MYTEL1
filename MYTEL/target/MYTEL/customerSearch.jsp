<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Customer</title>
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

    .form-container {
        max-width: 500px;
        width: 100%;
        background: #ffffff; 
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15); 
        text-align: center;
    }

    h1 {
        font-size: 28px;
        color: #ff4500; 
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin: 10px 0 5px;
        font-weight: bold;
        color: #333; 
    }

    input[type="text"] {
        width: calc(100% - 22px);
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc; 
        border-radius: 8px;
        font-size: 16px;
        transition: border-color 0.3s;
    }

    input[type="text"]:focus {
        border-color: #ff4500; 
        outline: none;
    }

    input[type="submit"] {
        padding: 10px 20px;
        border: none;
        border-radius: 8px;
        background-color: #ff4500; 
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #e03e00; 
    }

    .error-message {
        color: #dc3545; 
        margin-top: 15px;
        font-size: 14px;
    }

    @media (max-width: 768px) {
        .form-container {
            width: 90%;
            padding: 20px;
        }

        h1 {
            font-size: 24px;
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
        <h1>Search Customer by Name</h1>
        <form action="getCustomerByName" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <input type="submit" value="Search">
        </form>
        <p class="error-message">${errorMessage}</p>
    </div>
</body>
</html>
