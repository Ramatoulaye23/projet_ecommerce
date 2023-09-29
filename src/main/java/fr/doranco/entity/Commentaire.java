package fr.doranco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "commentaire")
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "texte", length = 25, nullable = false)
	private String texte;

	@Column(name = "note", length = 25, nullable = false)
	private Integer note;

	@ManyToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Commentaire(String texte, Integer note, String article) {

		this.texte = texte;
		this.note = note;

	}

	public Commentaire() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
