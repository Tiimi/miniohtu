/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.UI;

import java.sql.SQLException;
import miniohtu.IO.IO;
import miniohtu.database.ConferenceDAO;
import miniohtu.entry.Conference;

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
        
        
        Conference conference = new Conference(askAllFields(Conference.mandatoryFields, Conference.optionalFields));
        try {
            conferenceDAO.add(conference);
        } catch (SQLException ex) {
            io.print("Lisäys epäonnistui.");
        }
    }
    
}
