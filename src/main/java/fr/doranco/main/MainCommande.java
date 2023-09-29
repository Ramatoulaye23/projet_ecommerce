package fr.doranco.main;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.Commande;
import fr.doranco.ecommerce.entity.LigneDeCommande;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.ArticleDao;
import fr.doranco.ecommerce.model.CommandeDao;
import fr.doranco.ecommerce.model.UserDao;

public class MainCommande {

	public static void main(String[] args) {

		try {
			UserDao userDao = new UserDao();
			CommandeDao commandeDao = new CommandeDao();

			User user = userDao.getUser(1);

			Commande commande = new Commande();

			Article article1 = ArticleDao.getArticleById(1);
			LigneDeCommande ligne1 = new LigneDeCommande("c-article1", 20f, 5);
			ligne1.setArticle(article1);
			ligne1.setCommande(commande);

			Article article2 = ArticleDao.getArticleById(2);
			LigneDeCommande ligne2 = new LigneDeCommande("c-article2", 40f, 7);
			ligne2.setArticle(article2);
			ligne2.setCommande(commande);

			commande.getLignesDeCommande().add(ligne1);
			commande.getLignesDeCommande().add(ligne2);

			commande.setUser(user);

			commandeDao.addCommande(commande);     

			System.out.println(commande);

			commande.getLignesDeCommande().forEach(ligne -> System.out.println("  => " + ligne));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.exit(0);

	}

}
