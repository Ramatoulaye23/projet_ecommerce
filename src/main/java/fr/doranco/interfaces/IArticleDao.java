package fr.doranco.interfaces;





import fr.doranco.ecommerce.entity.Article;

public interface IArticleDao {

	int addArticle(Article article, int userId) throws Exception;

	java.util.List<Article> getArticle(int userId) throws Exception;

	int deleteArticle(Article article, int userId) throws Exception;
}