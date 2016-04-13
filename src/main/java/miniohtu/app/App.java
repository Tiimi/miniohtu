package miniohtu.app;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        Database database = new Database("viite.db");
        database.createArticleTable();
        
        ArticleDAO articleDAO = new ArticleDAO(database);
        
        Article a = new Article("JokuID", "Tekijä", "Titteli", "Journaali", 2001, 1);
        
        articleDAO.add(a);
        
        for (Article article : articleDAO.findAll()) {
            System.out.println(article.toString());
        }
    }
}
