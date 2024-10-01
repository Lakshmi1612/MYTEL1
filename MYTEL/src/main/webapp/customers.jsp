<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer List</title>
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

    .container {
        max-width: 800px;
        width: 100%;
        background: #ffffff; 
        padding: 15px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.15); 
    }

    h1 {
        text-align: center;
        color: #ff4500; 
        margin-bottom: 10px;
        font-size: 20px; 
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 8px; 
        text-align: left;
        font-size: 14px; 
        color: #333; 
    }

    th {
        background-color: #ff4500; 
        color: #ffffff; 
        font-weight: normal;
    }

    tr:nth-child(even) {
        background-color: #f0f0f0;
    }

    tr:hover {
        background-color: #ffcccc;
    }

    @media (max-width: 768px) {
        .container {
            width: 95%;
            padding: 10px;
        }

        h1 {
            font-size: 18px; 
        }

        th, td {
            font-size: 12px; 
            padding: 6px;
        }
    }
</style>
  
</head>
<body>
    <div class="container">
        <h1>Customer List</h1>
        <table>
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>City</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.customerID}</td>
                        <td>${customer.name}</td>
                        <td>${customer.email}</td>
                        <td>${customer.phoneNumber}</td>
                        <td>${customer.city}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
