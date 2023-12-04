package com.runwaysDAO;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import runwaysEntity.RunwaysEntity;

@Component
public class RunwaysDAOimp implements RunwaysDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public RunwaysDAOimp() {
		System.out.println("RunwaysDAOimp ()...");
	}

	@Override
	public boolean saveRunways(RunwaysEntity runwaysEntity) {
		Session session = null;
		boolean flag=false;
		try {
			 session = sessionFactory.openSession();
			 Transaction transaction = session.beginTransaction();
			 Serializable save = session.save(runwaysEntity);
			 flag=true;
			 
			 
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		
		
		return flag;
	}

}
