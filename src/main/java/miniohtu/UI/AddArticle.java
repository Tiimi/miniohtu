/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.UI;

import java.sql.SQLException;
import miniohtu.IO.IO;
import miniohtu.database.ArticleDAO;
import miniohtu.entry.Article;

/**
 *
 * @author leokallo
 */
public class AddArticle extends AddOperation {
    private final ArticleDAO articleDAO;
    
    public AddArticle(IO io, ArticleDAO article) {
        super(io);
        this.articleDAO = article;
    }

    @Override
    public void execute() {
        Article a = new Article(askAllFields(Article.mandatoryFields, Article.optionalFields));

        try {
            articleDAO.add(a);
            io.print("Artikkeli lisätty.");
        } catch (SQLException ex) {
            io.print("Lisäys epäonnistui. SQLException");
            io.print(ex.getMessage());
        }
    }
    
}
