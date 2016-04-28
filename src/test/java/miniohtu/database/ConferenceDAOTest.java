
package miniohtu.database;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.Conference;
import org.junit.After;
import org.junit.Before;
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
    
    @Test
    public void findAllTest() throws SQLException {
        conferenceDAO.add(new Conference("i_am_CitationKey", "author", "title", "bookTitle", 2016, 
                "editor", 10, "organization", "publisher", "address", 4, "note", "key"));
        List<Conference> conference = conferenceDAO.findAll();
        
        assertEquals("i_am_CitationKey", conference.get(0).getCitationKey());
        assertEquals("author", conference.get(0).getAuthor());
        assertEquals("title", conference.get(0).getTitle());
        assertEquals("bookTitle", conference.get(0).getBookTitle());
        assertEquals(2016, conference.get(0).getYear());
        assertEquals("editor", conference.get(0).getEditor());
        assertEquals(10, conference.get(0).getPages());
        assertEquals("organization", conference.get(0).getOrganization());
        assertEquals("publisher", conference.get(0).getPublisher());
        assertEquals("address", conference.get(0).getAddress());
        assertEquals(4, conference.get(0).getMonth());
        assertEquals("note", conference.get(0).getNote());
        assertEquals("key", conference.get(0).getKey());
    }
    
    @Test
    public void removeTest() throws SQLException {
        conferenceDAO.add(new Conference("i_am_CitationKey", "author", "title", "bookTitle", 2016, 
                "editor", 10, "organization", "publisher", "address", 4, "note", "key"));
        conferenceDAO.remove("i_am_CitationKey", "conference");
        assertNull(conferenceDAO.find("i_am_CitationKey"));
    }
}
