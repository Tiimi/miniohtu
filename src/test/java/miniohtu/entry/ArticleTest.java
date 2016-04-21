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
public class ArticleTest {
    
    private Article mandatory;
    private Article allParam;
    
    public ArticleTest() {
        mandatory = new Article("id", "author", "title", "journal", 1);
        allParam = new Article("id", "author", "title", "journal", 1, 2, 3, "2-3",1,"note");
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
    public void mandatoryKonstructorTest() {
        mandatoryKonstructor(mandatory);
    }
    public void mandatoryKonstructor(Article a) {
        assertEquals("id", a.getId());
        assertEquals("author", a.getAuthor());
        assertEquals("title", a.getTitle());
        assertEquals("journal", a.getJournal());
        assertEquals(1, a.getYear());
    }
    
    @Test 
    public void allParametersConstructoTest() {
        mandatoryKonstructor(allParam);
        assertEquals(3, allParam.getNumber());
        assertEquals("2-3", allParam.getPages());
        assertEquals(1, allParam.getMonth());
        assertEquals("note", allParam.getNote());
        assertEquals("id", allParam.getId());
    }
}
