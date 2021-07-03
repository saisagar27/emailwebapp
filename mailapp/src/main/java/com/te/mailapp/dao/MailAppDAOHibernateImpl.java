package com.te.mailapp.dao;

import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

import com.te.mailapp.beans.User;

@Repository
public class MailAppDAOHibernateImpl implements MailAppDAO{

	@Override
	public User getLogin(String username,String password) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("MailDB");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("from User where user_name=:user");
		q.setParameter("user", username);
		User u=(User) q.getSingleResult();
		if(u!=null) {
			if(u.getPassword().equals(password)) {
				return u;
				
			}
		}
		return null;
	}

	@Override
	public User register(User u)  {
	
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("MailDB");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
//		String emaildemo=u.getEmail();
//		Query q=em.createQuery("from User where email=:mail");
//		q.setParameter("mail", emaildemo);
//		User user1=(User)q.getSingleResult();
		
		
		et.begin();
		
		if(u!=null) {
		em.persist(u);
		et.commit();
		}
	
		
		
		return u;
	}

	@Override
	public User fetchEmail(String email) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("MailDB");
		EntityManager em=emf.createEntityManager();
		
		
		Query q=em.createQuery("from User where email=:mail");
		q.setParameter("mail", email);
		
		User u=(User)q.getSingleResult();
		
		return u;
		}

	@Override
	public User loginUser(User user) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("MailDB");
		EntityManager em=emf.createEntityManager();
		
		String username=user.getUser_name();
		String password=user.getPassword();
		
		Query q=em.createQuery("from User where user_name=:u");
		q.setParameter("u", username);
		User u=(User) q.getSingleResult();
		if(u!=null) {
			if(u.getPassword().equals(password)) {
				return u;
				
			}
		}
		return null;
	}
		
		
		
		
		
		
	}


