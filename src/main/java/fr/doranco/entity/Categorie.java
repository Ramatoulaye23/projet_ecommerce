package fr.doranco.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "categorie")
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nom", length = 25, nullable = false)
	private String nom;

	@Column(name = "remise", length = 25, nullable = true)
	private Float remise;
	
	@Column(name = "isremisecumulable", length = 25, nullable = true)
	private Float isremisecumulable;
	
	@Column(name = "photo", length = 25, nullable = false)
	private String photo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
	private List<Article> articles;

	public Categorie() {

	}

	/**
	 * @param id
	 * @param nom
	 * @param remise
	 * @param isremisecumulable
	 * @param photo
	 * @param article
	 */
	public Categorie(Integer id, String nom, Float remise, Float isremisecumulable, String photo, Article article) {

		this.id = id;
		this.nom = nom;
		this.remise = remise;
		this.isremisecumulable = isremisecumulable;
		this.photo = photo;
		this.articles = new ArrayList<Article>();
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

	public Float getRemise() {
		return remise;
	}

	public void setRemise(Float remise) {
		this.remise = remise;
	}

	public Float getIsremisecumulable() {
		return isremisecumulable;
	}

	public void setIsremisecumulable(Float isremisecumulable) {
		this.isremisecumulable = isremisecumulable;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Article> getArticles() {
		return articles;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", remise=" + remise + ", isremisecumulable="
				+ isremisecumulable + ", photo=" + photo + "]";
	}




}
