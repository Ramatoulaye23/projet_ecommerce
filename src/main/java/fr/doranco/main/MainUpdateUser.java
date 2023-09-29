package fr.doranco.main;

import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.IUserDao;
import fr.doranco.ecommerce.model.UserDao;

public class MainUpdateUser {

	public static void main(String[] args) {

		try {

			IUserDao userDao = new UserDao();
			User user = userDao.getUserById(1);

			System.out.println("Avant mise à jour :");
			System.out.println("===================");
			System.out.println(user);
			System.out.println(user.getAdresses());

			user.setNom("Camus2");
			user.setPrenom("albert2");

			user.getAdresses().setNumero("10");
			user.getAdresses().setRue("rue paris");

			System.out.println();
			System.out.println("Mise à jour en cours..");
			System.out.println();

			userDao.updateUser(user);

			System.out.println("Après mise à jour :");
			System.out.println("===================");
			User updatedUser = userDao.getUserById(1);
			System.out.println(updatedUser);
			System.out.println(updatedUser.getAdresses());

			System.out.println("effacer l'enregistrement");
			System.out.println("===================");
			userDao.removeUser(1);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.exit(0);
	}

}
