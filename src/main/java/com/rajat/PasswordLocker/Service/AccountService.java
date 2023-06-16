package com.rajat.PasswordLocker.Service;

import java.util.List;

import com.rajat.PasswordLocker.entity.Account;

public interface AccountService {

    String saveAccount(Account account);
    Account updateAccount(Account account);
    Account deleteAccount(int id);
    Account getAccount(String email, String password);
    List<Account> getAllAccounts();
    List<Account> getAccountsByAccountName(String name);
}

