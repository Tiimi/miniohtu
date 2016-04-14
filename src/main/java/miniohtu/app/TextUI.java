/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.app;

import miniohtu.database.Database;
import miniohtu.entry.Article;
import miniohtu.database.ArticleDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import miniohtu.IO.IO;

/**
 *
 * @author antti
 */
public class TextUI {

    private final String help = "Komennot\n lisaa\n listaa\n lopeta\n";
    private final String addHelp = "Valitse lisättävä viite typpi:\nartikkeli\n\nperu peruu toiminnon\n";
    private final String wrongCommand = "Väärä komento: ";
    private final IO io;
    private final Database db;
    private final ArticleDAO articleDAO;

    public TextUI(IO io, Database db) {
        this.io = io;
        this.db = db;
        this.articleDAO = new ArticleDAO(this.db);
    }

    public void run() {
        io.print(help);
        while (true) {
            io.print(">");
            String komento = io.nextString();
            io.print("KOMENTO: " + komento);
            if (komento.equals("lopeta")) {
                break;
            }
            runCommand(komento);
        }
    }

    public void runCommand(String komento) {
        if (komento.equals("lisaa")) {
            lisaa();
        } else if (komento.equals("listaa")) {
            listaa();
        } else {
            io.print(wrongCommand + komento);
        }

    }

    public void lisaa() {
        io.print(addHelp);
        String komento = io.nextString();
        if (komento.equals("peru")) {
            return;
        }
        io.print("\nSyötä kentät: ");

        io.print("citation key: ");
        String key = io.nextString();
        io.print("author: ");
        String author = io.nextString();
        io.print("title: ");
        String title = io.nextString();
        io.print("journal: ");
        String journal = io.nextString();
        io.print("year: ");
        int year = io.nextInt();
        io.print("volume: ");
        int volume = io.nextInt();
        io.print("number: ");
        int number = io.nextInt();
        io.print("pages: ");
        String pages = io.nextString();
        io.print("month: ");
        String month = io.nextString();
        io.print("note: ");
        String note = io.nextString();
        io.print("id: ");
        String id = io.nextString();

        Article a = new Article(id, author, title, journal, year, volume, number, pages, month, note, key);

        try {
            articleDAO.add(a);
            io.print("Artikkeli lisätty.");
        } catch (SQLException ex) {
            io.print("Lisäyt epäonnistui. SQLException");
        }

        
    }

    private void listaa() {
        try {
            for (Article article : articleDAO.findAll()) {
                io.print(article.toString());
            }
        } catch (SQLException ex) {
            io.print("VIRHE");
        }
    }
}
