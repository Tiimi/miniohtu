
package miniohtu.collectors;

import java.sql.ResultSet;
import java.sql.SQLException;
import miniohtu.entry.Conference;
import miniohtu.entry.EntryCreator;

public class ConferenceCollector implements Collector<Conference> {

    @Override
    public Object collect(ResultSet rs) throws SQLException {
        String citationKey  = rs.getString("citationKey");
        String author       = rs.getString("author");
        String title        = rs.getString("title");
        String bookTitle    = rs.getString("bookTitle");
        int year            = rs.getInt("year");
        
        String editor       = rs.getString("editor");
        String pages        = rs.getString("pages");
        String organization = rs.getString("organization");
        String publisher    = rs.getString("publisher");
        String address      = rs.getString("address");
        int month           = rs.getInt("month");
        String note         = rs.getString("note");
        String key          = rs.getString("key");
        
        return EntryCreator.conference(citationKey, author, title, bookTitle, year, 
                editor, pages, organization, publisher, address, month, note, key);
    }
}
