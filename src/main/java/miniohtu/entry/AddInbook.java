/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.entry;

import java.sql.SQLException;
import miniohtu.IO.IO;
import miniohtu.database.InbookDAO;

/**
 *
 * @author leokallo
 */
public class AddInbook extends AddOperation {
    private final InbookDAO inbookDAO;

    public AddInbook(IO io, InbookDAO inbook) {
        super(io);
        this.inbookDAO = inbook;
    }

    @Override
    public void execute() {
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
    
}
