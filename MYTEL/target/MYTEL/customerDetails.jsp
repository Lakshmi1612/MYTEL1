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
        background: linear-gradient(45deg, #d2001a, #7462ff);
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
        color: #ffffff;
        margin-bottom: 20px;
        font-size: 28px;
    }

    p {
        margin: 10px 0;
        font-size: 16px;
        line-height: 1.5;
        color: #333; 
    }

    strong {
        color: #d2001a; 
        font-weight: bold;
    }

    @media (max-width: 768px) {
        .details-container {
            width: 90%;
            padding: 20px;
        }

        h1 {
            font-size: 24px;
        }

        p {
            font-size: 14px;
        }
    }
</style>
   
</head>
<body>
    <div class="details-container">
        <h1>Customer Details</h1>
        <p><strong>ID:</strong> ${customer.customerID}</p>
        <p><strong>Name:</strong> ${customer.name}</p>
        <p><strong>Email:</strong> ${customer.email}</p>
        <p><strong>Phone Number:</strong> ${customer.phoneNumber}</p>
        <p><strong>City:</strong> ${customer.city}</p>
    </div>
</body>
</html>
