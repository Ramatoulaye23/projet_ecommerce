package fr.doranco.hibernate.modele.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDataSource {
	
	private SessionFactory sessionFactory;
	private Session session;
	private static HibernateDataSource instance;
	
	
	private HibernateDataSource() {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
	}
	
	public  Session getSession() {
		
		session = sessionFactory.openSession();
		return session;
		
	}

	public static HibernateDataSource getInstance() {
		
		if(instance==null) {
			instance = new HibernateDataSource();
		}
		return instance;
	}

	public static void setInstance(HibernateDataSource instance) {
		HibernateDataSource.instance = instance;
	};

}
