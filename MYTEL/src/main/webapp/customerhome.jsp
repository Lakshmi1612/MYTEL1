<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin: 0;
        padding: 0;
        background: linear-gradient(45deg, #d2001a, #7462ff); 
        color: #f5f5f5;
    }
    .container {
        max-width: 900px;
        margin: 40px auto;
        background: #f9f9ff; 
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2); 
    }
    .container h2 {
        font-size: 28px;
        color: #ff4500;
        border-bottom: 2px solid #ff4500; 
        padding-bottom: 10px;
        margin-bottom: 20px;
    }
    .nav-links {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }
    .nav-links li {
        margin: 15px 0;
        text-align: center;
    }
    .nav-links a {
        text-decoration: none;
        color: #d2001a;
        font-size: 18px;
        padding: 10px 20px;
        display: inline-block;
        background-color: #f5e8e8; 
        border-radius: 8px;
        transition: background-color 0.3s, color 0.3s;
    }
    .nav-links a:hover {
        background-color: #d2001a; 
        color: #ffffff; 
    }
    .logout {
        display: block;
        text-align: center;
        margin-top: 30px;
        font-size: 18px;
        font-weight: bold;
    }
    .logout a {
        text-decoration: none;
        color: #7462ff; 
        border: 2px solid #7462ff; 
        padding: 10px 20px;
        border-radius: 8px;
        transition: background-color 0.3s, color 0.3s;
    }
    .logout a:hover {
        background-color: #7462ff; 
        color: #ffffff; 
    }
    @media (max-width: 768px) {
        .container {
            width: 90%;
            padding: 15px;
        }
        .nav-links a {
            font-size: 16px;
            padding: 8px 16px;
        }
    }
</style>

</head>
<body>

<div class="container">
    <h2>Welcome to MyTel</h2>
    <ul class="nav-links">
        <li><a href="customerSearchByEmail.jsp">Search customer by email</a></li>
        <li><a href="searchPlan.jsp">Search Plan by Name</a></li>
        <li><a href="getAllPlans">View All Plans</a></li>
        <li><a href="serviceSubscriptionSearch.jsp">Search service subscription by customerID</a></li>
    </ul>
</div>

<nav>
    <a href="customerlogout" class="logout">Logout</a>
</nav>

</body>
</html>
