package miniohtu.database;

import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.Book;

public class BookDAO extends BaseDAO<Book> {
    
    public BookDAO(Database db) {
        super(db);
    }
    
    @Override
    public void add(Book entry) throws SQLException {
        String sql = "INSERT INTO BOOK"
                + "(CITATIONKEY, AUTHOR, TITLE, PUBLISHER, YEAR, VOLUME, SERIES, ADDRESS, EDITION, MONTH, NOTE, KEY) VALUES  ("
                + s(entry.getCitationKey()) + ", "
                + s(entry.getAuthor()) + ", "
                + s(entry.getTitle()) + ", "
                + s(entry.getPublisher()) + ", "
                + entry.getYear() + ", "
                + entry.getVolume() + ", "
                + entry.getSeries() + ", "
                + s(entry.getAddress()) + ", "
                + entry.getEdition() + ", "
                + entry.getMonth() + ","
                + s(entry.getNote()) + ", "
                + s(entry.getKey()) + ");";
        
        db.update(sql);
    }
    
    private String s(String s) {
        if (s == null) return null;
        return "'" + s + "'";
    }
    
    @Override
    public List<Book> findAll() throws SQLException {
        return db.queryAndCollect("SELECT * FROM BOOK", rs -> {
            return new Book(
                rs.getString("citationKey"),
                rs.getString("author"),
                rs.getString("title"),
                rs.getString("publisher"),
                rs.getInt("year"),
                rs.getInt("volume"),
                rs.getInt("series"),
                rs.getString("address"),
                rs.getInt("edition"),
                rs.getInt("month"),
                rs.getString("note"),
                rs.getString("key"));            
        });
    }
    
    @Override
    public Book find(String citationKey) throws SQLException {
        List<Book> matches = db.queryAndCollect("SELECT * FROM BOOK WHERE CITATIONKEY='" + citationKey + "'", rs -> {
            return new Book(
                rs.getString("citationKey"),
                rs.getString("author"),
                rs.getString("title"),
                rs.getString("publisher"),
                rs.getInt("year"),
                rs.getInt("volume"),
                rs.getInt("series"),
                rs.getString("address"),
                rs.getInt("edition"),
                rs.getInt("month"),
                rs.getString("note"),
                rs.getString("key"));            
        });
        
        return matches.isEmpty() ? null : matches.get(0);
    }
}
