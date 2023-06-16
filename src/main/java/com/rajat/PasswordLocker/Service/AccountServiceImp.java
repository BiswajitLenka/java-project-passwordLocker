package com.rajat.PasswordLocker.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.rajat.PasswordLocker.entity.Account;
import com.rajat.PasswordLocker.repository.AccountRepository;
import com.rajat.PasswordLocker.repository.AccountRepositoryImp;
import com.rajat.PasswordLocker.util.AES;
import com.rajat.PasswordLocker.util.AppConstants;

public class AccountServiceImp  implements AccountService {
	
	
	private AccountRepository repository;
	{
		repository=new AccountRepositoryImp();
	}

	@Override
	public String saveAccount(Account account) {
		account.setAccountname(AES.encrypt(account.getUserName(), AppConstants.SECRET_KEY));
	account.setPassword(AES.encrypt(account.getPassword(), AppConstants.SECRET_KEY));
	return repository.saveAccount(account);
	}

	@Override
	public Account updateAccount(Account account) {
		account.setAccountname(AES.encrypt(account.getUserName(), AppConstants.SECRET_KEY));
		account.setPassword(AES.encrypt(account.getPassword(), AppConstants.SECRET_KEY));
	Account account2=repository.updateAccount(account);
		account2.setUserName(AES.decrypt(account2.getUserName(), AppConstants.SECRET_KEY));
		account2.setPassword(AES.decrypt(account2.getPassword(), AppConstants.SECRET_KEY));
	return account2;
			}

	@Override
	public Account deleteAccount(int id) {
		Account account2=repository.deleteAccount(id);
		account2.setAccountname(AES.encrypt(account2.getUserName(), AppConstants.SECRET_KEY));
	account2.setPassword(AES.encrypt(account2.getPassword(), AppConstants.SECRET_KEY));
		return account2;
	}

//	@Override
//	public Account getAccount(String email, String password) {
//		 // Retrieve the encrypted email and password from the database
//	    String encryptedEmail = AES.encrypt(email, AppConstants.SECRET_KEY);
//	    String encryptedPassword = AES.encrypt(password, AppConstants.SECRET_KEY);
//	    
//	    // Call the repository method to get the account by email and password
//	    Account account = repository.getAccountByEmailAndPassword(encryptedEmail, encryptedPassword);
//	    
//	    if (account != null) {
//	        // Decrypt the retrieved account details
//	        account.setUserName(AES.decrypt(account.getUserName(), AppConstants.SECRET_KEY));
//	        account.setPassword(AES.decrypt(account.getPassword(), AppConstants.SECRET_KEY));
//	    }
//	    
//	    return account;
//	}
//		
//	
	@Override
	public Account getAccount(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		
			List<Account> list=repository.getAllAccounts();
			return list.stream().map(account2->{
				account2.setUserName(AES.decrypt(account2.getUserName(), AppConstants.SECRET_KEY));
				account2.setPassword(AES.decrypt(account2.getPassword(), AppConstants.SECRET_KEY));
				return account2;
				}).collect(Collectors.toList());
		}
	

	@Override
	public List<Account> getAccountsByAccountName(String name) {
		List<Account> list=repository.getAccountByAccountName(name);
		return list.stream().map(account2->{
			account2.setUserName(AES.decrypt(account2.getUserName(), AppConstants.SECRET_KEY));
			account2.setPassword(AES.decrypt(account2.getPassword(), AppConstants.SECRET_KEY));
			return account2;
			}).collect(Collectors.toList());
	}
	}


