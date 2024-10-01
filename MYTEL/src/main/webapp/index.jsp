<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to MyTel</title>
   <style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin: 0;
        padding: 0;
        background: linear-gradient(45deg, #d2001a, #7462ff);
        color: #f0f0f0; 
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .container {
        max-width: 800px;
        margin: 40px auto;
        background: #ffffff;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.25); 
        text-align: center;
    }
    .container h1 {
        font-size: 32px;
        color: #5e22d0; 
        margin-bottom: 20px;
        font-weight: bold;
    }
    .container p {
        font-size: 20px;
        color: #ff6347; 
        margin-bottom: 20px;
    }
    .container a {
        display: inline-block;
        margin: 10px 15px;
        padding: 12px 25px;
        text-decoration: none;
        color: #ffffff;
        background-color: #c2185b; 
        border-radius: 12px;
        font-size: 19px;
        transition: background-color 0.3s, transform 0.2s;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); 
    }
    .container a:hover {
        background-color: #a50f44; 
        transform: translateY(-3px);
    }
    .container a:active {
        background-color: #8e0e3a;
        transform: translateY(0);
    }
</style>
   
    
</head>
<body>

<div class="container">
    <h1>WELCOME TO MYTEL TELECOMMUNICATION SYSTEM</h1>
    <p>This is the Login page of the MyTel application</p>
    
    <p>To navigate to different sections of the application, use the buttons below:</p>
    <a href="adminlogin.jsp">ADMIN LOGIN</a>
    <a href="addcustomer1.jsp">CUSTOMER REGISTRATION(After successfull registration,login to access application )</a>
    <a href="login.jsp">CUSTOMER LOGIN</a>
</div>

</body>
</html>
