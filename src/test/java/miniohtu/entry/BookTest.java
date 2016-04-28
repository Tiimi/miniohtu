
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

    @Test
    public void mandatoryFieldsBookToBibtest() {
        Book book = new Book("book", "Petteri Petterson", "The Title", "The Publisher", 2000);
        String expected = "@ARTICLE{book},\n"
                + "  author = {Petteri Petterson},\n"
                + "  title = {The Title},\n"
                + "  publisher = {The Publisher},\n"
                + "  year = 2000,\n"
                + "}";
        assertEquals(expected, book.toBibtex());
    }

    @Test
    public void allFieldsBookToBibTest() {
        Book book = new Book("book", "Petteri Petterson", "The Title", "The Publisher", 2000, 1, 1, "address", 0, 4, "This is a note", null);
        String expected = "@ARTICLE{book},\n"
                + "  author = {Petteri Petterson},\n"
                + "  title = {The Title},\n"
                + "  publisher = {The Publisher},\n"
                + "  year = 2000,\n"
                + "  volume = 1,\n"
                + "  series = 1,\n"
                + "  address = {address},\n"
                + "  edition = 0,\n"
                + "  month = 4,\n"
                + "  note = {This is a note},\n"
                + "}";
        assertEquals(expected, book.toBibtex());
    }
}
