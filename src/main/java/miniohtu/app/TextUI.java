package miniohtu.app;

import java.io.File;
import java.io.FileOutputStream;
import miniohtu.database.Database;
import miniohtu.entry.Article;
import miniohtu.database.ArticleDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import miniohtu.IO.IO;
import miniohtu.database.BookDAO;
import miniohtu.database.BookletDAO;
import miniohtu.database.ConferenceDAO;
import miniohtu.database.EntryDAO;
import miniohtu.database.InbookDAO;
import miniohtu.entry.BaseEntry;
import miniohtu.entry.Book;
import miniohtu.entry.Booklet;
import miniohtu.entry.Conference;
import miniohtu.entry.Inbook;

public class TextUI {

    private final String help = "Komennot\n lisaa\n listaa\n tallenna\nlopeta\n";
    private final String addHelp = "\nValitse lisättävä viite typpi:\n article\n book\n booklet\n conference\n inbook\n\n(peru peruu toiminnon)\n>";
    private final String wrongCommand = "Väärä komento: ";
    private final String mandatoryFields = "Syötä pakolliset kentät\n";
    private final String optionalFields = "\nSyötä valinnaiset kentät:\n";
    private final IO io;
    private final Database db;

    private final ArticleDAO articleDAO;
    private final BookDAO bookDAO;
    private final BookletDAO bookletDAO;
    private final ConferenceDAO conferenceDAO;
    private final InbookDAO inbookDAO;

