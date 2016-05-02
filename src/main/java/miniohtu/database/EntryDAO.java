
package miniohtu.database;

import java.sql.SQLException;
import java.util.List;

public interface EntryDAO<BaseEntry> {
    void add(BaseEntry entry) throws SQLException;
    List<BaseEntry> findAll() throws SQLException;
    BaseEntry find(String citationKey) throws SQLException;
    boolean remove(String citationKey, String tableName) throws SQLException;
}
