
package miniohtu.database;

import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.EntryCreator;
import miniohtu.entry.Inbook;

public class InbookDAO extends BaseDAO<Inbook> {
    
    public InbookDAO(Database db) {
        super(db);
    }
     
    @Override
    public void add(Inbook entry) throws SQLException {
        String sql = "INSERT INTO INBOOK VALUES ("
                + s(entry.getCitationKey()) + ", "
                + s(entry.getAuthor()) + ", "
                + s(entry.getTitle()) + ", "
                + entry.getChapter() + ", "
                + s(entry.getPublisher()) + ", "
                + entry.getYear() + ", "
                + entry.getVolume() + ", "
                + entry.getSeries() + ", "
                + s(entry.getAddress()) + ", "
                + entry.getEdition() + ", "
                + entry.getMonth() + ", "
                + s(entry.getNote()) + ", "
                + s(entry.getKey()) + " );";
        
        db.update(sql);
    }

    @Override
    public List<Inbook> findAll() throws SQLException {
        return db.queryAndCollect("SELECT * FROM INBOOK", rs -> {
           return EntryCreator.inbook(
                rs.getString("citationKey"),
                rs.getString("author"),
                rs.getString("title"),
                rs.getInt("chapter"),
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
    public Inbook find(String citationKey) throws SQLException {
        List<Inbook> matches = db.queryAndCollect("SELECT * FROM INBOOK WHERE CITATIONKEY='" + citationKey + "'", rs -> {
            return EntryCreator.inbook(
                rs.getString("citationKey"),
                rs.getString("author"),
                rs.getString("title"),
                rs.getInt("chapter"),
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
