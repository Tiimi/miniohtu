package miniohtu.database;

import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.Article;

public class ArticleDAO implements EntryDAO<Article> {
    private Database db;

    public ArticleDAO(Database db) {
        this.db = db;
    }

    @Override
    public void add(Article entry) throws SQLException {
        String sql = "INSERT INTO ARTICLE"
                + "(CITATIONKEY, AUTHOR, TITLE, JOURNAL, YEAR, VOLUME) VALUES ("
                + s(entry.getCitationKey()) + ", "
                + s(entry.getAuthor()) + ", "
                + s(entry.getTitle()) + ", "
                + s(entry.getJournal()) + ", "
                + entry.getYear() + ", "
                + entry.getVolume() + " );";

        db.update(sql);
    }

    private String s(String s) {
        return "'" + s + "'";
    }

    @Override
    public List<Article> findAll() throws SQLException {
        return db.queryAndCollect("SELECT * FROM ARTICLE", rs -> {
            return new Article(
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
            return new Article(
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
}
