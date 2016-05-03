package miniohtu.UI;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import miniohtu.IO.IO;
import miniohtu.database.InproceedingsDAO;
import miniohtu.entry.Inproceedings;

public class AddInproceedings extends AddOperation {
    private final InproceedingsDAO inproceedingsDAO;
    
    

    public AddInproceedings(IO io, InproceedingsDAO inproceedings) {
        super(io);
        this.inproceedingsDAO = inproceedings;
    }

    @Override
    public void execute() {
        Inproceedings a = new Inproceedings(askAllFields(Inproceedings.mandatoryFields, Inproceedings.optionalFields));

        try {
            inproceedingsDAO.add(a);
            io.print("Inproceedings lisätty.");
        } catch (SQLException ex) {
            io.print("Lisäys epäonnistui. SQLException");
            io.print(ex.getMessage());
        }
    }
    
}
