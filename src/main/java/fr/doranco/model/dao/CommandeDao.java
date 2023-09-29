package fr.doranco.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.ecommerce.entity.Commande;
import fr.doranco.hibernate.modele.connection.HibernateDataSource;
import fr.doranco.interfaces.ICommandeDao;

public class CommandeDao implements ICommandeDao {

	@Override
	public Commande getCommande(Integer id) {

		Session session = HibernateDataSource.getInstance().getSession();
		Transaction tx = null;
		Commande commande = new Commande();
		try {

			commande = session.find(Commande.class, id);
			tx.commit();

		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

		return commande;
	}

	@Override
	public void addCommande(Commande commande) {

		if (commande == null) {
			throw new NullPointerException("La commande ne doit pas être NULL !");
		}
		if (commande.getLignesDeCommande() == null || commande.getLignesDeCommande().isEmpty()) {
			throw new IllegalArgumentException("Les lignes de commande sont obligatoires !");
		}

		Session session =HibernateDataSource.getInstance().getSession();
		Transaction tx = null;

		try {
					
			
			tx = session.beginTransaction();
			session.save(commande);
			commande.getLignesDeCommande().forEach(ligne -> session.save(ligne));
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	@Override
	public void removeCommande(Integer id) {

		Session session = HibernateDataSource.getInstance().getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Commande commande = session.find(Commande.class, id);
			session.remove(commande);
			tx.commit();

		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

	}

	@Override
	public List<Commande> getCommandes1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> getCommandes2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> getCommandes3() {
		// TODO Auto-generated method stub
		return null;
	}


}
