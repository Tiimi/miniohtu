
package miniohtu.collectors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import miniohtu.entry.Article;

public class ArticleCollector implements Collector<Article> {

    @Override
    public Article collect(ResultSet rs) throws SQLException {
            Map<String,String> fields = new HashMap();
            fields.put("citation key",rs.getString("citationKey"));
            fields.put("author",rs.getString("author"));
            fields.put("title",rs.getString("title"));
            fields.put("journal",rs.getString("journal"));
            fields.put("year", rs.getInt("year") + "");
            fields.put("volume", rs.getInt("year") + "");
            fields.put("numbers", rs.getInt("year") + "");
            fields.put("pages", rs.getString("year"));
            fields.put("month", rs.getInt("year") + "");
            fields.put("year", rs.getInt("year") + "");
            fields.put("note", rs.getString("note"));
            return new Article(fields);
    }   
}
