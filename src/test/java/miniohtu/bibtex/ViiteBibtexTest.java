package miniohtu.bibtex;

import miniohtu.entry.Article;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViiteBibtexTest {

    public ViiteBibtexTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void mandatoryFieldArticleToBibTest() {
        Article article = new Article("article", "Petteri Petterinen", "The Title", "The Journal", 2000, 1);
        String expected = "@ARTICLE{article},\n"
                + "  author = {Petteri Petterinen},\n"
                + "  title = {The Title},\n"
                + "  yournal = {The Journal},\n"
                + "  year = {2000},\n"
                + "  volume = 1,\n"
                + "}";
        assertEquals(expected, ViiteBibtex.toBibtex(article));
    }
    
    @Test
    public void allFieldsArticleToBibTest() {
                Article article = new Article("article", "Petteri Petterinen", "The Title", "The Journal", 2000, 1,1,"1-2","2","This is a note");
                String expected = "@ARTICLE{article},\n"
                + "  author = {Petteri Petterinen},\n"
                + "  title = {The Title},\n"
                + "  yournal = {The Journal},\n"
                + "  year = {2000},\n"
                + "  number = 1,\n"
                + "  pages = {1-2},\n"
                + "  month = 2,\n"
                + "  note = {This is a note},\n"
                + "  volume = 1,\n"
                + "}";             
                assertEquals(expected, ViiteBibtex.toBibtex(article));
    }
}
