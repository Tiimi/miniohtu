

package miniohtu.entry;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ConferenceTest {
    private Conference requiredFields;
    private Conference allFields;
    
    @Before
    public void setUp() {
        requiredFields = new Conference("1234", "Vili", "Titteli", "Book titteli", 2016);
        allFields = new Conference("12342", "Vili2", "Titteli2", "Book titteli2", 20162,
                "Editori", 100, "Organisaatio", "Publisheri", "Addressi", 1, "Nootti", "Key");
    }

    @Test
    public void requiredFieldsAreCorrect() {
        assertEquals("1234", requiredFields.getCitationKey());
        assertEquals("Vili", requiredFields.getAuthor());
        assertEquals("Titteli", requiredFields.getTitle());
        assertEquals("Book titteli", requiredFields.getBookTitle());
        assertEquals(2016, requiredFields.getYear());
        
        assertEquals(null, requiredFields.getEditor());
        assertEquals(Integer.MAX_VALUE, requiredFields.getPages());
        assertEquals(null, requiredFields.getOrganization());
        assertEquals(null, requiredFields.getPublisher());
        assertEquals(null, requiredFields.getAddress());
        assertEquals(Integer.MAX_VALUE, requiredFields.getMonth());
        assertEquals(null, requiredFields.getNote());
        assertEquals(null, requiredFields.getKey());
    }
    
    @Test
    public void allFieldsAreCorrect() {
        assertEquals("12342", allFields.getCitationKey());
        assertEquals("Vili2", allFields.getAuthor());
        assertEquals("Titteli2", allFields.getTitle());
        assertEquals("Book titteli2", allFields.getBookTitle());
        assertEquals(20162, allFields.getYear());
        
        assertEquals("Editori", allFields.getEditor());
        assertEquals(100, allFields.getPages());
        assertEquals("Organisaatio", allFields.getOrganization());
        assertEquals("Publisheri", allFields.getPublisher());
        assertEquals("Addressi", allFields.getAddress());
        assertEquals(1, allFields.getMonth());
        assertEquals("Nootti", allFields.getNote());
        assertEquals("Key", allFields.getKey());
    }
    
    @Test
    public void mandatoryFieldsToBibtex() {
        String expected = "@CONFERENCE{1234},\n"
                + "  author = {Vili},\n"
                + "  title = {Titteli},\n"
                + "  booktitle = {Book titteli},\n"
                + "  year = 2016,\n"
                + "}";
        assertEquals(expected, requiredFields.toBibtex());
    }

    @Test
    public void allFieldsToBibTex() {
        String expected = "@CONFERENCE{12342},\n"
                + "  author = {Vili2},\n"
                + "  title = {Titteli2},\n"
                + "  booktitle = {Book titteli2},\n"
                + "  year = 20162,\n"
                + "  editor = {Editori},\n"
                + "  pages = 100,\n"
                + "  organization = {Organisaatio},\n"
                + "  publisher = {Publisheri},\n"
                + "  address = {Addressi},\n"
                + "  month = 1,\n"
                + "  note = {Nootti},\n"
                + "  key = {Key},\n"
                + "}";
        assertEquals(expected, allFields.toBibtex());
    }
}
