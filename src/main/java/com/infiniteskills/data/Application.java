package com.infiniteskills.data;

import java.util.Date;

import org.hibernate.Session;

import com.infiniteskills.data.entities.User;

public class Application {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		
		User user= new User();
		
		user.setBirthDate(new Date());
		user.setCreatedBy("Apil");
		user.setCreatedDate(new Date());
		user.setEmailAddress("apiltiwari@gmail.com");
		user.setFirstName("Apil");
		user.setLastName("Tiwari");
		user.setLastUpdatedBy("Apil");
		user.setLastUpdatedDate(new Date());
		
		session.save(user);
		session.getTransaction().commit();
		session.beginTransaction();
		User dbUser= (User) session.get(User.class, user.getUserId());
		dbUser.setFirstName("Arjun");
		session.update(dbUser);
		session.getTransaction().commit();
		session.close();
	}
}
