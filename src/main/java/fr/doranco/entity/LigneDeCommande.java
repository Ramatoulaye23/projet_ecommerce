package fr.doranco.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligne_commande")
public class LigneDeCommande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "quantite", nullable = false)
	private Integer quantite;

	@Column(name = "prix_unitaire", nullable = false)
	private Integer prixUnitaire;

	@Column(name = "remise_article", nullable = false)
	private Integer remiseArticle;

	@OneToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "commande_id", nullable = false)
	private Commande commande;

	public LigneDeCommande(Integer quantite, Integer prixUnitaire, Integer remiseArticle, Article article) {

		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
		this.article = article;
	}
	ArrayList<LigneDeCommande> lignedecommande = new ArrayList<LigneDeCommande>();
	
	public LigneDeCommande(String string, float f, int i) {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Integer getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Integer prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Integer getRemiseArticle() {
		return remiseArticle;
	}

	public void setRemiseArticle(Integer remiseArticle) {
		this.remiseArticle = remiseArticle;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "LigneDeCommande [id=" + id + ", quantite=" + quantite + ", prixUnitaire=" + prixUnitaire
				+ ", remiseArticle=" + remiseArticle + "]";
	}

}
