package fr.doranco.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "commande")
@NamedQueries({ @NamedQuery(name = "Commande.findAll", query = "FROM Commande c"),
		@NamedQuery(name = "Commande.findByNumero", query = "FROM Commande c WHERE c.numero = :numero") })
public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "numero", length = 25, nullable = false)
	private String numero;

	@Column(name = "date_commande", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateCommande;

	@Column(name = "date_livraison")
	@Temporal(TemporalType.DATE)
	private Date dateLivraison;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
	private List<LigneDeCommande> lignesDeCommande;

	public Commande() {
		this.numero = "C25";
		this.dateCommande = new Date();
		this.dateLivraison = new Date();
		lignesDeCommande = new ArrayList<LigneDeCommande>();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<LigneDeCommande> getLignesDeCommande() {
		return lignesDeCommande;
	}

	public void setListeLignesDeCommandes(List<LigneDeCommande> listeLignesDeCommandes) {
		this.lignesDeCommande = listeLignesDeCommandes;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", dateCommande=" + dateCommande + ", dateLivraison="
				+ dateLivraison + "]";
	}

}
