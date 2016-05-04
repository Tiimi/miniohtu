/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.database;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import miniohtu.entry.EntryCreator;
import miniohtu.entry.Inbook;
import miniohtu.entry.Inproceedings;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antti
 */
public class InproceedingsDAOTest {
    
    String dbName;
    InproceedingsDAO inbookDAO;
    
       @Before
    public void setUp() {
        dbName = "unit_test.db";
        inbookDAO = new InproceedingsDAO(new Database(dbName));
    }
    
    @After
    public void tearDown() {
        new File(dbName).delete();
    }
    
    @Test
    public void ifEmptyFindTest() throws SQLException {
        assertNull(inbookDAO.find("asdasdasd"));
    }
    
    @Test
    public void findTest() throws SQLException {
        Inproceedings expected = EntryCreator.inproceedings("ABC123", "author", "title125125", "booktitle106123", 2016, "editor6163", "pages6124", "org00521", "publisher+15", "addr", 10, "Note", "Key");
        inbookDAO.add(expected);
        Inproceedings inpro = inbookDAO.find("ABC123");
        inproceedingsEquals(expected, inpro);         
    }
    
    @Test
    public void findAllTest() throws SQLException {
         Inproceedings expected = EntryCreator.inproceedings("ABC123", "author", "title125125", "booktitle106123", 2016, "editor6163", "pages6124", "org00521", "publisher+15", "addr", 10, "Note", "Key");
        inbookDAO.add(expected);
        List<Inproceedings> inpro = inbookDAO.findAll();
        inproceedingsEquals(expected, inpro.get(0));
    }
 
    @Test
    public void removeTest() throws SQLException {
        Inproceedings expected = EntryCreator.inproceedings("ABC123", "author", "title125125", "booktitle106123", 2016, "editor6163", "pages6124", "org00521", "publisher+15", "addr", 10, "Note", "Key");
        inbookDAO.add(expected);
        inbookDAO.remove("ABC123", "inproceedings");
        assertNull(inbookDAO.find("ABC123"));
    }
    
    public void inproceedingsEquals(Inproceedings a, Inproceedings b) {
        assertEquals(a.toString(), b.toString());
    }
}
