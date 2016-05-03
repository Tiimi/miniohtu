
package miniohtu.database;

import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.Booklet;
import miniohtu.entry.EntryCreator;

public class BookletDAO extends BaseDAO<Booklet> {
    
    public BookletDAO(Database db) {
        super(db);
    }

    @Override
    public void add(Booklet entry) throws SQLException {
        String sql = "INSERT INTO BOOKLET"
                + "(CITATIONKEY, TITLE, AUTHOR, HOWPUBLISHED, ADDRESS, MONTH, YEAR, NOTE, KEY) VALUES ("
                + s(entry.getCitationKey()) + ", "
                + s(entry.getTitle()) + ", "
                + s(entry.getAuthor()) + ", "
                + s(entry.getHowPublished()) + ", "
                + s(entry.getAddress()) + ", "
                + entry.getMonth() + ", "
                + entry.getYear() + ", "
                + s(entry.getNote()) + ", "
                + s(entry.getKey()) + ");";
        
        db.update(sql);
    }
    
    private String s(String s) {
        if (s == null) return null;
        return "'" + s + "'";
    }

    @Override
    public List<Booklet> findAll() throws SQLException {
        return db.queryAndCollect("SELECT * FROM BOOKLET", rs -> {
           return EntryCreator.booklet(
                rs.getString("citationKey"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("howPublished"),
                rs.getString("address"),
                rs.getInt("month"),
                rs.getInt("year"),
                rs.getString("note"),
                rs.getString("key")); 
        });
    }

    @Override
    public Booklet find(String citationKey) throws SQLException {
        List<Booklet> matches = db.queryAndCollect("SELECT * FROM BOOKLET WHERE CITATIONKEY='" + citationKey + "'", rs -> {
           return EntryCreator.booklet(
                rs.getString("citationKey"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("howPublished"),
                rs.getString("address"),
                rs.getInt("month"),
                rs.getInt("year"),
                rs.getString("note"),
                rs.getString("key"));  
        });
        
        return matches.isEmpty() ? null : matches.get(0);
    }
}
