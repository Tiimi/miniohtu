/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.entry;

import java.sql.SQLException;
import miniohtu.IO.IO;
import miniohtu.database.BookDAO;

/**
 *
 * @author leokallo
 */
public class AddBook extends AddOperation {
    
    private final BookDAO bookDAO;

    public AddBook(IO io, BookDAO book) {
        super(io);
        this.bookDAO = book;
    }

    @Override
    public void execute() {
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
    
}
