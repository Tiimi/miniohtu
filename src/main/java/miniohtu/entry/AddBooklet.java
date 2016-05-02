/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.entry;

import java.sql.SQLException;
import miniohtu.IO.IO;
import miniohtu.database.BookletDAO;

/**
 *
 * @author leokallo
 */
public class AddBooklet extends AddOperation {
    private final BookletDAO bookletDAO;

    public AddBooklet(IO io, BookletDAO booklet) {
        super(io);
        this.bookletDAO = booklet;
    }

    @Override
    public void execute() {
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
    
}
