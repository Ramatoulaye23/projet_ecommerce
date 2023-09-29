package fr.doranco.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nom", length = 25, nullable = false)
	private String nom;

	@Column(name = "description", length = 25, nullable = false)
	private String description;

	@Column(name = "remise", length = 25, nullable = false)
	private Float remise;

	@Column(name = "stock", length = 25, nullable = false)
	private Integer stock;

	@Column(name = "is_vendable", length = 25, nullable = false)
	private Boolean isVendable;

	@ManyToOne
	@JoinColumn(name = "categorie_id", nullable = false)
	private Categorie categorie;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
	private List<Commentaire> commentaires;

	public Article() {
		this.commentaires = new ArrayList<Commentaire>();
	}

	public Article(String nom, String description, Float remise, Integer stock, Boolean isVendable) {

		this.nom = nom;
		this.description = description;
		this.remise = remise;
		this.stock = stock;
		this.isVendable = isVendable;
		this.commentaires = new ArrayList<Commentaire>();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getRemise() {
		return remise;
	}

	public void setRemise(Float remise) {
		this.remise = remise;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Boolean getIsVendable() {
		return isVendable;
	}

	public void setIsVendable(Boolean isVendable) {
		this.isVendable = isVendable;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Commentaire> getCommentaires() {
		return getCommentaires();
	}
public static void add(Article article1) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", description=" + description + ", remise=" + remise + ", stock="
				+ stock + ", isVendable=" + isVendable + "]";
	}

	
}
