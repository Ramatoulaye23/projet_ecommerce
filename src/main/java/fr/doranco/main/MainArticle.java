package fr.doranco.main;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.Commande;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.CommandeDao;
import fr.doranco.ecommerce.model.IUserDao;
import fr.doranco.ecommerce.model.UserDao;

public class MainArticle {

	public static void main(String[] args) {

		try {
			Article article1 = new Article();
			article1.setId(rs.getInt("id"));
			article1.setNom("article1");
			article1.setDescription("description1");
			article1.setRemise(0.25f);
			article1.setStock(100);
			article1.setIsVendable(true);
		
			Article.add(article1);
						
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.exit(0);

	}
	
}
