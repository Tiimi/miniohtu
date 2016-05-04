/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.UI;

import java.util.HashMap;
import miniohtu.IO.IO;
import miniohtu.database.ArticleDAO;
import miniohtu.database.BookDAO;
import miniohtu.database.BookletDAO;
import miniohtu.database.ConferenceDAO;
import miniohtu.database.InbookDAO;
import miniohtu.database.IncollectionDAO;
import miniohtu.database.InproceedingsDAO;

/**
 *
 * @author leokallo
 */
public class CommandFactory {
    private final HashMap<String, Command> commands;
    private final IO io;
    
    public CommandFactory(IO io, ArticleDAO article, BookDAO book, BookletDAO booklet,
            ConferenceDAO conference, InbookDAO inbook, IncollectionDAO incollection, InproceedingsDAO inproceedings) {
        this.io = io;
        commands = new HashMap<>();
        commands.put("peru", new Cancel(io));
        commands.put("article", new AddArticle(io, article));
        commands.put("book", new AddBook(io, book));
        commands.put("booklet", new AddBooklet(io, booklet));
        commands.put("conference", new AddConference(io, conference));
        commands.put("inbook", new AddInbook(io, inbook));
        commands.put("incollection", new AddIncollection(io, incollection));
        commands.put("inproceedings", new AddInproceedings(io, inproceedings));
    }
    
    public Command get(String operation) {
        Command command = commands.get(operation);
        if (command == null) {
            commands.put("unknown", new Unknown(io, operation));
            command = commands.get("unknown");
        }        
        return command;
    }
    
}
