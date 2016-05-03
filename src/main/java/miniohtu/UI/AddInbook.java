/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.UI;

import java.sql.SQLException;
import miniohtu.IO.IO;
import miniohtu.database.InbookDAO;
import miniohtu.entry.Inbook;

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

        Inbook inbook = new Inbook(askAllFields(Inbook.mandatoryFields,Inbook.optionalFields));
        
        try {
            inbookDAO.add(inbook);
        } catch (SQLException ex) {
            io.print("SQL exception\n");
        }
    }
    
}
