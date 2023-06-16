package com.rajat.PasswordLocker.util;



import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class UserEntityManagerUtil {
	private static EntityManager manager;
	private  UserEntityManagerUtil() {
		
	}
	public static EntityManager getEntityManager() {
		if(manager==null) {
			manager=Persistence.createEntityManagerFactory("abhi").createEntityManager();
		}
		return manager;
	}

}

