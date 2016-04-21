package miniohtu.app;

import miniohtu.database.Database;
import miniohtu.entry.Article;
import miniohtu.database.ArticleDAO;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import miniohtu.IO.IO;
import miniohtu.database.BookDAO;
import miniohtu.entry.Book;

public class TextUI {

    private final String help = "Komennot\n lisaa\n listaa\n tallenna\nlopeta\n";
    private final String addHelp = "\nValitse lisättävä viite typpi:\n article\n book\n booklet\n\n(peru peruu toiminnon)\n>";
    private final String wrongCommand = "Väärä komento: ";
    private final IO io;
    private final Database db;

    private final ArticleDAO articleDAO;
    private final BookDAO bookDAO;

    public TextUI(IO io, Database db) {
        this.io = io;
        this.db = db;
        this.articleDAO = new ArticleDAO(this.db);
        this.bookDAO = new BookDAO(this.db);
    }

    public void run() {
        
        while (true) {
            io.print(help);
            io.print("> ");
            String komento = io.nextString();
            if (komento.equals("lopeta")) {
                break;
            }
            runCommand(komento);
        }
    }

    public void runCommand(String komento) {
        if (komento.equals("lisaa")) {
            add();
        } else if (komento.equals("listaa")) {
            list();
        } else if (komento.equals("tallenna")) {
            save();
        } else {
            io.print(wrongCommand + komento + "\n");
        }

    }

    public void add() {
        io.print(addHelp);
        String komento = io.nextString();
        if (komento.equals("peru")) {
            return;
        } else if (komento.equals("artikkeli")) {
            addArticle();
        } else if (komento.equals("book")) {
            addBook();
        } else if (komento.equals("booklet")) {
            addBooklet();
        } else {
            io.print("Viite tyyppiä: " + komento + "\n\n");
        }

    }

    private void addArticle() {
        io.print("Syötä pakolliset kentät:\n");

        String key = askString("citation key");
        String author = askString("author");
        String title = askString("title");
        String journal = askString("journal");
        int year = askInteger("year");
        
        io.print("\nSyötä valinnaiset kentät:\n");
        int volume = askInteger("volume");
        int number = askInteger("number");
        String pages = askString("pages");
        String month = askString("month");
        String note = askString("note");

        Article a = new Article(key, author, title, journal, year, volume, number, pages, month, note);

        try {
            articleDAO.add(a);
            io.print("Artikkeli lisätty.");
        } catch (SQLException ex) {
            io.print("Lisäyt epäonnistui. SQLException");
            io.print(ex.getMessage());
        }
    }

    private void addBook() {
            io.print("Syötä pakolliset kentät:\n");
            String citKey = askString("citation key");
            String author = askString("author");
            String title = askString("title");
            String publisher = askString("publisher");
            int year = askInteger("year");
            
            io.print("\nSyötä valinnaiset kentät:\n");
            int volume = askInteger("volume");
            String series = askString("series");
            String address = askString("address");
            int edition = askInteger("edition");
            String month = askString("month");
            String note = askString("note");
            String ISBN = askString("isbn");
            
            try {
            Book b = new Book(citKey, author, title, publisher, year, volume, series, address, edition, month, note, null);
            bookDAO.add(b);
        } catch (SQLException ex) {
            io.print("SQL EXCEPTION");
            io.print(ex.getMessage() + "\n");
        }
    }
    
    private void addBooklet() {
        io.print("Syötä pakolliset kentät:\n");
        String key = askString("citation key");
        String title = askString("title");
        
        io.print("\nSyötä valinnaiset kentät:\n");
        String author = askString("author");
        String howpublished = askString("howpublished");
        int month = askInteger("month");
        int year = askInteger("year");
        String note = askString("note");
    }

    private int askInteger(String kentanNimi) {
        int kokonaisluku = 0;
        while (true) {
            io.print(kentanNimi + ": ");
            try {
                kokonaisluku = io.nextInt();
                break;
            } catch (NumberFormatException e) {
                io.print("Virhe: anna kokonaisluku");
            }
        }

        return kokonaisluku;
    }

    private String askString(String kentanNimi) {
        io.print(kentanNimi + ": ");
        return io.nextString();
    }

    private void list() {
        try {
            io.print("ARTICLES:\n\n");
            for (Article article : articleDAO.findAll()) {
                io.print(article.toString() + "\n");
            }
        } catch (SQLException ex) {
            io.print("SQL VIRHE");
        }
        try {
            io.print("BOOKS:\n\n");
            for (Book book : bookDAO.findAll()) {
                io.print(book.toString() + "\n");
            }
        } catch (SQLException ex) {
            io.print("SQL VIRHE");
        }
        io.print("\n");
    }

    private void save() {

    }
}
