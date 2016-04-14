/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.database;

import java.io.File;
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
public class ArticleDAOTest {
    
    public ArticleDAOTest() {
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
    public void ifEmptyFindTest() throws SQLException {
        String dbName = "unit_test.db";
        ArticleDAO articleDAO = new ArticleDAO(new Database(dbName));
        assertNull(articleDAO.find("aaaaaaaaaaaaaaaa"));
        new File(dbName).delete();
    }
    
    @Test
    public void findTest() throws SQLException {
        String dbName = "unit_test.db";
        ArticleDAO articleDAO = new ArticleDAO(new Database(dbName));
        articleDAO.add(new Article("i_am_id", "a", "b", "c", 0, 1));
        Article article = articleDAO.find("i_am_id");
        assertEquals("i_am_id", article.getId());
        assertEquals("a", article.getAuthor());
        assertEquals("b", article.getTitle());
        assertEquals("c", article.getJournal());
        assertEquals(0, article.getYear());
        assertEquals(1, article.getVolume());      
        new File(dbName).delete();
    }
}
