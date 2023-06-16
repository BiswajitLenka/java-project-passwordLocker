package com.rajat.PasswordLocker.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rajat.PasswordLocker.Service.UserService;
import com.rajat.PasswordLocker.Service.UserServiceImp;
import com.rajat.PasswordLocker.entity.User;
@WebServlet("/userLogin")
public class UserLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		UserServiceImp service=new UserServiceImp();
		User user = service.userLogin(email, password);
		HttpSession session=req.getSession();
		session.setAttribute("loggedUser", user);
		resp.sendRedirect("userMenu.jsp");
	}
}
