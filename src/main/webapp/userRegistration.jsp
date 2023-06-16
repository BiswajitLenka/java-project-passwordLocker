<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Registration Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-image: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeH_6nQCd_J19wtnzWL3gXvAciVGUigpoBsA&usqp=CAU);
      background-size: cover;
      background-position: center;
    }
    
    h1 {
      text-align: center;
      margin-top: 50px;
      color: #fff;
    }
    
    .container {
      max-width: 400px;
      margin: 50px auto;
      text-align: center;
      background-color: rgba(255, 255, 255, 0.8);
      padding: 30px;
      border-radius: 5px;
    }
    
    .container input[type="text"],
    .container input[type="date"],
    .container input[type="tel"],
    .container input[type="email"],
    .container input[type="password"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border-radius: 3px;
      border: none;
      border-bottom: 2px solid #ddd;
      box-sizing: border-box;
      transition: border-color 0.3s;
      font-size: 16px;
    }
    
    .container input[type="text"]:focus,
    .container input[type="date"]:focus,
    .container input[type="tel"]:focus,
    .container input[type="email"]:focus,
    .container input[type="password"]:focus {
      outline: none;
      border-color: #007bff;
    }
    
    .container input[type="submit"] {
      display: block;
      width: 100%;
      padding: 10px;
      font-size: 18px;
      background-color: #007bff;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s;
    }
    
    .container input[type="submit"]:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
  <h1>Registration Page</h1>
  <div class="container">
    <form action="saveuser" method="post">
      <input type="text" id="name" name="name" placeholder="Name" required><br>
      <input type="text" id="gender" name="gender" placeholder="Gender" required><br>
      <input type="date" id="dob" name="dob" required><br>
      <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="Phone Number" required><br>
      <input type="email" id="email" name="email" placeholder="Email" required><br>
      <input type="password" id="password" name="password" placeholder="Password" required><br>
      <input type="submit" >
    </form>
  </div>
</body>
</html>
