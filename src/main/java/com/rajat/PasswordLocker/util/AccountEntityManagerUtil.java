package com.rajat.PasswordLocker.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AccountEntityManagerUtil {
	private static EntityManager manager;
	
	private AccountEntityManagerUtil() {
		
	}

	public static EntityManager getEntityManager() {
		if(manager==null){
			manager=Persistence.createEntityManagerFactory("abhi").createEntityManager();
		}
		return manager;
	}
}