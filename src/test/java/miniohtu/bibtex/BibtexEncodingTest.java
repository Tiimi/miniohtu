/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.bibtex;

import java.util.Random;
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
public class BibtexEncodingTest {
    
    public BibtexEncodingTest() {
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
    public void emptyReturnsEmpty() {
        assertEquals("", BibtexEncoding.encodeToBibtex(""));
    }
    
    @Test
    public void emptryStringReturnsEmptyTest() {
        assertEquals("", BibtexEncoding.encodeToBibtex(""));
    }
    
    @Test
    public void allSpecialCharactersTest() {
        assertEquals("{\\\"a}{\\\"A}{\\\"o}{\\\"O}{\\aa}{\\AA}",BibtexEncoding.encodeToBibtex("äÄöÖåÅ"));
    }
    
    @Test
    public void noAffectOnASCIITest() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 128; i++) {
            sb.append(i);
        }
        String expected = sb.toString();
        assertEquals(expected, BibtexEncoding.encodeToBibtex(expected));
    }
    
    @Test
    public void notDefinedCharactersTest() {
        String input = "" + (char) 1000 + (char) 9999 + (char) 102141;
        System.out.println(input);
        assertEquals("{???}{???}{???}", BibtexEncoding.encodeToBibtex(input));
    }
}
