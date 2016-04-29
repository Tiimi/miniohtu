
package miniohtu.entry;

import org.junit.Before;
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
    
    @Test
    public void allFieldsBookletToBibTest() {
        Booklet booklet = new Booklet("book", "The title", "Author", "Somehow", "Address", 4, 2000, "This is a note.", "key");
        String expected = "@BOOKLET{book,\n"
                + "  title = {The title},\n"
                + "  author = {Author},\n"
                + "  howpublished = {Somehow},\n"
                + "  address = {Address},\n"
                + "  month = 4,\n"
                + "  year = 2000,\n"
                + "  note = {This is a note.},\n"
                + "}";
        assertEquals(expected, booklet.toBibtex());
    }
    
    @Test
    public void someFieldsMissingBookletToBibTest() {
        Booklet booklet = new Booklet("book", "The title", "Author", "Somehow", null, 4, 2000, null, null);
        String expected = "@BOOKLET{book,\n"
                + "  title = {The title},\n"
                + "  author = {Author},\n"
                + "  howpublished = {Somehow},\n"
                + "  month = 4,\n"
                + "  year = 2000,\n"
                + "}";
        assertEquals(expected, booklet.toBibtex());
    }

    @Test
    public void mandatoryFieldsBookletToBibTest() {
        Booklet booklet = new Booklet("book", "The title");
        String expected = "@BOOKLET{book,\n"
                + "  title = {The title},\n"
                + "}";
        assertEquals(expected, booklet.toBibtex());
    }
}
