
package miniohtu.collectors;

import miniohtu.collectors.Collector;
import java.sql.ResultSet;
import java.sql.SQLException;
import miniohtu.entry.Article;

public class ArticleCollector implements Collector<Article> {

    @Override
    public Article collect(ResultSet rs) throws SQLException {
        String citationKey  = rs.getString("citationKey");
        String author       = rs.getString("author");
        String title        = rs.getString("title");
        String journal      = rs.getString("journal");
        int volume          = rs.getInt("volume");
        int number          = rs.getInt("number");
        int year            = rs.getInt("year");
        String pages        = rs.getString("pages");
        int month           = rs.getInt("month");
        String note         = rs.getString("note");
        
        return new Article(citationKey, author, title, journal, volume, number, year, pages, month, note);
    }   
}
