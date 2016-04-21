package miniohtu.database;

import miniohtu.database.Collector;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database<Entry> {

    private Connection connection;

    public Database(String name) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + name);
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet result = metaData.getTables(null, null, "ARTICLE", null);
            if (result.next()) {
            } else {
                createTables();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void createTables() throws SQLException {
        createArticleTable();
        createBookTable();
        createBookletTable();
    }
    
    private void createArticleTable() throws SQLException {
        Statement statement = connection.createStatement();
        //statement.executeUpdate("DROP TABLE IF EXISTS ARTICLE");

        String sql = "CREATE TABLE ARTICLE ("
                + "id       STRING  NOT NULL,"
                + "author   STRING  NOT NULL,"
                + "title    STRING  NOT NULL,"
                + "journal  STRING  NOT NULL,"
                + "year     INTEGER NOT NULL,"
                + "volume   INTEGER NOT NULL,"
                + "number   INTEGER,"
                + "pages    STRING,"
                + "month    STRING,"
                + "note     STRING,"
                + "key      STRING )";

        statement.execute(sql);
        statement.close();
    }
    
    private void createBookTable() throws SQLException {
        Statement statement = connection.createStatement();
        
        String sql = "CREATE TABLE BOOK ("
                + "id       STRING  NOT NULL,"
                + "author   STRING  NOT NULL,"
                + "title    STRING  NOT NULL,"
                + "publisher  STRING  NOT NULL,"
                + "year     INTEGER NOT NULL,"
                + "volume   INTEGER,"
                + "series   STRING,"
                + "address  STRING,"
                + "edition  INTEGER,"
                + "month    STRING,"
                + "note     STRING,"
                + "key      STRING )";
        
        statement.execute(sql);
        statement.close();
    }
    
    private void createBookletTable() throws SQLException {
        Statement statement = connection.createStatement();
        
        String sql = "CREATE TABLE BOOKLET ("
                + "id           STRING  NOT NULL,"
                + "title        STRING  NOT NULL,"
                + "author       STRING,"
                + "howpublished STRING,"
                + "address      STRING,"
                + "month        STRING,"
                + "year         INTEGER,"
                + "note         STRING,"
                + "key          STRING )";      
        statement.execute(sql);
        statement.close();
    }

    public List<Entry> queryAndCollect(String query, Collector<Entry> col) throws SQLException {
        List<Entry> rows = new ArrayList();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            rows.add((Entry) col.collect(rs));
        }

        rs.close();
        statement.close();

        return rows;
    }

    public void update(String sql) throws SQLException {
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        connection.commit();
    }
}
