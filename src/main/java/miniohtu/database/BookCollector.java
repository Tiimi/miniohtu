
package miniohtu.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import miniohtu.entry.Book;

public class BookCollector implements Collector<Book> {

    @Override
    public Object collect(ResultSet rs) throws SQLException {
        String citationKey  = rs.getString("citationKey");
        String author       = rs.getString("author");
        String title        = rs.getString("title");
        String publisher      = rs.getString("publisher");
        int year            = rs.getInt("year");
        int volume          = rs.getInt("volume");
        
        int series          = rs.getInt("series");
        String address      = rs.getString("address");
        int edition         = rs.getInt("edition");
        int month        = rs.getInt("month");
        String note         = rs.getString("note");
        String key          = rs.getString("key");
        
        return new Book(citationKey, author, title, author, year, volume, series, address, edition, month, note, key);
    }
}
