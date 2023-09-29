package fr.doranco.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.CascadeType;



@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="genre",length = 25,nullable=false)
	private String genre;
	
	@Column(name="prenom",length = 25,nullable=false)
	private String prenom;
	
	@Column(name="nom",length = 25,nullable=false)
	private String nom;
	
	@Column(name="date_naissance",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Column(name="email",length = 55,nullable=false)
	private String email;
	
	@Column(name="password", length = 55, nullable=false)
	private String motDePasse;
	
	@Column(name = "actif", nullable = false)
	private boolean isActif;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Adresse> adresses;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Commande> commandes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Commentaire> commentaires;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<CartePaiement> cartesPaiement;
	
	public User() {
		this.adresses = new ArrayList<Adresse>();
		this.commandes = new ArrayList<Commande>();
		this.commentaires = new ArrayList<Commentaire>();
		this.cartesPaiement = new ArrayList<CartePaiement>();
		
	}
	
	/**
	 * @param id
	 * @param genre
	 * @param prenom
	 * @param nom
	 * @param dateNaissance
	 * @param email
	 * @param motDePasse
	 * @param isActif
	
	 */
	public User(Integer id, String genre, String prenom, String nom, Date dateNaissance, String email,
			String motDePasse, boolean isActif, List<Adresse> adresses, List<Commande> commandes,
			List<Commentaire> commentaires, List<CartePaiement> cartesPaiement) {
	
		this.id = id;
		this.genre = genre;
		this.prenom = prenom;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.motDePasse = motDePasse;
		this.isActif = isActif;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", genre=" + genre + ", prenom=" + prenom + ", nom=" + nom + ", dateNaissance="
				+ dateNaissance + ", email=" + email + ", motDePasse=" + motDePasse + ", isActif=" + isActif + "]";
	}

}