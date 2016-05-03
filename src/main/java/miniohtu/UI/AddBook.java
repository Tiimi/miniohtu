/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.UI;

import java.sql.SQLException;
import miniohtu.IO.IO;
import miniohtu.database.BookDAO;
import miniohtu.entry.Book;

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
        Book b = new Book(askAllFields(Book.mandatoryFields, Book.optionalFields));
        try {      
            bookDAO.add(b);
        } catch (SQLException ex) {
            io.print("SQL EXCEPTION");
            io.print(ex.getMessage() + "\n");
        }
    }
    
}
