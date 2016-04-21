
package miniohtu.database;

import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.Booklet;

public class BookletDAO implements EntryDAO<Booklet> {
    private Database db;
    
    public BookletDAO(Database db) {
        this.db = db;
    }

    @Override
    public void add(Booklet entry) throws SQLException {
        String sql = "INSERT INTO BOOKLET"
                + "(ID, TITLE, AUTHOR, HOWPUBLISHED, ADDRESS, MONTH, YEAR, NOTE, KEY)"
                + s(entry.getId()) + ", "
                + s(entry.getTitle()) + ", "
                + s(entry.getAuthor()) + ", "
                + s(entry.getHowPublished()) + ", "
                + s(entry.getAddress()) + ", "
                + s(entry.getMonth()) + ", "
                + entry.getYear() + ", "
                + s(entry.getNote()) + ", "
                + s(entry.getKey()) + ");";
        
        db.update(sql);
    }
    
    private String s(String s) {
        return "'" + s + "'";
    }

    @Override
    public List<Booklet> findAll() throws SQLException {
        return db.queryAndCollect("SELECT * FROM BOOKLET", rs -> {
           return new Booklet(
                rs.getString("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("howPublished"),
                rs.getString("address"),
                rs.getString("month"),
                rs.getInt("year"),
                rs.getString("note"),
                rs.getString("key")); 
        });
    }

    @Override
    public Booklet find(String id) throws SQLException {
        List<Booklet> matches = db.queryAndCollect("SELECT * FROM BOOKLET WHERE ID='" + id + "'", rs -> {
           return new Booklet(
                rs.getString("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("howPublished"),
                rs.getString("address"),
                rs.getString("month"),
                rs.getInt("year"),
                rs.getString("note"),
                rs.getString("key"));  
        });
        
        return matches.isEmpty() ? null : matches.get(0);
    }
}
