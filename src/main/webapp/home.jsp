<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Password Locker</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-image: url("https://img.freepik.com/free-vector/halftone-background-with-circles_23-2148907689.jpg?size=626&ext=jpg&ga=GA1.2.1997535635.1676795773&semt=ais");
      background-size: cover;
      background-position: center;
    }
    
    h1 {
      text-align: center;
      margin-top: 50px;
      color: white;
    }
    
    .container {
      max-width: 600px;
      margin: 50px auto;
      text-align: center;
    }
    
    .container a {
      display: block;
      margin-bottom: 20px;
      padding: 10px 20px;
      font-size: 18px;
      background-color: #007bff;
      color: #fff;
      text-decoration: none;
      border-radius: 5px;
      transition: background-color 0.3s;
    }
    
    .container a:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
  <h1>Welcome to Password Locker</h1>
  <div class="container">
    <a href="userRegistration.jsp">New User Registration</a>
    <a href="userLogin.jsp">Existing User Login</a>
  </div>
</body>
</html>
