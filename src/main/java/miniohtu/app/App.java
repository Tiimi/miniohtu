package miniohtu.app;

import miniohtu.database.Database;
import java.sql.SQLException;
import java.util.Scanner;
import miniohtu.IO.ConsoleIO;

public class App {
    public static void main(String[] args) throws SQLException {
        Database database = new Database("viite.db");
        //database.createArticleTable();
        
        TextUI test = new TextUI(new ConsoleIO(new Scanner(System.in)), database);
        test.run();
        
//        ArticleDAO articleDAO = new ArticleDAO(database);
//        
//        Article a = new Article("JokuID", "Tekijä", "Titteli", "Journaali", 2001, 1);
//        
//        articleDAO.add(a);
//        
//        for (Article article : articleDAO.findAll()) {
//            System.out.println(article.toString());
//        }
    }
}
