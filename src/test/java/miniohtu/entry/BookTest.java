
package miniohtu.entry;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
    private Book requiredFields;
    private Book allFields;
    
    @Before
    public void setUp() {
        requiredFields = new Book("citationkey", "author", "title", "publisher", 2016);
        allFields = new Book("citationkey", "Ville", "title", "publisher", 2016, 2, 1, "address", 2, 4, "note", "key");
    }
    
    @Test
    public void requiredFieldsAreCorrect() {
        assertEquals("citationkey", requiredFields.getCitationKey());
        assertEquals("author", requiredFields.getAuthor());
        assertEquals("title", requiredFields.getTitle());
        assertEquals("publisher", requiredFields.getPublisher());
        assertEquals(2016, requiredFields.getYear());
    }
    
    @Test
    public void allFieldsAreCorrect() {
        assertEquals("citationkey", allFields.getCitationKey());
        assertEquals("Ville", allFields.getAuthor());
        assertEquals("title", allFields.getTitle());
        assertEquals("publisher", allFields.getPublisher());
        assertEquals(2016, allFields.getYear());
        assertEquals(2, allFields.getVolume());
        assertEquals(1, allFields.getSeries());
        assertEquals("address", allFields.getAddress());
        assertEquals(2, allFields.getEdition());
        assertEquals(4, allFields.getMonth());
        assertEquals("note", allFields.getNote());
        assertEquals("key", allFields.getKey());
    }
}
