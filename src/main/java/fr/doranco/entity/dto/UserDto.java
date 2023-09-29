package fr.doranco.entity.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "adresse")
@XmlRootElement

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "id")
	private Integer id;

	@Column(name = "nom", length = 25, nullable = false)
	private String nom;

	@Column(name = "prenom", length = 25, nullable = false)
	private String prenom;

	@Column(name = "email", length = 25, nullable = false)
	private String email;

	@Column(name = "password", length = 25, nullable = false)
	private String password;

	public UserDto() {
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param password
	 */
	public UserDto(Integer id, String nom, String prenom, String email, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + "]";
	}

}
