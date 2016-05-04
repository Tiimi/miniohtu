
package miniohtu.UI;

import java.sql.SQLException;
import miniohtu.IO.IO;
import miniohtu.database.IncollectionDAO;
import miniohtu.entry.Incollection;

public class AddIncollection extends AddOperation {
    private final IncollectionDAO incollectionDAO;
    
    public AddIncollection(IO io, IncollectionDAO incollection) {
        super(io);
        this.incollectionDAO = incollection;
    }

    @Override
    public void execute() {
        Incollection i = new Incollection(askAllFields(Incollection.mandatoryFields, Incollection.optionalFields));
        
        try {
            incollectionDAO.add(i);
            io.print("Incollection lisätty.");
        } catch (SQLException ex) {
            io.print("Lisäys epäonnistui. SQLException: " + ex.getMessage());
        }
    }
    
}
