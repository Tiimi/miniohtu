package miniohtu.bibtex;

import miniohtu.entry.Article;
import miniohtu.entry.Book;
import miniohtu.entry.Booklet;
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
        Article article = new Article("article", "Petteri Petterinen", "The Title", "The Journal", 2000);
        String expected = "@ARTICLE{article},\n"
                + "  author = {Petteri Petterinen},\n"
                + "  title = {The Title},\n"
                + "  yournal = {The Journal},\n"
                + "  year = {2000},\n"
                + "}";
        assertEquals(expected, ViiteBibtex.toBibtex(article));
    }

    @Test
    public void allFieldsArticleToBibTest() {
        Article article = new Article("article", "Petteri Petterinen", "The Title", "The Journal", 2000, 1, 1, "1-2", 2, "This is a note");
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

    @Test
    public void mandatoryFieldsBookToBibtest() {
        Book book = new Book("book", "Petteri Petterson", "The Title", "The Publisher", 2000);
        String expected = "@ARTICLE{book},\n"
                + "  author = {Petteri Petterson},\n"
                + "  title = {The Title},\n"
                + "  publisher = {The Publisher},\n"
                + "  year = {2000},\n"
                + "}";
        assertEquals(expected, ViiteBibtex.toBibtex(book));
    }

    @Test
    public void allFieldsBookToBibTest() {
        Book book = new Book("book", "Petteri Petterson", "The Title", "The Publisher", 2000, 1, "series", "address", 0, "Month", "This is a note", null);
        String expected = "@ARTICLE{book},\n"
                + "  author = {Petteri Petterson},\n"
                + "  title = {The Title},\n"
                + "  publisher = {The Publisher},\n"
                + "  year = {2000},\n"
                + "  volume = 1,\n"
                + "  series = {series},\n"
                + "  address = {address},\n"
                + "  edition = 0,\n"
                + "  month = {Month},\n"
                + "  note = {This is a note},\n"
                + "}";
        assertEquals(expected, ViiteBibtex.toBibtex(book));
    }

    @Test
    public void allFieldsBookletToBibTest() {
        Booklet booklet = new Booklet("book", "The title", "Author", "Somehow", "Address", "Month", 2000, "This is a note.", null);
        String expected = "@BOOKLET{book},\n"
                + "  title = {The title},\n"
                + "  author = {Author},\n"
                + "  howpublished = {Somehow},\n"
                + "  address = {Address},\n"
                + "  month = {Month},\n"
                + "  year = {2000},\n"
                + "  note = {This is a note.},\n"
                + "}";
        assertEquals(expected, ViiteBibtex.toBibtex(booklet));
    }
    
    @Test
    public void someFieldsMissingBookletToBibTest() {
        Booklet booklet = new Booklet("book", "The title", "Author", "Somehow", null, "Month", 2000, null, null);
        String expected = "@BOOKLET{book},\n"
                + "  title = {The title},\n"
                + "  author = {Author},\n"
                + "  howpublished = {Somehow},\n"
                + "  month = {Month},\n"
                + "  year = {2000},\n"
                + "}";
        assertEquals(expected, ViiteBibtex.toBibtex(booklet));
    }

    @Test
    public void mandatoryFieldsBookletToBibTest() {
        Booklet booklet = new Booklet("book", "The title");
        String expected = "@BOOKLET{book},\n"
                + "  title = {The title},\n"
                + "}";
        assertEquals(expected, ViiteBibtex.toBibtex(booklet));
    }
}
