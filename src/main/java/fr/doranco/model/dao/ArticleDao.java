package fr.doranco.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.ecommerce.entity.Article;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.hibernate.modele.connection.HibernateDataSource;

public class ArticleDao implements IArticleDao{

	
public void ArticleDAO() {
	
}

@Override
public int addArticle(Article article, int userId) throws Exception {
	if (article == null) {
		throw new NullPointerException("L'article à ajouter ne doit pas être NULL !");
	}

	Session session = HibernateDataSource.getInstance().getSession();
	Transaction tx = null;

	try {
		tx = session.beginTransaction();

		session.save(article);
		if (article.getId() != null && !article.getId().isEmpty()) {
			article.getId();
		}
		tx.commit();

	
	} finally {
		if (session != null && session.isOpen())
			session.close();
	}

}

@Override
public List<Article> getArticle(int userId) throws Exception {
	Connection connection = EcommerceDataSource.getInstance().getConnection();
	String requete = "SELECT * FROM artricle WHERE user_id = ?";
	PreparedStatement ps = connection.prepareStatement(requete);
	ps.setInt(1, userId);
	ResultSet rs = ps.executeQuery();
	List<Article> article = new ArrayList<Article>();
	if (rs != null) {
		while (rs.next()) {
			Article article1 = new Article();
			article1.setId(rs.getInt("id"));
			article1.setNom(requete);
			article1.setDescription(requete);
			article1.setRemise(null);
			article1.setStock(null);
			article1.setIsVendable(null);
		
			Article.add(article);
		}
	}
	return article;
}



@Override
public int deleteArticle(Article article, int articleId) throws Exception {

	Session session = HibernateDataSource.getInstance().getSession();

	try {
	

		Article article1 = session.find(Article.class, articleId);
		session.remove(article1);
	


	} finally {
		if (session != null && session.isOpen())
			session.close();
	}
	return articleId;
}

public static Article getArticleById(int i) {
	// TODO Auto-generated method stub
	return null;
}



}
