<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>User Login</title>
  <style>
    body {
      background-image: url('https://images.unsplash.com/photo-1504660069764-2b37e279874a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzJ8fGxvZ2lufGVufDB8fDB8fHww&auto=format&fit=crop&w=600&q=60');
      background-size: cover;
      font-family: Arial, sans-serif;
    }
    .container {
      width: 400px;
      margin: 0 auto;
      padding-top: 100px;
    }
    h2 {
      color: white;
      text-align: center;
    }
    h1 {
      color: white;
      text-align: center;
    }
    form {
      background-color: rgba(255, 255, 255, 0.7);
      padding: 20px;
      border-radius: 10px;
    }
    input[type="email"],
    input[type="password"],
    input[type="submit"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border-radius: 5px;
      border: none;
      outline: none;
    }
    input[type="submit"] {
      background-color: #4CAF50;
      color: white;
      cursor: pointer;
    }
    a {
      color: white;
      text-decoration: none;
      display: block;
      text-align: center;
      margin-top: 10px;
    }
    a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2><%=(String)session.getAttribute("savemessage") %></h2>
    <h1>User Login</h1>
    <form action="userLogin" method="post">
      <input type="email" name="email" placeholder="Email" required><br><br>
      <input type="password" name="password" placeholder="Password" required><br><br>
      <input type="submit" value="Login">
    </form>
    <a href="home.jsp">Back to Home Page</a>
  </div>
</body>
</html>
