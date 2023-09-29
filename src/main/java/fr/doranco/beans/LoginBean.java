package fr.doranco.beans;

import javax.faces.bean.ManagedBean;

import fr.doranco.entity.User;
import fr.doranco.metier.IUserMetier;
import fr.doranco.metier.UserMetier;

@ManagedBean(name = "loginbean")
public class LoginBean {

	private String email;
	private String password;

	protected static fr.doranco.entity.User connectedUser;

	protected static String messageSuccess;
	protected static String messageError;

	static {
		messageError = "";
		messageSuccess = "";
	}

	private final UserMetier userMetier = new UserMetier();

	public LoginBean() {
	}

	public String seConnecter() {
		messageSuccess = "";
		messageError = "";
		try {
			connectedUser = userMetier.seConnecter(email, password);
			if (connectedUser == null) {
				messageError = "Email et/ou mot de passe incorrect(s) !";
				return "";
			}
			return "achats.xhtml";
		} catch (Exception e) {

			messageError = "Erreur Technique !\n" + e.getMessage();
			System.out.println(e);
			return "";
		}
	}

	public String inscription() {
		return "inscription.xhtml";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public IUserMetier getUserMetier() {
		return userMetier;
	}

}
