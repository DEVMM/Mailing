package br.com.grupomm.mailing.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("grupomm-anuarios");
private static EntityManagerFactory mmonline = Persistence.createEntityManagerFactory("grupomm-mmonline");
private static EntityManagerFactory mySql = Persistence.createEntityManagerFactory("grupomm-mysql");	
	public EntityManager getEntituManager(){
		return entityManagerFactory.createEntityManager();
	}
public EntityManager getMySql(){
	return mySql.createEntityManager();
}

public EntityManager getMMonline(){
	return mmonline.createEntityManager();
}
}
