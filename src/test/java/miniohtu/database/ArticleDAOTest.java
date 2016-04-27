
package miniohtu.database;

import java.io.File;
import java.sql.SQLException;
import miniohtu.entry.Article;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antti
 */
public class ArticleDAOTest {
    private String dbName;
    private ArticleDAO articleDAO;
    
    
    @Before
    public void setUp() {
        dbName = "unit_test.db";
        articleDAO = new ArticleDAO(new Database(dbName));
    }
    
    @After
    public void tearDown() {
        new File(dbName).delete();
    }

    @Test
    public void ifEmptyFindTest() throws SQLException {
        assertNull(articleDAO.find("aaaaaaaaaaaaaaaa"));
    }
    
    @Test
    public void findTest() throws SQLException {
        articleDAO.add(new Article("i_am_citationKey", "author", "title", "journal", 2016));
        Article article = articleDAO.find("i_am_citationKey");
        
        assertEquals("i_am_citationKey", article.getCitationKey());
        assertEquals("author", article.getAuthor());
        assertEquals("title", article.getTitle());
        assertEquals("journal", article.getJournal());
        assertEquals(2016, article.getYear());
    }
}
