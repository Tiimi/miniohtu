
package miniohtu.entry;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InbookTest {
    private Inbook requiredFields;
    private Inbook allFields;
    
    @Before
    public void setUp() {
        requiredFields = new Inbook("citationkey", "author", "title", 4, "publisher", 2016);
        allFields = new Inbook("citationkey", "author", "title", 9, "publisher", 2016,
            4, 3, "address", 5, 6, "note", "key");
    }
    
    @Test
    public void requiredFieldsAreCorrect() {
        assertEquals("citationkey", requiredFields.getCitationKey());
        assertEquals("author", requiredFields.getAuthor());
        assertEquals("title", requiredFields.getTitle());
        assertEquals(4, requiredFields.getChapter());
        assertEquals("publisher", requiredFields.getPublisher());
        assertEquals(2016, requiredFields.getYear());
    }
    
    @Test
    public void allFieldsAreCorrect() {
        assertEquals("citationkey", allFields.getCitationKey());
        assertEquals("author", allFields.getAuthor());
        assertEquals("title", allFields.getTitle());
        assertEquals(9, allFields.getChapter());
        assertEquals("publisher", allFields.getPublisher());
        assertEquals(2016, allFields.getYear());
        assertEquals(4, allFields.getVolume());
        assertEquals(3, allFields.getSeries());
        assertEquals("address", allFields.getAddress());
        assertEquals(5, allFields.getEdition());
        assertEquals(6, allFields.getMonth());
        assertEquals("note", allFields.getNote());
        assertEquals("key", allFields.getKey());
    }
}
