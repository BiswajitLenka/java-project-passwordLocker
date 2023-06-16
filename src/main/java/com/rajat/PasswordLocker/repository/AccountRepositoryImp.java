package com.rajat.PasswordLocker.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.rajat.PasswordLocker.entity.Account;
import com.rajat.PasswordLocker.entity.User;
import com.rajat.PasswordLocker.util.AccountEntityManagerUtil;
import com.rajat.PasswordLocker.util.ValidUser;

public class AccountRepositoryImp implements AccountRepository{
 
	
	private User user;
    private EntityManager manager=AccountEntityManagerUtil.getEntityManager();
    {
    	user=new ValidUser().getUser();
    }
	@Override
	public String saveAccount(Account account) {
		account.setUserID(user.getId());
		try {
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.persist(account);
			transaction.commit();
			return "data saved successfully";
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return "something went wrong";
	}

	@Override
	public Account updateAccount(Account account) {
		account.setUserID(user.getId());
		try {
		
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.merge(account);
		transaction.commit();
		return manager.find(Account.class, account.getId());
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return null;
	}

	@Override
	public Account deleteAccount(int id) {
		Account account=manager.find(Account.class, id);
		try {
		
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.remove(account);
		transaction.commit();
		return account;
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return null;
	}

	

	@Override
	public List<Account> getAllAccounts() {
		String sql="FROM Account a WHERE a.userID=?1";
		Query query=manager.createQuery(sql);
		List list=query.getResultList();
		return list;
	}
	

	@Override
	public List<Account> getAccountByAccountName(String name) {
		String sql="FROM Account a WHERE a.accountname=?1 AND a.userID=?2";
		   Query query=manager.createQuery(sql);
			query.setParameter(1,name);
			//query.setParameter(2,user,getId());
			query.setParameter(2,user.getId());
			List list=query.getResultList();
			return list;
		}
	

//	@Override
//	//public Account getAccountByEmailAndPassword(String encryptedEmail, String encryptedPassword) {
//
//
//		    String sql = "FROM Account a WHERE a.email = ?1 AND a.password = ?2";
//		    Query query = manager.createQuery(sql);
//		    query.setParameter(1, encryptedEmail);
//		    query.setParameter(2, encryptedPassword);
//
//		    List<Account> resultList = query.getResultList();
//
//		    if (!resultList.isEmpty()) {
//		        Account account = resultList.get(0);
//		        return account;
//		    }
//
//		    return null;
//		}
	}

   