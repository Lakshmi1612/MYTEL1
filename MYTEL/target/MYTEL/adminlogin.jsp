<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(45deg,#d2001a,#7462ff);
        color: #f5f5f5; 
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    h1 {
        color:  #ff6347;
        margin-bottom: 20px;
    }

    .login-container {
        background-color: #f9f9ff; 
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2); 
        max-width: 400px;
        width: 100%;
        text-align: left;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    table th, table td {
        padding: 12px;
        border-bottom: 1px solid #e0e0e0;
    }

    table th {
        text-align: left;
        color: #5c5c5c; 
    }

    table td input[type="text"],
    table td input[type="password"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #dcdcdc;
        border-radius: 5px;
        font-size: 16px;
        background-color: #ffffff; 
        color: #333;
    }

    button {
        padding: 12px 20px;
        background-color: #d2001a; 
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s, transform 0.2s;
        width: 100%;
    }

    button:hover {
        background-color: #a64d79; 
        transform: translateY(-2px);
    }

    button:active {
        background-color: #8b3a5c; 
        transform: translateY(0);
    }

    @media (max-width: 600px) {
        .login-container {
            width: 90%;
            padding: 20px;
        }

        button {
            font-size: 14px;
        }
    }
</style>
    
</head>
<body>
    <div class="login-container">
        <h1>Admin Login</h1>
        <form action="adminlogin" method="post">
            <table>
                <tr>
                    <th>Email:</th>
                    <td><input type="text" name="email" required></td>
                </tr>
                <tr>
                    <th>Password:</th>
                    <td><input type="password" name="password" required></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">Login</button>
                    </td>
                </tr>
            </table>
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
