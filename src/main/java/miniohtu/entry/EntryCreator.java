/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.entry;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author antti
 */
public class EntryCreator {

    public static Article article(String citationKey, String author, String title, String journal, int year,
            int volume, int number, String pages, int month, String note) {
        Map<String, String> fieldValues = new HashMap<>();
        fieldValues.put("citation key", citationKey);
        fieldValues.put("author", author);
        fieldValues.put("title", title);
        fieldValues.put("journal", journal);
        fieldValues.put("year", year + "");
        fieldValues.put("volume", volume + "");
        fieldValues.put("number", number + "");
        fieldValues.put("pages", pages);
        fieldValues.put("month", month + "");
        fieldValues.put("note", note);
        return new Article(fieldValues);
    }

    public static Article article(String i_am_citationKey, String author, String title, String journal, int year) {
        return article(i_am_citationKey, author, title, journal, year, Integer.MAX_VALUE, Integer.MAX_VALUE, null, Integer.MAX_VALUE, null);
    }

}
