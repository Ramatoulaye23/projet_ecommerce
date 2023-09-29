package fr.doranco.model.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.ecommerce.entity.Commande;
import fr.doranco.ecommerce.entity.Commentaire;
import fr.doranco.hibernate.modele.connection.HibernateDataSource;
import fr.doranco.interfaces.ICommentaireDao;

public class CommentaireDao implements ICommentaireDao {

	@Override
	public  Commentaire getCommentaire(Integer id) {
		
		Session session = HibernateDataSource.getInstance().getSession();
		Transaction tx = null;

		 Commentaire  commentaire = new  Commentaire();

		try {
			tx = session.beginTransaction();

			 commentaire = session.find(Commentaire.class, id);
			tx.commit();

		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

		return  commentaire;
	}
	@Override
	public void addCommentaire(Commentaire commentaire) {


		if (commentaire == null) {
			throw new NullPointerException("Le commentaire ne doit pas être NULL !");
		}
			
		Session session = HibernateDataSource.getInstance().getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(commentaire);
			commentaire.getArticle();
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
	public void removecommentaire(Integer article_id) {

		Session session = HibernateDataSource.getInstance().getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Commentaire commentaire = session.find(Commentaire.class, article_id);
			session.remove(commentaire);
			tx.commit();

		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

	}
	@Override
	public Commande getCommande(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addCommande(Commande commande) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeCommande(Integer id) {
		// TODO Auto-generated method stub
		
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
