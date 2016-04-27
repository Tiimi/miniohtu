
package miniohtu.database;

import java.io.File;
import java.sql.SQLException;
import miniohtu.entry.Conference;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConferenceDAOTest {
    private String dbName;
    private ConferenceDAO conferenceDAO;
    
    @Before
    public void setUp() {
        dbName = "unit_test.db";
        conferenceDAO = new ConferenceDAO(new Database(dbName));
    }
    
    @After
    public void tearDown() {
        new File(dbName).delete();
    }

    @Test
    public void ifEmptyFindTest() throws SQLException {
        assertNull(conferenceDAO.find("asdsadasd"));
    }
    
    @Test
    public void findTest() throws SQLException {
        conferenceDAO.add(new Conference("i_am_CitationKey", "author", "title", "bookTitle", 2016, 
                "editor", 10, "organization", "publisher", "address", 4, "note", "key"));
        Conference conference = conferenceDAO.find("i_am_CitationKey");
        
        assertEquals("i_am_CitationKey", conference.getCitationKey());
        assertEquals("author", conference.getAuthor());
        assertEquals("title", conference.getTitle());
        assertEquals("bookTitle", conference.getBookTitle());
        assertEquals(2016, conference.getYear());
        assertEquals("editor", conference.getEditor());
        assertEquals(10, conference.getPages());
        assertEquals("organization", conference.getOrganization());
        assertEquals("publisher", conference.getPublisher());
        assertEquals("address", conference.getAddress());
        assertEquals(4, conference.getMonth());
        assertEquals("note", conference.getNote());
        assertEquals("key", conference.getKey());
    }
}
