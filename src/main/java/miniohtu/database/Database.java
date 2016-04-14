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
                createArticleTable();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void createArticleTable() throws SQLException {
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

    public static void resetDB(String dbname) throws ClassNotFoundException {
        // load the sqlite-JDBC driver using the current class loader
        Connection connection = null;
        Class.forName("org.sqlite.JDBC");
        try {
            // create a database connection
            connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s", dbname));
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("DROP TABLE IF EXISTS article");
            statement.executeUpdate(
                    "CREATE TABLE article ("
                    + "id string,"
                    + "author string,"
                    + "title string,"
                    + "journal string,"
                    + "volume integer,"
                    + "number integer,"
                    + "year integer,"
                    + "pages string,"
                    + "publisher string,"
                    + "address string)"
            );
        } catch (SQLException e) {
            // if the error message is "out of memory", 
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }

}
