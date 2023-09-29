package fr.doranco.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.utils.Dates;
import fr.doranco.metier.IUserMetier;
import fr.doranco.metier.UserMetier;

@ManagedBean(name = "userbean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "prenom", value = "Michel")
	private String prenom;

	@ManagedProperty(name = "nom", value = "DUPOND")
	private String nom;

	@ManagedProperty(name = "genre", value = "Monsieur")
	private String genre;

	@ManagedProperty(name = "dateNaissance", value = "")
	private Date dateNaissance;

	@ManagedProperty(name = "email", value = "camus@doranco.fr")
	private String email;

	private String motDePasse;

	private String motDePasseConfirmation;

	private String oldMotDePasse;

	@ManagedProperty(name = "numero", value = "16")
	private String numero;

	@ManagedProperty(name = "rue", value = "Rue Lafayette")
	private String rue;

	@ManagedProperty(name = "ville", value = "Paris")
	private String ville;

	@ManagedProperty(name = "codePostal", value = "75000")
	private String codePostal;

	private static String messageSuccess;
	private static String messageError;

	private List<Adresse> adressesTemp;

	public String niveauService;

	private UserMetier userMetier = new UserMetier();

	static {
		messageError = "";
		messageSuccess = "";
	}

	public UserBean() {
		this.adressesTemp = new ArrayList<Adresse>();
	}

	public String convertDateToString(Date date) {

		return Dates.convertDateToString(date);
	}

	public List<User> getUsers() {

		try {
			return userMetier.getUsers();

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public String addUser() {
		try {
			messageError = "";
			messageSuccess = "";

			if (!this.motDePasse.equals(motDePasseConfirmation)) {
				messageError = "Les deux mots de passe ne correspondent pas ! Veuillez réessayer.";
				return "";
			}
			if (userMetier.getUserByEmail(email) != null) {
				messageError = "L'adresse email est déjà utiliser. Veuillez saisir une adresse email valide.";
				return "";
			}
			User user = new User();
			user.setGenre(genre);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(email);
			user.setMotDePasse(motDePasse);
			user.setDateNaissance(dateNaissance);

			for (Adresse adresse : adressesTemp) {
				adresse.setUser(user);
				user.getAdresses().add(adresse);
			}

			userMetier.addUser(user);

//			
//			AdresseDao adresseDao = new AdresseDao();	
//			try {
//			user.getAdresses().forEach(a -> {
//				try {
//					adresseDao.addAdresse(a, id);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			});
//			}
//			catch (Exception e) {}

			this.genre = "";
			this.nom = "";
			this.prenom = "";
			this.email = "";
			this.niveauService = "";
			adressesTemp.clear();

			return "login.xhtml";

		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Erreur Technique !\n" + e.getMessage();
			System.out.println(e);
		}
		return "";
	}

	public String deleteUser(User user) {
		messageError = "";
		messageSuccess = "";
		return "";
	}

	public String updatePassword() {

		try {
			if (!this.motDePasse.equals(motDePasseConfirmation)) {
				messageError = "Le nouveau mot de passe et le mot de passe de confirmation ne correspondent pas !\n"
						+ "Veuillez réessayer.";
				return "";
			}
			User connectedUser = LoginBean.connectedUser;
			User user = userMetier.getUserByEmail(connectedUser.getEmail());
			if (!user.getMotDePasse().equals(this.oldMotDePasse)) {
				messageError = "L'ancien mot de passe est incorrect !";
				return "";
			}

			userMetier.updatePassword(this.motDePasse, connectedUser.getId());
			LoginBean.messageSuccess = "Mot de passe mis à jour avec succès";
			return "login.xhtml";

		} catch (Exception e) {
			LoginBean.messageError = "Erreur technique !\n" + e.getMessage();
			System.out.println(e);
		}
		return "";
	}

	public String addAdresse() {
		messageError = "";
		messageSuccess = "";
		Adresse adresse = new Adresse(this.numero, this.rue, this.ville, this.codePostal);
		this.adressesTemp.add(adresse);
		this.numero = "";
		this.rue = "";
		this.ville = "";
		this.codePostal = "";
		return "";
	}

	public List<Adresse> getAdresses(User user) {
		return user.getAdresses();
	}

	public List<String> getListeAdresses(User user) {

		List<String> userAdresses = new ArrayList<String>();
		if (user == null) {
			return userAdresses;
		}
		StringBuilder chaine = new StringBuilder();
		for (Adresse adresse : user.getAdresses()) {
			chaine.append(adresse.getNumero()).append(" ").append(adresse.getRue()).append(" ")
					.append(adresse.getVille()).append(" ").append(adresse.getCodePostal());
			userAdresses.add(chaine.toString());
		}
		return userAdresses;
	}

	public String remiseAzero() {
		this.genre = "";
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.niveauService = "";

		return "";
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date datedenaissance) {
		this.dateNaissance = datedenaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getOldMotDePasse() {
		return oldMotDePasse;
	}

	public void setOldMotDePasse(String oldMotDePasse) {
		this.oldMotDePasse = oldMotDePasse;
	}

	public String getMotDePasseConfirmation() {
		return motDePasseConfirmation;
	}

	public void setMotDePasseConfirmation(String motDePasseConfirmation) {
		this.motDePasseConfirmation = motDePasseConfirmation;
	}

	public String getNiveauService() {
		return niveauService;
	}

	public void setNiveauService(String niveaudeservice) {
		this.niveauService = niveaudeservice;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		UserBean.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		UserBean.messageError = messageError;
	}

	public List<Adresse> getAdressesTemp() {
		return adressesTemp;
	}

}
