/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.UI;

import java.sql.SQLException;
import miniohtu.IO.IO;
import miniohtu.database.BookletDAO;
import miniohtu.entry.Booklet;

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
        
        Booklet booklet = new Booklet(askAllFields(Booklet.mandatoryFields, Booklet.optionalFields));
        try {
            bookletDAO.add(booklet);
        } catch (SQLException e) {
            io.print("SQL exception\n");
            io.print(e.getMessage() + "\n");
        }
    }
    
}
