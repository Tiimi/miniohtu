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
import miniohtu.database.BookletDAO;
import miniohtu.entry.Book;
import miniohtu.entry.Booklet;

public class TextUI {

    private final String help = "Komennot\n lisaa\n listaa\n tallenna\nlopeta\n";
    private final String addHelp = "\nValitse lisättävä viite typpi:\n article\n book\n booklet\n\n(peru peruu toiminnon)\n>";
    private final String wrongCommand = "Väärä komento: ";
    private final IO io;
    private final Database db;

    private final ArticleDAO articleDAO;
    private final BookDAO bookDAO;
    private final BookletDAO bookletDAO;

    public TextUI(IO io, Database db) {
        this.io = io;
        this.db = db;
        this.articleDAO = new ArticleDAO(this.db);
        this.bookDAO = new BookDAO(this.db);
        this.bookletDAO = new BookletDAO(this.db);   
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
        } else if (komento.equals("article")) {
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
        int month = askInteger("month");
        String note = askString("note");

        Article a = new Article(key, author, title, journal, year, volume, number, pages, month, note);

        try {
            articleDAO.add(a);
            io.print("Artikkeli lisätty.");
        } catch (SQLException ex) {
            io.print("Lisäys epäonnistui. SQLException");
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
    
    private void addBooklet()  {
        io.print("Syötä pakolliset kentät:\n");
        String key = askString("citation key");
        String title = askString("title");
        
        io.print("\nSyötä valinnaiset kentät:\n");
        String author = askString("author");
        String howpublished = askString("howpublished");
        String address = askString("address");
        String month = askString("month");
        int year = askInteger("year");
        String note = askString("note");
        
        Booklet booklet = new Booklet(key,title, author, howpublished, address, month, year, note, key);
        try {
        bookletDAO.add(booklet);
        } catch (SQLException e) {
            io.print("SQL exception\n");
            io.print(e.getMessage() + "\n");
        }
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
                try {
            io.print("BOOKLET:\n\n");
            for (Booklet booklet : bookletDAO.findAll()) {
                io.print(booklet.toString() + "\n");
            }
        } catch (SQLException ex) {
            io.print("SQL VIRHE");
        }
        io.print("\n");
    }

    private void save() {

    }
}
