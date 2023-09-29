package fr.doranco.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.entity.User;
import fr.doranco.hibernate.modele.connection.HibernateDataSource;
import fr.doranco.interfaces.IUserDao;


public class UserDao implements IUserDao {

	@Override
	public void addUser(User user) throws Exception {

		if (user == null) {
			throw new NullPointerException("Le user à ajouter ne doit pas être NULL !");
		}

		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateDataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw ex;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

	}

	@Override
	public User getUserByEmail(String email) throws Exception {

		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("L'email doit être renseigné !");
		}

		Session session = null;
		try {
			session = HibernateDataSource.getInstance().getSession();
			Query<User> query = session.createQuery("FROM User u WHERE u.email = ?1", User.class);
			query.setParameter(1, email);
			return query.uniqueResult();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}

	@Override
	public User getUserById(Integer id) throws Exception {

		if (id == null || id <= 0) {
			throw new IllegalArgumentException("id non renseigné, null ou négatif !");
		}

		Session session = HibernateDataSource.getInstance().getSession();

		Query<User> query = session.createQuery("SELECT u FROM User u WHERE id = ?1", User.class).setParameter(1, id);

		try {
			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteUser(int id) throws Exception {

		Session session = HibernateDataSource.getInstance().getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			User user = session.find(User.class, id);
			session.remove(user);
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
	public List<User> getUsers() throws Exception {

		Session session = HibernateDataSource.getInstance().getSession();
		Query<User> query = session.createQuery("SELECT u FROM User u", User.class);
		return (List<User>) query.list();
	}

	public void updatePassword(String password, Integer userId) {

		Session session = HibernateDataSource.getInstance().getSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
//			session.createQuery("update user u set u.motDePasse = :password where u.id = :userId")
//					.setString("password", password)
//					.setString("userId", Integer.toString(userId))
//					.executeUpdate();
			Query<User> query = session.createNativeQuery("UPDATE user SET password =:password WHERE id=:userId", User.class);

			query.setParameter("password", password);
			query.setParameter("userId", userId);

			query.executeUpdate();

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

	public User getUser(Integer id) {

		Session session = HibernateDataSource.getInstance().getSession();
		Transaction tx = null;

		User user = new User();

		try {
			tx = session.beginTransaction();

			user = session.find(User.class, id);
			tx.commit();

		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

		return user;
	}

	public void updateUser(User user) {

		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateDataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(user);
			tx.commit();

		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw ex;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

	}

}
