
package miniohtu.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import miniohtu.entry.Article;

public class ArticleCollector implements Collector<Article> {

    @Override
    public Article collect(ResultSet rs) throws SQLException {
        String id       = rs.getString("id");
        String author   = rs.getString("author");
        String title    = rs.getString("title");
        String journal  = rs.getString("journal");
        int volume      = rs.getInt("volume");
        int number      = rs.getInt("number");
        int year        = rs.getInt("year");
        String pages    = rs.getString("pages");
        String month    = rs.getString("month");
        String note     = rs.getString("note");
        String key      = rs.getString("key");
        
        return new Article(id, author, title, journal, volume, number, year, pages, month, note, key);
    }
    
}
