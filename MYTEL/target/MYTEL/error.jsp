<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(45deg, #d2001a, #7462ff);
        color: #f5f5f5; 
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        width: 100%;
        max-width: 500px;
        background-color: #ffffff; 
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
    }

    .container h2 {
        color: #d2001a; 
        margin-bottom: 20px;
        font-size: 24px;
    }

    .container p {
        color: #333; 
        font-size: 16px;
        margin-bottom: 20px;
    }

    .actions a {
        display: inline-block;
        padding: 10px 20px;
        background-color: #e74c3c; 
        color: white;
        text-decoration: none;
        border-radius: 5px;
        font-size: 16px;
        transition: background-color 0.3s;
    }

    .actions a:hover {
        background-color: #c0392b; 
    }
</style>
    
</head>
<body>

<div class="container">
    <h2>Error</h2>
    <p>Please check the input and try again.</p>
    <div class="actions">
        <a href="index.jsp">Back to front page</a>
    </div>
</div>

</body>
</html>
