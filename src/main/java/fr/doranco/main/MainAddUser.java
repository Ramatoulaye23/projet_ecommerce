package fr.doranco.main;

import fr.doranco.entity.Adresse;
import fr.doranco.entity.User;
import fr.doranco.utils.Dates;


public class MainAddUser {

	public static void main(String[] args) {

		try {

			User user = new User();
			user.setGenre("F");
			user.setNom("FAINKE");
			user.setPrenom("Rama");
			user.setDateNaissance(Dates.convertStringToDate("07/11/1913"));
			user.setEmail("rama@gmail.com");
			user.setMotDePasse("fainkerama");
			user.setActif(true);

			Adresse adresse = new Adresse("9", "Rue de la gare", "Marseille", "13000");
			adresse.setUser(user);
			user.getAdresses().add(adresse);

			IUserDao userDao = new UserDao();
			userDao.addUser(user);

			System.out.println(user);
			user.getAdresses().forEach(a -> System.out.println("  -> " + a));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.exit(0);
	}

}
