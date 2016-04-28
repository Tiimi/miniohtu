

package miniohtu.entry;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antti
 */
public class ArticleTest {
    private Article requiredFields;
    private Article allFields;
    
    @Before
    public void setUp() {
        requiredFields = new Article("article", "Ville", "Artikkeli", "Journaali", 2016);
        allFields = new Article("article2", "Ville", "Toinen artikkeli", "Journaali", 2016, 1, 
                2, "1-10", 4, "Note");
    }

    @Test
    public void requiredFieldsAreCorrect() {
        assertEquals("article", requiredFields.getCitationKey());
        assertEquals("Ville", requiredFields.getAuthor());
        assertEquals("Artikkeli", requiredFields.getTitle());
        assertEquals("Journaali", requiredFields.getJournal());
        assertEquals(2016, requiredFields.getYear());
        
        assertEquals(Integer.MAX_VALUE, requiredFields.getVolume());
        assertEquals(Integer.MAX_VALUE, requiredFields.getNumber());
        assertEquals(null, requiredFields.getPages());
        assertEquals(Integer.MAX_VALUE, requiredFields.getMonth());
        assertEquals(null, requiredFields.getNote());
    }
    
    @Test
    public void allFieldsAreCorrect() {
        assertEquals("article2", allFields.getCitationKey());
        assertEquals("Ville", allFields.getAuthor());
        assertEquals("Toinen artikkeli", allFields.getTitle());
        assertEquals("Journaali", allFields.getJournal());
        assertEquals(2016, allFields.getYear());
        
        assertEquals(1, allFields.getVolume());
        assertEquals(2, allFields.getNumber());
        assertEquals("1-10", allFields.getPages());
        assertEquals(4, allFields.getMonth());
        assertEquals("Note", allFields.getNote());
    }

    @Test
    public void mandatoryFieldArticleToBibTest() {
        Article article = new Article("article", "Petteri Petterinen", "The Title", "The Journal", 2000);
        String expected = "@ARTICLE{article},\n"
                + "  author = {Petteri Petterinen},\n"
                + "  title = {The Title},\n"
                + "  yournal = {The Journal},\n"
                + "  year = 2000,\n"
                + "}";
        assertEquals(expected, article.toBibtex());
    }

    @Test
    public void allFieldsArticleToBibTest() {
        Article article = new Article("article", "Petteri Petterinen", "The Title", "The Journal", 2000, 1, 1, "1-2", 2, "This is a note");
        String expected = "@ARTICLE{article},\n"
                + "  author = {Petteri Petterinen},\n"
                + "  title = {The Title},\n"
                + "  yournal = {The Journal},\n"
                + "  year = 2000,\n"
                + "  number = 1,\n"
                + "  pages = {1-2},\n"
                + "  month = 2,\n"
                + "  note = {This is a note},\n"
                + "  volume = 1,\n"
                + "}";
        assertEquals(expected, article.toBibtex());
    }
}
