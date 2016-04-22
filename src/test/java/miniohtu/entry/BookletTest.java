
package miniohtu.entry;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookletTest {
    private Booklet requiredFields;
    private Booklet allFields;
    
    @Before
    public void setup() {
        requiredFields = new Booklet("citationKey", "Ville");
        allFields = new Booklet("citationKey", "title", "author", "somehow", "address", 4, 2016, "Note", "Key");
    }
    
    @Test
    public void requiredFieldsAreCorrect() {
        assertEquals("citationKey", requiredFields.getCitationKey());
        assertEquals("Ville", requiredFields.getTitle());
    }
    
    @Test
    public void allFieldsAreCorrect() {
        assertEquals("citationKey", allFields.getCitationKey());
        assertEquals("title", allFields.getTitle());
        assertEquals("author", allFields.getAuthor());
        assertEquals("somehow", allFields.getHowPublished());
        assertEquals("address", allFields.getAddress());
        assertEquals(4, allFields.getMonth());
        assertEquals(2016, allFields.getYear());
        assertEquals("Note", allFields.getNote());
        assertEquals("Key", allFields.getKey());
    }
}
