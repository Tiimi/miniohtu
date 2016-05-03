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
    
    public static Book book(String citationKey, String author, String title, String publisher, int year, 
            int volume, int series, String address, int edition, int month, String note, String key) {
        Map<String,String> fieldValues = new HashMap<>();
        fieldValues.put("citation key", citationKey);
        fieldValues.put("author", author);
        fieldValues.put("title", title);
        fieldValues.put("publisher", publisher);
        fieldValues.put("year", year + "");
        fieldValues.put("volume", volume + "");
        fieldValues.put("series", series + "");
        fieldValues.put("address", address );
        fieldValues.put("edition", edition + "");
        fieldValues.put("month", month + "");
        fieldValues.put("note", note);
        fieldValues.put("key", key);
        return new Book(fieldValues);
    }
    
    public static Book book(String citationKey, String author, String title, String publisher, int year) {
        return book(citationKey, author, title, publisher, year, Integer.MAX_VALUE, Integer.MAX_VALUE, null, Integer.MAX_VALUE, Integer.MAX_VALUE, null, null);
    }

}
