<%@page import="com.rajat.PasswordLocker.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>User Menu</title>
  <style>
    body {
      background-color: #f2f2f2;
      font-family: Arial, sans-serif;
    }
    .container {
      width: 500px;
      margin: 0 auto;
      padding-top: 100px;
      text-align: center;
    }
    h1 {
      color: #333333;
      font-size: 28px;
      margin-bottom: 20px;
    }
    .message {
      color: #666666;
      font-size: 18px;
      margin-bottom: 30px;
    }
    .btn {
      display: inline-block;
      padding: 10px 20px;
      background-color: #4CAF50;
      color: white;
      text-decoration: none;
      border-radius: 5px;
      transition: background-color 0.3s;
    }
    .btn:hover {
      background-color: #45a049;
    }
    .logout-btn {
      margin-top: 30px;
    }
    .logout-btn a {
      color: #666666;
      font-size: 14px;
      text-decoration: none;
    }
    .logout-btn a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <div class="container">
   
    <% User user = (User) session.getAttribute("loggedUser");
    if (user != null) { %>
      <h1>Welcome to User Menu</h1>
    <% } else { %>
      <h1>Please Login to Use User Functions</h1>
      <a class="btn" href="userLogin.jsp">Back to Login</a>
    <% } %>
    <div class="logout-btn">
      <a href="userLogout">Logout</a>
    </div>
  </div>
</body>
</html>
