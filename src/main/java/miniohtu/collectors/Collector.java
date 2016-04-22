
package miniohtu.collectors;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Collector<Entry> {
    Object collect(ResultSet rs) throws SQLException;
}
