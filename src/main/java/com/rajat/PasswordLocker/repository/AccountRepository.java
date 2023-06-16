package com.rajat.PasswordLocker.repository;

import java.util.List;

import com.rajat.PasswordLocker.entity.Account;

public  interface AccountRepository {
	 String saveAccount(Account account);
	   
	   Account updateAccount(Account account);
	   
	   Account deleteAccount(int id);

	   List<Account> getAllAccounts();
	   
	   List<Account> getAccountByAccountName(String name);

	//Account getAccountByEmailAndPassword(String encryptedEmail, String encryptedPassword);

	//Account getAccountByEmailAndPassword(String encryptedEmail, String encryptedPassword);

	//Account getAccountByEmailAndPassword(String encryptedEmail, String encryptedPassword);


}