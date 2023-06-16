package com.rajat.PasswordLocker.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.rajat.PasswordLocker.Service.UserService;
import com.rajat.PasswordLocker.Service.UserServiceImp;
import com.rajat.PasswordLocker.entity.User;
@WebServlet("/saveuser")
public class SaveUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
		User user=	new User();
		user.setName(req.getParameter("name"));
		user.setGender(req.getParameter("gender"));
		user.setEmail(req.getParameter("email"));
		user.setPhoneNumber(req.getParameter("phoneNumber"));
		user.setPassword(req.getParameter("password"));
	  user.setDob(Date.valueOf(req.getParameter("dob")));
	  UserServiceImp service =new UserServiceImp();
	  String message=service.saveUser(user);
	  HttpSession session=req.getSession();
	  session.setAttribute("saveMessage", message);
	  resp.sendRedirect("userLogin.jsp");
	  
	  ;
	  
}
}
