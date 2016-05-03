
package miniohtu.database;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.Book;
import miniohtu.entry.EntryCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookDAOTest {
    private String dbName;
    private BookDAO bookDAO;
    
    @Before
    public void setUp() {
        dbName = "unit_test.db";
        bookDAO = new BookDAO(new Database(dbName));
    }
    
    @After
    public void tearDown() {
        new File(dbName).delete();
    }
    
    @Test
    public void ifEmptyFindTest() throws SQLException {
        assertNull(bookDAO.find("aaaaaaa"));
    }
    
    @Test
    public void findTest() throws SQLException {
        bookDAO.add(EntryCreator.book("this_is_citationKey", "author", "title", "publisher", 2016));
        Book book = bookDAO.find("this_is_citationKey");
        
        assertEquals("this_is_citationKey", book.getCitationKey());
        assertEquals("author", book.getAuthor());
        assertEquals("title", book.getTitle());
        assertEquals("publisher", book.getPublisher());
        assertEquals(2016, book.getYear());
    }
    
    @Test
    public void findAllTest() throws SQLException {
        bookDAO.add(EntryCreator.book("this_is_citationKey", "author", "title", "publisher", 2016));
        List<Book> book = bookDAO.findAll();
        
        assertEquals("this_is_citationKey", book.get(0).getCitationKey());
        assertEquals("author", book.get(0).getAuthor());
        assertEquals("title", book.get(0).getTitle());
        assertEquals("publisher", book.get(0).getPublisher());
        assertEquals(2016, book.get(0).getYear());
    }
    
    @Test
    public void removeTest() throws SQLException {
        bookDAO.add(EntryCreator.book("this_is_citationKey", "author", "title", "publisher", 2016));
        bookDAO.remove("this_is_citationKey", "book");
        assertNull(bookDAO.find("this_is_citationKey"));
    }
}
