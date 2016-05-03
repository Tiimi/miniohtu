package miniohtu.collectors;

import miniohtu.collectors.Collector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import miniohtu.entry.Inproceedings;

public class InproceedingsCollector implements Collector<Inproceedings> {

    @Override
    public Inproceedings collect(ResultSet rs) throws SQLException {
            Map<String,String> fields = new HashMap();
            fields.put("citation key",rs.getString("citationKey"));
            fields.put("author",rs.getString("author"));
            fields.put("title",rs.getString("title"));
            fields.put("booktitle",rs.getString("booktitle"));
            fields.put("year", rs.getInt("year") + "");
            fields.put("editor", rs.getString("editor"));
            fields.put("pages", rs.getString("pages"));
            fields.put("organization", rs.getString("organization"));
            fields.put("publisher", rs.getString("publisher"));
            fields.put("address", rs.getString("address"));
            fields.put("month", rs.getInt("month") + "");
            fields.put("note", rs.getString("note"));
            fields.put("key", rs.getString("key"));
            return new Inproceedings(fields);
    }   
}
