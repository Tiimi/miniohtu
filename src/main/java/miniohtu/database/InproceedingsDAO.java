package miniohtu.database;

import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.Inproceedings;
import miniohtu.entry.EntryCreator;

public class InproceedingsDAO extends BaseDAO<Inproceedings> {

    public InproceedingsDAO(Database db) {
        super(db);
    }

    @Override
    public void add(Inproceedings entry) throws SQLException {
        String sql = "INSERT INTO INPROCEEDINGS"
                + "(CITATIONKEY, AUTHOR, TITLE, BOOKTITLE, YEAR, EDITOR, PAGES, ORGANIZATION, PUBLISHER, ADDRESS, MONTH, NOTE, KEY) VALUES ("
                + s(entry.getCitationKey()) + ", "
                + s(entry.getAuthor()) + ", "
                + s(entry.getTitle()) + ", "
                + s(entry.getBooktitle()) + ", "
                + entry.getYear() + ", "
                + s(entry.getEditor()) + ", "
                + s(entry.getPages()) + ", "
                + s(entry.getOrganization()) + ", "
                + s(entry.getPublisher()) + ", "
                + s(entry.getAddress()) + ", "
                + entry.getMonth() + ", "
                + s(entry.getNote()) + ", "
                + s(entry.getKey()) + " );";

        db.update(sql);
    }

    private String s(String s) {
        if (s == null) {
            return null;
        }
        return "'" + s + "'";
    }

    @Override
    public List<Inproceedings> findAll() throws SQLException {
        return db.queryAndCollect("SELECT * FROM INPROCEEDINGS", rs -> {
            return EntryCreator.inproceedings(
                    rs.getString("citationKey"),
                    rs.getString("author"),
                    rs.getString("title"),
                    rs.getString("booktitle"),
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
    public Inproceedings find(String citationKey) throws SQLException {
        List<Inproceedings> matches = db.queryAndCollect("SELECT * FROM INPROCEEDINGS WHERE CITATIONKEY='" + citationKey + "'", rs -> {
            return EntryCreator.inproceedings(
                    rs.getString("citationKey"),
                    rs.getString("author"),
                    rs.getString("title"),
                    rs.getString("booktitle"),
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

    private String checkNull(String s) {
        if (s.equals("null")) {
            return null;
        }
        return s;
    }
}
