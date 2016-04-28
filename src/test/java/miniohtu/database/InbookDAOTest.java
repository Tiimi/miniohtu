
package miniohtu.database;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
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
    
    @Test
    public void findAllTest() throws SQLException {
        inbookDAO.add(new Inbook("i_am_CitationKey", "author", "title", 1, 
                "publisher", 2016, 2, 3, "address", 1, 4, "note", "key"));
        List<Inbook> inbook = inbookDAO.findAll();
        
        assertEquals("i_am_CitationKey", inbook.get(0).getCitationKey());
        assertEquals("author", inbook.get(0).getAuthor());
        assertEquals("title", inbook.get(0).getTitle());
        assertEquals(1, inbook.get(0).getChapter());
        assertEquals("publisher", inbook.get(0).getPublisher());
        assertEquals(2016, inbook.get(0).getYear());
        assertEquals(2, inbook.get(0).getVolume());
        assertEquals(3, inbook.get(0).getSeries());
        assertEquals("address", inbook.get(0).getAddress());
        assertEquals(1, inbook.get(0).getEdition());
        assertEquals(4, inbook.get(0).getMonth());
        assertEquals("note", inbook.get(0).getNote());
        assertEquals("key", inbook.get(0).getKey());
    }
 
    @Test
    public void removeTest() throws SQLException {
        inbookDAO.add(new Inbook("i_am_CitationKey", "author", "title", 1, 
                "publisher", 2016, 2, 3, "address", 1, 4, "note", "key"));
        inbookDAO.remove("i_am_CitationKey", "inbook");
        assertNull(inbookDAO.find("i_am_CitationKey"));
    }
}
