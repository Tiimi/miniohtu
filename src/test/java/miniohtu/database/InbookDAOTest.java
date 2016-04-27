
package miniohtu.database;

import java.io.File;
import java.sql.SQLException;
import miniohtu.entry.Inbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InbookDAOTest {
    private String dbName;
    private InbookDAO inbookDAO;
    
    @Before
    public void setUp() {
        dbName = "unit_test.db";
        inbookDAO = new InbookDAO(new Database(dbName));
    }
    
    @After
    public void tearDown() {
        new File(dbName).delete();
    }
    
    @Test
    public void ifEmptyFindTest() throws SQLException {
        assertNull(inbookDAO.find("asdasdasd"));
    }
    
    @Test
    public void findTest() throws SQLException {
        inbookDAO.add(new Inbook("i_am_CitationKey", "author", "title", 1, 
                "publisher", 2016, 2, 3, "address", 1, 4, "note", "key"));
        Inbook inbook = inbookDAO.find("i_am_CitationKey");
        
        assertEquals("i_am_CitationKey", inbook.getCitationKey());
        assertEquals("author", inbook.getAuthor());
        assertEquals("title", inbook.getTitle());
        assertEquals(1, inbook.getChapter());
        assertEquals("publisher", inbook.getPublisher());
        assertEquals(2016, inbook.getYear());
        assertEquals(2, inbook.getVolume());
        assertEquals(3, inbook.getSeries());
        assertEquals("address", inbook.getAddress());
        assertEquals(1, inbook.getEdition());
        assertEquals(4, inbook.getMonth());
        assertEquals("note", inbook.getNote());
        assertEquals("key", inbook.getKey());
    }
}
