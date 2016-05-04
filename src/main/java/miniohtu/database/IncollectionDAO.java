
package miniohtu.database;

import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.EntryCreator;
import miniohtu.entry.Incollection;

public class IncollectionDAO extends BaseDAO<Incollection> {

    public IncollectionDAO(Database db) {
        super(db);
    }

    @Override
    public void add(Incollection entry) throws SQLException {
        String sql = "INSERT INTO INCOLLECTION VALUES ("
                + s(entry.getCitationKey()) + ", "
                + s(entry.getAuthor()) + ", "
                + s(entry.getTitle()) + ", "
                + s(entry.getBookTitle()) + ", "
                + entry.getYear() + ", "
                + s(entry.getEditor()) + ", "
                + s(entry.getPages()) + ", "
                + s(entry.getOrganization()) + ", "
                + s(entry.getPublisher()) + ", "
                + s(entry.getAddress()) + ", "
                + entry.getMonth() + ", "
                + s(entry.getNote()) + ", "
                + s(entry.getKey()) + ");";
        
        db.update(sql);
    }

    @Override
    public List<Incollection> findAll() throws SQLException {
        return db.queryAndCollect("SELECT * FROM INCOLLECTION", rs -> {
           return EntryCreator.incollection(
                   rs.getString("citationKey"),
                   rs.getString("author"),
                   rs.getString("title"),
                   rs.getString("bookTitle"),
                   rs.getInt("year"),
                   rs.getString("editor"),
                   rs.getString("pages"),
                   rs.getString("organization"),
                   rs.getString("publisher"),
                   rs.getString("address"),
                   rs.getInt("month"),
                   rs.getString("note"),
                   rs.getString("key"));
        });
    }

    @Override
    public Incollection find(String citationKey) throws SQLException {
        List<Incollection> matches = db.queryAndCollect("SELECT * FROM INCOLLECTION WHERE CITATIONKEY='" + citationKey + "'", rs -> {
           return EntryCreator.incollection(
                   rs.getString("citationKey"),
                   rs.getString("author"),
                   rs.getString("title"),
                   rs.getString("bookTitle"),
                   rs.getInt("year"),
                   rs.getString("editor"),
                   rs.getString("pages"),
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
