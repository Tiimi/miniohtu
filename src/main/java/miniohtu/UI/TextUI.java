package miniohtu.UI;

import java.io.File;
import java.io.FileOutputStream;
import miniohtu.database.Database;
import miniohtu.entry.Article;
import miniohtu.database.ArticleDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    private final String help = "Komennot\n lisaa\n poista\n listaa\n tallenna\nlopeta\n";
    private final String addHelp = "\nValitse lisättävä viite typpi:\n article\n book\n booklet\n conference\n inbook\n\n(peru peruu toiminnon)\n>";
    private final String wrongCommand = "Väärä komento: ";
    private final IO io;
    private final Database db;

    private final ArticleDAO articleDAO;
    private final BookDAO bookDAO;
    private final BookletDAO bookletDAO;
    private final ConferenceDAO conferenceDAO;
    private final InbookDAO inbookDAO;
    
    private final CommandFactory commandfactory;

    public TextUI(IO io, Database db) {
        this.io = io;
        this.db = db;
        this.articleDAO = new ArticleDAO(this.db);
        this.bookDAO = new BookDAO(this.db);
        this.bookletDAO = new BookletDAO(this.db);
        this.conferenceDAO = new ConferenceDAO(this.db);
        this.inbookDAO = new InbookDAO(this.db);
        this.commandfactory = new CommandFactory(io, articleDAO, bookDAO, bookletDAO, 
                conferenceDAO, inbookDAO);
    }

    public void run() throws SQLException {

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

    public void runCommand(String komento) throws SQLException {
        if (komento.equals("lisaa")) {
            add();
        } else if (komento.equals("listaa")) {
            list();
        } else if (komento.equals("tallenna")) {
            save();
        } else if (komento.equals("poista")) {
            remove();
        } else {
            io.print(wrongCommand + komento + "\n");
        }

    }

    public void remove() throws SQLException {
        io.print(addHelp);
        String komento = io.nextString();
        if (komento.equals("peru"))
            return;
        
        io.print("Anna poistettavan viitteen citation key\n> ");
        String citationKey = io.nextString();
        try {
            if (!articleDAO.remove(citationKey, komento)) {
                io.print("Viitettä " + citationKey + " ei ole.\n\n");
            }else {
                io.print("Viite " + citationKey + " poistettiin.\n\n");
            }
        } catch (SQLException ex) {
            io.print("Viitetyyppiä " + komento + " ei ole.\n\n");
            io.print("Error: " + ex.getMessage() + "\n\n");  
        }

    }
    
    public void add() {
        io.print(addHelp);
        String komento = io.nextString();
        commandfactory.get(komento).execute();
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
    
    private String askString(String kentanNimi) {
        io.print(kentanNimi + ": ");
        return io.nextString();
    }
}
