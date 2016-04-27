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
        
        Article expected = new Article("JokuID", "Tekijä", "Titteli", "Journaali", 2001);      
        articleDAO.add(expected);
        List<Article> articles = articleDAO.findAll();
        assertEquals(1, articles.size());
        articleEqualsForMandatoryFields(expected,articles.get(0));
        new File(dbName).delete();
    }
    
    @Test
    public void resetDBTest() throws SQLException {
        String dbName = "/tmp/unit_test1.db";
        Database db = new Database(dbName);
        ArticleDAO articleDAO = new ArticleDAO(db);
        
        //Add an article to db.
        Article newArticle = new Article("asd", "asdAuthor", "asdTitle", "asdJournal", 9001);
        articleDAO.add(newArticle);
        
        //One Article should be found:
        List<Article> articles = articleDAO.findAll();
        Article foundArticle = articles.get(0);
        articleEqualsForMandatoryFields(newArticle, foundArticle);
        
        //Nothing should be found after reset:
        db.resetDB();
        assertEquals(0,articleDAO.findAll().size());
        
        new File(dbName).delete();
    }
    
    public void articleEqualsForMandatoryFields(Article expected, Article actual) {
        assertEquals(expected.getCitationKey(),actual.getCitationKey());
        assertEquals(expected.getAuthor(),actual.getAuthor());
        assertEquals(expected.getTitle(),actual.getTitle());
        assertEquals(expected.getJournal(),actual.getJournal());
        assertEquals(expected.getYear(), actual.getYear());
    }
}
