package fr.doranco.interfaces;

import java.util.List;

import fr.doranco.ecommerce.entity.Commande;
import fr.doranco.ecommerce.entity.Commentaire;

public interface ICommentaireDao {
	
	Commande getCommande(Integer id);
	void addCommande(Commande commande);
	void removeCommande(Integer id);
	
	List<Commande> getCommandes1(); // avec requete JPQL
	List<Commande> getCommandes2(); // avec requete pédéfinie
	List<Commande> getCommandes3(); // avec requete SQL
	Commentaire getCommentaire(Integer article_id);

}
