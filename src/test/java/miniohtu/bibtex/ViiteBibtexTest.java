/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.bibtex;

import miniohtu.entry.Article;
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
        assertEquals(expected, ViiteBibtex.toBibtexEntry(article));
    }
}
