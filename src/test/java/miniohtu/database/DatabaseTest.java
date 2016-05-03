/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.database;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import miniohtu.entry.Article;
import miniohtu.entry.EntryCreator;
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
    private String dbName;
    private Database db;
    
    @Before
    public void setUp() {
        dbName = "unit_test.db";
        db = new Database(dbName);
    }
    
    @After
    public void tearDown() {
        new File(dbName).delete();
    }
    
    @Test
    public void articleIsAdded() throws SQLException, ClassNotFoundException {
        ArticleDAO articleDAO = new ArticleDAO(db);        
        Article expected = EntryCreator.article("JokuID", "Tekijä", "Titteli", "Journaali", 2001);      
        articleDAO.add(expected);
        List<Article> articles = articleDAO.findAll();
        assertEquals(1, articles.size());
        articleEqualsForMandatoryFields(expected,articles.get(0));
    }
    
    @Test
    public void resetDBTest() throws SQLException {
        ArticleDAO articleDAO = new ArticleDAO(db);
        
        //Add an article to db.
        Article newArticle = EntryCreator.article("asd", "asdAuthor", "asdTitle", "asdJournal", 9001);
        articleDAO.add(newArticle);
        
        //One Article should be found:
        List<Article> articles = articleDAO.findAll();
        Article foundArticle = articles.get(0);
        articleEqualsForMandatoryFields(newArticle, foundArticle);
        
        //Nothing should be found after reset:
        db.resetDB();
        assertEquals(0,articleDAO.findAll().size());
    }
    
    private void articleEqualsForMandatoryFields(Article expected, Article actual) {
        assertEquals(expected.getCitationKey(),actual.getCitationKey());
        assertEquals(expected.getAuthor(),actual.getAuthor());
        assertEquals(expected.getTitle(),actual.getTitle());
        assertEquals(expected.getJournal(),actual.getJournal());
        assertEquals(expected.getYear(), actual.getYear());
    }
    
    @Test
    public void articleIsRemovedFromDatabase() throws SQLException {
        ArticleDAO articleDAO = new ArticleDAO(db);
        Article article = EntryCreator.article("citationKey", "author", "title", "journal", 2000);
        articleDAO.add(article);
        articleDAO.remove("citationKey", "article");
        assertNull(articleDAO.find("citationKey"));
    }
}