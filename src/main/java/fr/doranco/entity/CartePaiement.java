package fr.doranco.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name = "carte_paiement")
public class CartePaiement implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nomProprietaire", length = 4, nullable = false)
	private String nomProprietaire;

	@Column(name = "prenomProprietaire", length = 45, nullable = false)
	private String prenomProprietaire;

	@Column(name = "numero", length = 20, nullable = false)
	private Integer numero;
	@Column(name = "dateFinValidite", length = 20, nullable = false)
	private Date dateFinValidite;

	@Column(name = "cryptogramme", length = 5, nullable = false)
	private String cryptogramme;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public CartePaiement() {
	}

	/**
	 * @param id
	 * @param nomProprietaire
	 * @param prenomProprietaire
	 * @param numero
	 * @param dateFinValidite
	 * @param cryptogramme
	 * @param user
	 */
	public CartePaiement(Integer id, String nomProprietaire, String prenomProprietaire, Integer numero,
			Date dateFinValidite, String cryptogramme, User user) {
	
		this.id = id;
		this.nomProprietaire = nomProprietaire;
		this.prenomProprietaire = prenomProprietaire;
		this.numero = numero;
		this.dateFinValidite = dateFinValidite;
		this.cryptogramme = cryptogramme;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getPrenomProprietaire() {
		return prenomProprietaire;
	}

	public void setPrenomProprietaire(String prenomProprietaire) {
		this.prenomProprietaire = prenomProprietaire;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CartePaiement [id=" + id + ", nomProprietaire=" + nomProprietaire + ", prenomProprietaire="
				+ prenomProprietaire + ", numero=" + numero + ", dateFinValidite=" + dateFinValidite + ", cryptogramme="
				+ cryptogramme + ", user=" + user + "]";
	}

}
