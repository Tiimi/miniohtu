package miniohtu.app;

import miniohtu.IO.IO;
import miniohtu.database.*;
import miniohtu.entry.*;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextUI {

    private final String help = "Komennot\n lisaa\n poista\n listaa\n tallenna\nlopeta\n";
    private final String addHelp = "\nValitse lisättävä viite typpi:\n article\n book\n booklet\n conference\n inbook\n\n(peru peruu toiminnon)\n>";
    private final String wrongCommand = "Väärä komento: ";
    private final String mandatoryFields = "Syötä pakolliset kentät\n";
    private final String optionalFields = "\nSyötä valinnaiset kentät:\n";
    private final IO io;
    private final Database db;
    private Map<String, EntryDAO> entryDAOs;
    private Map<String, Command> basicCommands;
    private Map<String, Command> addCommands;

    public TextUI(IO io, Database db) {
        this.io = io;
        this.db = db;
        this.entryDAOs = new HashMap<>();
        initDAOs();
        initCommands();
    }

    private void initDAOs() {
        entryDAOs.put("article", new ArticleDAO(this.db));
        entryDAOs.put("book", new BookDAO(this.db));
        entryDAOs.put("booklet", new BookletDAO(this.db));
        entryDAOs.put("conference", new ConferenceDAO(this.db));
        entryDAOs.put("inbook", new InbookDAO(this.db));
    }

    private void initCommands() {
        this.basicCommands = new HashMap<>();
        basicCommands.put("lisaa", this::add);
        basicCommands.put("listaa", this::list);
        basicCommands.put("tallenna", this::save);
        basicCommands.put("poista", this::remove);

        this.addCommands = new HashMap<>();
        addCommands.put("article", this::addArticle);
        addCommands.put("book", this::addBook);
        addCommands.put("booklet", this::addBooklet);
        addCommands.put("conference", this::addConference);
        addCommands.put("inbook", this::addInbook);
    }

    public void run() throws SQLException {

        while (true) {
            io.print(help);
            io.print("> ");
            String komento = io.nextString();
            if (komento.equals("lopeta")) {
                break;
            }
            try {
                this.basicCommands.get(komento).run();
            } catch (Exception e) {
                io.print(wrongCommand + komento + "\n");
            }
        }
    }

    public void remove() {
        io.print(addHelp);
        String komento = io.nextString();
        if (komento.equals("peru"))
            return;

        io.print("Anna poistettavan viitteen citation key\n> ");
        String citationKey = io.nextString();
        try {
            if (!entryDAOs.get("article").remove(citationKey, komento)) {
                io.print("Viitettä " + citationKey + " ei ole.\n\n");
            } else {
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
        try {
            addCommands.get(komento).run();
        } catch (Exception e) {
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
            ((ArticleDAO) entryDAOs.get("article")).add(a);
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
            ((BookDAO) entryDAOs.get("book")).add(b);
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
            ((BookletDAO) entryDAOs.get("booklet")).add(booklet);
        } catch (SQLException e) {
            io.print("SQL exception\n");
            io.print(e.getMessage() + "\n");
        }
    }

    private void addConference() {
        io.print(mandatoryFields);
        String citationKey = askString("citation key");
        String author = askString("author");
        String title = askString("title");
        String booktitle = askString("booktitle");
        int year = askInteger("year");

        io.print(optionalFields);
        String editor = askOptionalString("editor");
        String pages = askOptionalString("pages");
        String organization = askOptionalString("organization");
        String publisher = askOptionalString("publisher");
        String address = askOptionalString("address");
        int month = askOptionalInteger("month");
        String note = askOptionalString("note");
        String key = askOptionalString("key");

        Conference conference = new Conference(citationKey, author, title, booktitle, year, editor, pages, organization, publisher, address, month, note, key);
        try {
            ((ConferenceDAO) entryDAOs.get("conference")).add(conference);
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
            ((InbookDAO) entryDAOs.get("inbook")).add(inbook);
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
        if (s.isEmpty() || s.equals("")) {
            return null;
        }
        return s;
    }

    private int askOptionalInteger(String fieldValue) {
        while (true) {
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
            for (String name : entryDAOs.keySet()) {
                io.print(name.toUpperCase()+":\n\n");
                List<BaseEntry> list = entryDAOs.get(name).findAll();
                for (BaseEntry entry : list) {
                    io.print(entry.toString() + "\n");
                }
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
        for (EntryDAO entryDAO : entryDAOs.values()) {
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
