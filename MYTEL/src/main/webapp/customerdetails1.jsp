<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Details</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin: 0;
        padding: 0;
        background: linear-gradient(45deg,#d2001a,#7462ff);
        color: #f5f5f5; 
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .details-container {
        max-width: 600px;
        width: 100%;
        background: #f9f9ff; 
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2); 
    }

    h1 {
        text-align: center;
        color: #ff4500; 
        margin-bottom: 20px;
        font-size: 28px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    table th, table td {
        padding: 12px 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    table th {
        background-color: #d2001a; 
        color: white;
    }

    table td {
        color: #4a4a4a; 
    }

    .btn-back {
        display: block;
        width: 100%;
        padding: 10px;
        background-color: #7462ff; 
        color: white;
        text-align: center;
        border: none;
        border-radius: 5px;
        text-decoration: none;
        font-size: 16px;
        cursor: pointer;
    }

    .btn-back:hover {
        background-color: #5b4bb7; 
    }

    @media (max-width: 768px) {
        .details-container {
            width: 90%;
            padding: 20px;
        }

        h1 {
            font-size: 24px;
        }

        table th, table td {
            font-size: 14px;
        }

        .btn-back {
            font-size: 14px;
        }
    }
</style>
</head>
<body>
    <div class="details-container">
        <h1>Customer Details</h1>
        <table>
            <tr>
                <th>Customer ID</th>
                <td>${customer.customerID}</td>
            </tr>
            <tr>
                <th>Name</th>
                <td>${customer.name}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${customer.email}</td>
            </tr>
            <tr>
                <th>Phone Number</th>
                <td>${customer.phoneNumber}</td>
            </tr>
            <tr>
                <th>City</th>
                <td>${customer.city}</td>
            </tr>
        </table>
        <a href="customerSearchByEmail.jsp" class="btn-back">Back to Search</a>
    </div>
</body>
</html>