    public TextUI(IO io, Database db) {
        this.io = io;
        this.db = db;
        this.articleDAO = new ArticleDAO(this.db);
        this.bookDAO = new BookDAO(this.db);
        this.bookletDAO = new BookletDAO(this.db);
        this.conferenceDAO = new ConferenceDAO(this.db);
        this.inbookDAO = new InbookDAO(this.db);
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
        } else if (komento.equals("conference")) {
            addConference();
        } else if (komento.equals("inbook")) {
            addInbook();
        } else {
            io.print("Viite tyyppiä: " + komento + " ei ole.\n\n");
        }

    }

    private void addArticle() {
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

    private void addBook() {
        io.print(mandatoryFields);
        String citationKey = askString("citation key");
        String author = askString("author");
        String title = askString("title");
        String publisher = askString("publisher");
        int year = askInteger("year");

        io.print("\nSyötä valinnaiset kentät:\n");
        int volume = askOptionalInteger("volume");
        int series = askOptionalInteger("series");
        String address = askOptionalString("address");
        int edition = askOptionalInteger("edition");
        int month = askOptionalInteger("month");
        String note = askOptionalString("note");
        String key = askOptionalString("key");

        try {
            Book b = new Book(citationKey, author, title, publisher, year, volume, series, address, edition, month, note, key);
            bookDAO.add(b);
        } catch (SQLException ex) {
            io.print("SQL EXCEPTION");
            io.print(ex.getMessage() + "\n");
        }
    }

    private void addBooklet() {
        io.print(mandatoryFields);
        String citationKey = askString("citation key");
        String title = askString("title");

        io.print("\nSyötä valinnaiset kentät:\n");
        String author = askOptionalString("author");
        String howPublished = askOptionalString("howPublished");
        String address = askOptionalString("address");
        int month = askOptionalInteger("month");
        int year = askOptionalInteger("year");
        String note = askOptionalString("note");
        String key = askOptionalString("key");

        Booklet booklet = new Booklet(citationKey, title, author, howPublished, address, month, year, note, key);
        try {
            bookletDAO.add(booklet);
        } catch (SQLException e) {
            io.print("SQL exception\n");
            io.print(e.getMessage() + "\n");
        }
    }
    
    private void addConference() {
        io.print(mandatoryFields);
        String citationKey = askString("citation key");
        String title = askString("title");
        String booktitle = askString("booktitle");
        int year = askInteger("year");
        
        io.print(optionalFields);
        String editor = askOptionalString("editor");
        int pages = askOptionalInteger("pages");
        String organization = askOptionalString("organization");
        String publisher = askOptionalString("publisher");
        String address = askOptionalString("address");
        int month = askOptionalInteger("month");
        String note = askOptionalString("note");
        String key = askOptionalString("key");
        
        Conference conference = new Conference(citationKey, editor, title, booktitle, year, editor, pages, organization, publisher, address, month, note, key);
        try {
            conferenceDAO.add(conference);
        } catch (SQLException ex) {
            io.print("Lisäys epäonnistui.");
        }
        
    }
    
    private void addInbook() {
        io.print(mandatoryFields);
        String citationKey = askString("citation key");
        String author = askString("author");
        String title = askString("title");
        int chapter = askInteger("chapter");
        String publisher = askString("publisher");
        int year = askInteger("year");
        
        io.print(optionalFields);
        int volume = askOptionalInteger("volume");
        int series = askOptionalInteger("series");
        String address = askOptionalString("addres");
        int edition = askOptionalInteger("edition");
        int month = askOptionalInteger("month");
        String note = askOptionalString("note");
        String key = askOptionalString("key");
        
        Inbook inbook = new Inbook(citationKey, author, title, chapter, publisher, year, volume, series, address, edition, month, note, key);
        
        try {
            inbookDAO.add(inbook);
        } catch (SQLException ex) {
            io.print("SQL exception\n");
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
                io.print("Virhe: anna kokonaisluku\n");
            }
        }

        return kokonaisluku;
    }

    private String askString(String kentanNimi) {
        io.print(kentanNimi + ": ");
        return io.nextString();
    }
    
    private String askOptionalString(String fieldValue) {
        String s = askString(fieldValue);
        if (s.isEmpty()) {
            return null;
        }
        return s;
    }
    
    private int askOptionalInteger(String fieldValue) {
        while(true) {
            String s = askOptionalString(fieldValue);
            if (s == null) {
                return Integer.MAX_VALUE;
            }
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                io.print("Virhe: anna kokonaisluku tai tyhjä.\n");
            }
        }        
    }

    private void list() {
        try {
            io.print("ARTICLES:\n\n");
            for (Article article : articleDAO.findAll()) {
                io.print(article.toString() + "\n");
            }

            io.print("BOOKS:\n\n");
            for (Book book : bookDAO.findAll()) {
                io.print(book.toString() + "\n");
            }

            io.print("BOOKLET:\n\n");
            for (Booklet booklet : bookletDAO.findAll()) {
                io.print(booklet.toString() + "\n");
            }
            io.print("CONFERENCE:\n\n");
            for (Conference conf : conferenceDAO.findAll()) {
                io.print(conf.toString() + "\n");
            }
            io.print("INBOOK:\n\n");
            for (Inbook inbook : inbookDAO.findAll()) {
                io.print(inbook.toString() + "\n");
            }

        } catch (SQLException ex) {
            io.print("SQL VIRHE");
        }
        io.print("\n");
    }

    private void save() {
        io.print("Anna polku tiedostoon (esim. /home/pentti/tiedostonnimi.tex)\n");
        String polku = askString("polku");
        String s = "";
        List<EntryDAO> entryDAOs = new ArrayList<>();
        entryDAOs.add(articleDAO);
        entryDAOs.add(bookDAO);
        entryDAOs.add(bookletDAO);
        entryDAOs.add(conferenceDAO);
        entryDAOs.add(inbookDAO);
        for (EntryDAO entryDAO : entryDAOs) {
            try {
                List<BaseEntry> entries = entryDAO.findAll();
                for (BaseEntry entry : entries) {
                    s += entry.toBibtex();
                    s += "\n\n";
                }
            } catch (SQLException e) {
                io.print("Tallennus epäonistui.\n" + e.getMessage() + "\n");
            }
        }
        try {
            FileOutputStream outStream = new FileOutputStream(new File(polku));
            outStream.write(s.getBytes());
            outStream.flush();
            outStream.close();
        } catch (Exception e) {
            io.print("Tallennus epäonnistui. Tarkista polku");
        }
    }
}
