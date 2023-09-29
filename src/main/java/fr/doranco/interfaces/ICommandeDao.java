package fr.doranco.interfaces;

import java.util.List;

import fr.doranco.ecommerce.entity.Commande;

public interface ICommandeDao {
	
	Commande getCommande(Integer id);
	void addCommande(Commande commande);
	void removeCommande(Integer id);
	
	List<Commande> getCommandes1(); // avec requete JPQL
	List<Commande> getCommandes2(); // avec requete pédéfinie
	List<Commande> getCommandes3(); // avec requete SQL

}
