package miniohtu.database;

import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.Book;

public class BookDAO implements EntryDAO<Book> {
    
    private Database db;
    
    public BookDAO(Database db) {
        this.db = db;
    }
    
    @Override
    public void add(Book entry) throws SQLException {
        String sql = "INSERT INTO BOOK"
                + "(ID, AUTHOR, TITLE, PUBLISHER, YEAR, VOLUME, SERIES, ADDRESS, EDITION, MONTH, NOTE, KEY) VALUES  ("
                + s(entry.getId()) + ", "
                + s(entry.getAuthor()) + ", "
                + s(entry.getTitle()) + ", "
                + s(entry.getPublisher()) + ", "
                + entry.getYear() + ", "
                + entry.getVolume() + ", "
                + s(entry.getSeries()) + ", "
                + s(entry.getAddress()) + ", "
                + entry.getEdition() + ", "
                + s(entry.getMonth()) + ","
                + s(entry.getNote()) + ", "
                + s(entry.getKey()) + ");";
        
        db.update(sql);
    }
    
    private String s(String s) {
        return "'" + s + "'";
    }
    
    @Override
    public List<Book> findAll() throws SQLException {
        return db.queryAndCollect("SELECT * FROM BOOK", rs -> {
            return new Book(
                rs.getString("id"),
                rs.getString("author"),
                rs.getString("title"),
                rs.getString("publisher"),
                rs.getInt("year"),
                rs.getInt("volume"),
                rs.getString("series"),
                rs.getString("address"),
                rs.getInt("edition"),
                rs.getString("month"),
                rs.getString("note"),
                rs.getString("key"));            
        });
    }
    
    @Override
    public Book find(String id) throws SQLException {
        List<Book> matches = db.queryAndCollect("SELECT * FROM ARTICLE WHERE ID='" + id + "'", rs -> {
            return new Book(
                rs.getString("id"),
                rs.getString("author"),
                rs.getString("title"),
                rs.getString("publisher"),
                rs.getInt("year"),
                rs.getInt("volume"),
                rs.getString("series"),
                rs.getString("address"),
                rs.getInt("edition"),
                rs.getString("month"),
                rs.getString("note"),
                rs.getString("key"));            
        });
        
        return matches.isEmpty() ? null : matches.get(0);
    }    
}
