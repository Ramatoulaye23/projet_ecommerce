package fr.doranco.main;

import org.hibernate.Session;

import fr.doranco.hibernate.modele.connection.HibernateDataSource;

public class Main {

	public static void main(String[] args) {

		try {
			Session session = HibernateDataSource.getInstance().getSession();
			System.out.println("Session Hibernate ouverte avec succès : " + session);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
