
package miniohtu.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import miniohtu.entry.Booklet;

public class BookletCollector implements Collector<Booklet> {

    @Override
    public Object collect(ResultSet rs) throws SQLException {
        String id           = rs.getString("id");
        String title        = rs.getString("title");
        
        String author       = rs.getString("author");
        String howPublished = rs.getString("howPublished");
        String address      = rs.getString("address");
        int month           = rs.getInt("month");
        int year            = rs.getInt("year");
        String note         = rs.getString("note");
        String key          = rs.getString("key");
        
        return new Booklet(id, title, author, howPublished, address, month, year, note, key);
    }
}
