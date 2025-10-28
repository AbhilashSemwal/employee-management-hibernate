package com.maven;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public static SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}
}
