/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.Article;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antti
 */
public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void createArticleTest() throws SQLException {

    }
    
    @Test
    public void articleIsAdded() throws SQLException, ClassNotFoundException {
        String dbName = "/tmp/unit_test.db";
        Database db = new Database(dbName);
        ArticleDAO articleDAO = new ArticleDAO(db);
        
        Article expected = new Article("JokuID", "Tekijä", "Titteli", "Journaali", 2001, 1);      
        articleDAO.add(expected);
        List<Article> articles = articleDAO.findAll();
        assertEquals(1, articles.size());
        Article result = articles.get(0);
        assertEquals("JokuID",result.getId());
        assertEquals("Tekijä",result.getAuthor());
        assertEquals("Journaali",result.getJournal());
        assertEquals(2001,result.getYear());
        assertEquals(1,result.getVolume());
        new File(dbName).delete();
    }
}
