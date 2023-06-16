package com.rajat.PasswordLocker.Service;

import com.rajat.PasswordLocker.entity.User;
import com.rajat.PasswordLocker.repository.UserRepository;
import com.rajat.PasswordLocker.repository.UserRepositoryImp;
import com.rajat.PasswordLocker.util.AES;
import com.rajat.PasswordLocker.util.AppConstants;
import com.rajat.PasswordLocker.util.ValidUser;

public class UserServiceImp implements UserService{
	  
		private UserRepository repository;
		{
			repository=new UserRepositoryImp();
		}
	@Override
	public String saveUser(User user) {

		user.setPhoneNumber(AES.encrypt(user.getPhoneNumber(), AppConstants.SECRET_KEY));
		user.setEmail(AES.encrypt(user.getEmail(), AppConstants.SECRET_KEY));
		user.setPassword(AES.encrypt(user.getPassword(), AppConstants.SECRET_KEY));
		System.out.println(user);
		
		return repository.saveUser(user);
	}
	

	@Override
	public User updateUser(User user) {
		user.setPhoneNumber(AES.encrypt(user.getPhoneNumber(), AppConstants.SECRET_KEY));
		user.setEmail(AES.encrypt(user.getEmail(), AppConstants.SECRET_KEY));
		user.setPassword(AES.encrypt(user.getPassword(), AppConstants.SECRET_KEY));
		User user2=repository.updateUser(user);
		user2.setPhoneNumber(AES.encrypt(user2.getPhoneNumber(), AppConstants.SECRET_KEY));
		user2.setEmail(AES.encrypt(user2.getEmail(), AppConstants.SECRET_KEY));
		user2.setPassword(AES.encrypt(user2.getPassword(), AppConstants.SECRET_KEY));
		
		
		return repository.updateUser(user);
	}
	

	@Override
	public User userLogin(String email, String password) {
	    String encEmail = AES.encrypt(email, AppConstants.SECRET_KEY);
	    String encPassword = AES.encrypt(password, AppConstants.SECRET_KEY);

	    User user2 = repository.Userlogin(encEmail, encPassword);

	    if (user2!= null) {
	        user2.setPhoneNumber(AES.decrypt(user2.getPhoneNumber(), AppConstants.SECRET_KEY));
	        user2.setEmail(AES.decrypt(user2.getEmail(), AppConstants.SECRET_KEY));
	        user2.setPassword(AES.decrypt(user2.getPassword(), AppConstants.SECRET_KEY));
	        new ValidUser().setUser(user2);
	    }

	    return user2;
	}

	@Override
	public User deleteUser(int id) {
		User user2= repository.deleteUser(id);
		user2.setPhoneNumber(AES.decrypt(user2.getPhoneNumber(), AppConstants.SECRET_KEY));
		user2.setEmail(AES.decrypt(user2.getEmail(), AppConstants.SECRET_KEY));
		user2.setPassword(AES.decrypt(user2.getPassword(), AppConstants.SECRET_KEY));
		return user2;
	}

}
	
