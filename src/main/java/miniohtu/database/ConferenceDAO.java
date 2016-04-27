
package miniohtu.database;

import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.Conference;

public class ConferenceDAO implements EntryDAO<Conference> {
    private Database db;
    
    public ConferenceDAO(Database db) {
        this.db = db;
    }
    
    @Override
    public void add(Conference entry) throws SQLException {
        String sql = "INSERT INTO CONFERENCE VALUES ("
                + s(entry.getCitationKey()) + ", "
                + s(entry.getAuthor()) + ", "
                + s(entry.getTitle()) + ", "
                + s(entry.getBookTitle()) + ", "
                + entry.getYear() + ", "
                + s(entry.getEditor()) + ", "
                + entry.getPages() + ", "
                + s(entry.getOrganization()) + ", "
                + s(entry.getPublisher()) + ", "
                + s(entry.getAddress()) + ", "
                + entry.getMonth() + ", "
                + s(entry.getNote()) + ", "
                + s(entry.getKey()) + " );";
        
        db.update(sql);
    }

    private String s(String s) {
        return "'" + s + "'";
    }
    
    @Override
    public List<Conference> findAll() throws SQLException {
        return db.queryAndCollect("SELECT * FROM CONFERENCE", rs -> {
           return new Conference(
                rs.getString("citationKey"),
                rs.getString("author"),
                rs.getString("title"),
                rs.getString("bookTitle"),
                rs.getInt("year"),
                rs.getString("editor"),
                rs.getInt("pages"),
                rs.getString("organization"),
                rs.getString("publisher"),
                rs.getString("address"),
                rs.getInt("month"),
                rs.getString("note"),
                rs.getString("key")); 
        });
    }

    @Override
    public Conference find(String citationKey) throws SQLException {
        List<Conference> matches = db.queryAndCollect("SELECT * FROM CONFERENCE WHERE CITATIONKEY='" + citationKey + "'", rs -> {
           return new Conference(
                rs.getString("citationKey"),
                rs.getString("author"),
                rs.getString("title"),
                rs.getString("bookTitle"),
                rs.getInt("year"),
                rs.getString("editor"),
                rs.getInt("pages"),
                rs.getString("organization"),
                rs.getString("publisher"),
                rs.getString("address"),
                rs.getInt("month"),
                rs.getString("note"),
                rs.getString("key")); 
        });
        
        return matches.isEmpty() ? null : matches.get(0);
    }
}
