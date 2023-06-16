package com.rajat.PasswordLocker.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.rajat.PasswordLocker.entity.User;
import com.rajat.PasswordLocker.util.UserEntityManagerUtil;

public class UserRepositoryImp implements UserRepository {

	private EntityManager manager=UserEntityManagerUtil.getEntityManager();

	@Override
	public String saveUser(User user) {
		try {
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			return "data saved succesfully";
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "something went wrong";
	}	

	@Override
	public User updateUser(User user) {
		try {
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			return manager.find(User.class, user.getId());
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	

	@Override
	public User Userlogin(String email, String password) {
		
			try {
				String sql="FROM User u WHERE u.email=?1 AND u.password=?2";
				Query query=manager.createQuery(sql);
				query.setParameter(1, email);
				query.setParameter(2, password);
				List resultlist=query.getResultList();
				return (User) resultlist.get(0);
			}catch (Exception e) {
					
					e.printStackTrace();
				}
			
			return null;
		}
		

	
	
	

	@Override
	public User deleteUser(int id) {
		try {
			User user=manager.find(User.class, id);
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.remove(user);
			transaction.commit();
			return user;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	}


