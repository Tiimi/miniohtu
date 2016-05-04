/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.entry;

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
public class InproceedingsTest {
       private Inproceedings requiredFields;
    private Inproceedings allFields;
    
    @Before
    public void setUp() {
        requiredFields = EntryCreator.inproceedings("inpro", "Pentti", "Pentti Title", "Pentti booktitle", 2016);
        allFields = EntryCreator.inproceedings("inpro", "Ville", "Ville Title", "Ville booktitle", 2016, "editor", "1-10",
                "organization", "publisher", "address",  4, "Note","Key");
    }

    @Test
    public void requiredFieldsAreCorrect() {
        assertEquals("inpro", requiredFields.getCitationKey());
        assertEquals("Pentti", requiredFields.getAuthor());
        assertEquals("Pentti Title", requiredFields.getTitle());
        assertEquals("Pentti booktitle", requiredFields.getBooktitle());
        assertEquals(2016, requiredFields.getYear());
        
        assertEquals(null, requiredFields.getEditor());
        assertEquals(null, requiredFields.getPages());
        assertEquals(null, requiredFields.getOrganization());
        assertEquals(null, requiredFields.getPublisher());
        assertEquals(null, requiredFields.getAddress());
        assertEquals(Integer.MAX_VALUE, requiredFields.getMonth());
        assertEquals(null, requiredFields.getNote());
        assertEquals(null, requiredFields.getKey());
        
    }
    
    @Test
    public void allFieldsAreCorrect() {
        assertEquals("inpro", allFields.getCitationKey());
        assertEquals("Ville", allFields.getAuthor());
        assertEquals("Ville Title", allFields.getTitle());
        assertEquals("Ville booktitle", allFields.getBooktitle());
        assertEquals(2016, allFields.getYear());
        
        assertEquals("editor", allFields.getEditor());
        assertEquals("1-10", allFields.getPages());
        assertEquals("organization", allFields.getOrganization());
        assertEquals("publisher", allFields.getPublisher());
        assertEquals("address", allFields.getAddress());
        assertEquals(4, allFields.getMonth());
        assertEquals("Note", allFields.getNote());
        assertEquals("Key", allFields.getKey());
        
        
    }

    @Test
    public void mandatoryFieldArticleToBibTest() {
        String expected = "@INPROCEEDINGS{inpro,\n"
                + "  author = {Pentti},\n"
                + "  title = {Pentti Title},\n"
                + "  booktitle = {Pentti booktitle},\n"
                + "  year = 2016,\n"
                + "}";
        assertEquals(expected, requiredFields.toBibtex());
    }

    @Test
    public void allFieldsArticleToBibTest() {
        String expected = "@INPROCEEDINGS{inpro,\n"
                + "  author = {Ville},\n"
                + "  title = {Ville Title},\n"
                + "  booktitle = {Ville booktitle},\n"
                + "  year = 2016,\n"
                + "  editor = {editor},\n"
                + "  pages = {1-10},\n"
                + "  organization = {organization},\n"
                + "  publisher = {publisher},\n"
                + "  address = {address},\n"
                + "  month = 4,\n"
                + "  note = {Note},\n"
                + "  key = {Key},\n"
                + "}";
        assertEquals(expected, allFields.toBibtex());
    }
    
    @Test
    public void toStringTest() {
        EntryCreator.inproceedings("inpro", "Pentti", "Pentti Title", "Pentti booktitle", 2016);
        String expected = "INPROCEEDINGS{citationKey=inpro, author=Pentti, title=Pentti Title, booktitle=Pentti booktitle, year=2016}";
        assertEquals(expected,requiredFields.toString());
    }
}
