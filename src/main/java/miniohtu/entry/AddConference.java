/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.entry;

import java.sql.SQLException;
import miniohtu.IO.IO;
import miniohtu.database.ConferenceDAO;

/**
 *
 * @author leokallo
 */
public class AddConference extends AddOperation {
    private final ConferenceDAO conferenceDAO;

    public AddConference(IO io, ConferenceDAO conference) {
        super(io);
        this.conferenceDAO = conference;
    }

    @Override
    public void execute() {
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
            conferenceDAO.add(conference);
        } catch (SQLException ex) {
            io.print("Lisäys epäonnistui.");
        }
    }
    
}
