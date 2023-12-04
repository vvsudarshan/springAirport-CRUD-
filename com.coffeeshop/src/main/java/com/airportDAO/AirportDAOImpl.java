package com.airportDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airportEntity.AirportEntity;

@Component
public class AirportDAOImpl implements AirportDAO{
	
	private static final String AirportEntity = null;
	@Autowired
	SessionFactory sessionFactory;
	

	public AirportDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println("Session factory invocked...");
	}
	
	@Override
	public boolean saveAirportEntity(AirportEntity entity) {
		boolean flag=false;
		System.out.println("involked the Save method");
		Session session=null ;
		
		
		try {
			
			session = sessionFactory.openSession();
			System.out.println("beginn the Save method");
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			System.out.println("comit the Save method");
			flag=true;
				
			
		}
		finally {
			if(session!=null) {
				session.close();
				
			}
		}
		return flag;
	}
	public AirportEntity getAirportEntityById(int search) {
		Session session =null;
		AirportEntity entity =null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			entity = session.get(AirportEntity.class, search);
			session.getTransaction().commit();
				
			
		}
		finally{
			if(session!=null) {
				session.close();
				
			}
		}
		return entity;
		
		
		
	}

	@Override
	public AirportEntity getAirportEntityByName(String searchName) {
		
		Session session = null;
		AirportEntity entity = null;
		String sql  = "from AirportEntity where airport_name ='"+ searchName +"'" ;
		
		try {
			
			session = sessionFactory.openSession();
			Query query = session.createQuery(sql);
			List list = query.getResultList();
			if(list.size()!=0) {
				entity=(AirportEntity)list.get(0);
			}
			
			
		}finally{
			if(session!=null) {
				session.close();
				
			}
		}
		return entity;
	}
	@Override
	public boolean deleteById(int Id) {
		boolean flag=false;
		Session session=null;
		
		
		try {
			 session = sessionFactory.openSession();
			 session.beginTransaction();
			 AirportEntity entity = session.get(AirportEntity.class, Id);
			 
			 if(entity!=null) {
				 session.remove(entity);
				 session.getTransaction().commit();
				 flag=true;
			 }
		}
		finally {
			if(session!=null) {
				session.close();
				
			}
		}
		return flag;
		
	}
	public boolean deleteByName(String Name) 
	{
		System.out.println("deleteByName invocked...()");
		boolean flag=false;
		Session session=null;
		AirportEntity entity;
		String hql  = "from AirportEntity where airport_name ='"+ Name +"'" ;
		try
		{
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query query = session.createQuery(hql);
			
			List list = query.getResultList();
			System.out.println("list.size() :"+list.size());
			if(list.size()!=0) {
				entity=(AirportEntity)list.get(0);
				
				System.out.println("entity: "+entity);
				session.remove(entity);
				
				session.getTransaction().commit();
				System.out.println("flag :"+flag);
				flag=true;
			}
		}
		finally 
		{
			if(session!=null)
			{
				session.close();
			}
			
		}
		return flag;
	}
	
		
	
	public List<AirportEntity> getAllAirportEntity(){
		
		Session session =null;
		List list =null;
		String hql = "from AirportEntity";
		try {
			
			session  = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			list  = query.getResultList();
		}
		finally{
			if(session!=null) {
				session.close();
			}
		}
		return list;
		
	}

	@Override
	public boolean updateAirportById(AirportEntity entity) {
		System.out.println("updateAirportById");
		Session session =null;
		boolean flag=false;
		try {
			 session = sessionFactory.openSession();
			 session.beginTransaction();
			 session.update(entity);
			 session.getTransaction().commit();
			 flag=true;
		}
		finally{
			session.close();
		}

		return flag;
	}
	


	
	

	
}