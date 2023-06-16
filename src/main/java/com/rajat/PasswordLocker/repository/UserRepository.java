package com.rajat.PasswordLocker.repository;

import com.rajat.PasswordLocker.entity.User;

public interface UserRepository {
 
	String saveUser(User user);
	
	User updateUser(User user);
	
	User  Userlogin(String email,String password);
	User deleteUser(int id);
	
}
