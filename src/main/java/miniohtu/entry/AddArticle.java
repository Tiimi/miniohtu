/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.entry;

import java.sql.SQLException;
import miniohtu.IO.IO;
import miniohtu.database.ArticleDAO;

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
        io.print(mandatoryFields);

        String citationKey = askString("citation key");
        String author = askString("author");
        String title = askString("title");
        String journal = askString("journal");
        int year = askInteger("year");

        io.print("\nSyötä valinnaiset kentät:\n");
        int volume = askOptionalInteger("volume");
        int number = askOptionalInteger("number");
        String pages = askOptionalString("pages");
        int month = askOptionalInteger("month");
        String note = askOptionalString("note");

        Article a = new Article(citationKey, author, title, journal, year, volume, number, pages, month, note);

        try {
            articleDAO.add(a);
            io.print("Artikkeli lisätty.");
        } catch (SQLException ex) {
            io.print("Lisäys epäonnistui. SQLException");
            io.print(ex.getMessage());
        }
    }
    
}
