
package miniohtu.database;

import java.sql.SQLException;
import java.util.List;


abstract class BaseDAO<T> implements EntryDAO<T> {
    
    protected Database db;

    public BaseDAO(Database db) {
        this.db = db;
    }
    
    @Override
    public boolean remove(String citationKey, String tableName) throws SQLException {
        int updateCount = this.db.removeRowFromTable(tableName, citationKey);
        return (updateCount != 0);
    }
    @Override
    abstract public void add(T entry) throws SQLException;
    @Override
    abstract public List<T> findAll() throws SQLException;
    @Override
    abstract public T find(String citationKey) throws SQLException;
}
