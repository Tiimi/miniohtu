
package miniohtu.database;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.Booklet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookletDAOTest {
    private String dbName;
    private BookletDAO bookletDAO;
    
    @Before
    public void setUp() {
        dbName = "unit_test.db";
        bookletDAO = new BookletDAO(new Database(dbName));
    }
    
    @After
    public void tearDown() {
        new File(dbName).delete();
    }

    @Test
    public void ifEmptyFindTest() throws SQLException {
        assertNull(bookletDAO.find("aaaaaaaaaaaaaaa"));
    }
    
    @Test
    public void findTest() throws SQLException {
        bookletDAO.add(new Booklet("i_am_citationKey", "title"));
        Booklet booklet = bookletDAO.find("i_am_citationKey");
        assertEquals("i_am_citationKey", booklet.getCitationKey());
        assertEquals("title", booklet.getTitle());
    }
    
    @Test
    public void findAllTest() throws SQLException {
        bookletDAO.add(new Booklet("i_am_citationKey", "title"));
        List<Booklet> booklet = bookletDAO.findAll();
        assertEquals("i_am_citationKey", booklet.get(0).getCitationKey());
        assertEquals("title", booklet.get(0).getTitle());
    }
    
    @Test
    public void removeTest() throws SQLException {
        bookletDAO.add(new Booklet("i_am_citationKey", "title"));
        bookletDAO.remove("this_is_citationKey", "booklet");
        assertNull(bookletDAO.find("this_is_citationKey"));
    }
}
