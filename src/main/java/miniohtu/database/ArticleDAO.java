package miniohtu.database;

import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.Article;
import miniohtu.entry.EntryCreator;

public class ArticleDAO extends BaseDAO<Article> {

    public ArticleDAO(Database db) {
        super(db);
    }

    @Override
    public void add(Article entry) throws SQLException {
        String sql = "INSERT INTO ARTICLE"
                + "(CITATIONKEY, AUTHOR, TITLE, JOURNAL, YEAR, VOLUME, NUMBER, PAGES, MONTH, NOTE) VALUES ("
                + s(entry.getCitationKey()) + ", "
                + s(entry.getAuthor()) + ", "
                + s(entry.getTitle()) + ", "
                + s(entry.getJournal()) + ", "
                + entry.getYear() + ", "
                + entry.getVolume() + ", "
                + entry.getNumber() + ", "
                + s(entry.getPages()) + ", "
                + entry.getMonth() + ", "
                + s(entry.getNote())+ " );";

        db.update(sql);
    }

    private String s(String s) {
        if (s == null) return null;
        return "'" + s + "'";
    }

    @Override
    public List<Article> findAll() throws SQLException {
        return db.queryAndCollect("SELECT * FROM ARTICLE", rs -> {
            return EntryCreator.article(
                    rs.getString("citationKey"),
                    rs.getString("author"),
                    rs.getString("title"),
                    rs.getString("journal"),
                    rs.getInt("year"),
                    rs.getInt("volume"),
                    rs.getInt("number"),
                    rs.getString("pages"),
                    rs.getInt("month"),
                    rs.getString("note"));
        });
    }

    @Override
    public Article find(String citationKey) throws SQLException {
        List<Article> matches = db.queryAndCollect("SELECT * FROM ARTICLE WHERE CITATIONKEY='"+ citationKey + "'", rs -> {
            return EntryCreator.article(
                    rs.getString("citationKey"),
                    rs.getString("author"),
                    rs.getString("title"),
                    rs.getString("journal"),
                    rs.getInt("year"),
                    rs.getInt("volume"),
                    rs.getInt("number"),
                    rs.getString("pages"),
                    rs.getInt("month"),
                    rs.getString("note"));
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
