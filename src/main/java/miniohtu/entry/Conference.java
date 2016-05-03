
package miniohtu.entry;

import java.util.Map;
import miniohtu.bibtex.BibtexEncoding;

public class Conference implements BaseEntry {
    // Required fields
    private String citationKey;
    private String author;
    private String title;
    private String bookTitle;
    private int year;
    
    // Optional fields
    private String editor;
    private String pages;
    private String organization;
    private String publisher;
    private String address;
    private int month = Integer.MAX_VALUE;
    private String note;
    private String key;
    
    public final static String[] mandatoryFields = {"String:citation key","String:author","String:title","String:bookTitle","Integer:year"};
    public final static String[] optionalFields = {"String:editor","String:pages","String:organization","String:publisher","String:address","Integer:month","String:note","String:key"};
    
    public Conference(String citationKey, String author, String title, String bookTitle, int year) {
        this.citationKey = citationKey;
        this.author = author;
        this.title = title;
        this.bookTitle = bookTitle;
        this.year = year;
    }
    
    public Conference(String citationKey, String author, String title, String bookTitle, int year,
            String editor, String pages, String organization, String publisher, String address, int month,
            String note, String key) {
        this(citationKey, author, title, bookTitle, year);
        this.editor = editor;
        this.pages = pages;
        this.organization = organization;
        this.publisher = publisher;
        this.address = address;
        this.month = month;
        this.note = note;
        this.key = key;
    }
    
    public Conference(Map<String,String> fieldValues) {
        this.citationKey = fieldValues.get("citation key");
        this.author = fieldValues.get("author");
        this.title = fieldValues.get("title");
        this.bookTitle = fieldValues.get("bookTitle");
        this.year = Integer.parseInt(fieldValues.get("year"));
        this.editor = fieldValues.get("editor");
        this.pages = fieldValues.get("pages");
        this.organization = fieldValues.get("organization");
        this.publisher = fieldValues.get("publisher");
        this.address = fieldValues.get("address");
        this.month = Integer.parseInt(fieldValues.get("month"));
        this.note = fieldValues.get("note");
        this.key = fieldValues.get("key");
    }
    
    public String getCitationKey() {
        return citationKey;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getBookTitle() {
        return bookTitle;
    }
    
    public int getYear() {
        return year;
    }
    
    public String getEditor() {
        return editor;
    }
    
    public String getPages() {
        return pages;
    }
    
    public String getOrganization() {
        return organization;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getMonth() {
        return month;
    }
    
    public String getNote() {
        return note;
    }
    
    public String getKey() {
        return key;
    }

    @Override
    public String toBibtex() {
        String bibtex = "@CONFERENCE{" + this.getCitationKey() + ",\n"
                + "  author = {" + this.getAuthor() + "},\n"
                + "  title = {" + this.getTitle() + "},\n"
                + "  booktitle = {" + this.getBookTitle() + "},\n"
                + "  year = " + this.getYear() + ",\n"
                + ((this.getEditor() == null) ? "" : "  editor = {" + this.getEditor() + "},\n")
                + ((this.getPages() == null) ? "" : "  pages = " + this.getPages() + ",\n")
                + ((this.getOrganization() == null) ? "" : "  organization = {" + this.getOrganization() + "},\n")
                + ((this.getPublisher() == null) ? "" : "  publisher = {" + this.getPublisher() + "},\n")
                + ((this.getAddress() == null) ? "" : "  address = {" + this.getAddress() + "},\n")
                + ((this.getMonth() == Integer.MAX_VALUE) ? "" : "  month = " + this.getMonth() + ",\n")
                + ((this.getNote() == null) ? "" : "  note = {" + this.getNote() + "},\n")
                + ((this.getKey() == null) ? "" : "  key = {" + this.getKey() + "},\n")
                + "}";
        return BibtexEncoding.encodeToBibtex(bibtex);
    }
    
    @Override
    public String toString() {
        return "Conference{" + "citationKey=" + citationKey + ", author=" + author + ", title=" + title
                + ", bookTitle=" + bookTitle + ", year=" + year 
                + ((this.getEditor() == null) ? "" : ", editor=" + this.getEditor())
                + ((this.getPages() == null) ? "" : ", pages=" + this.getPages())
                + ((this.getOrganization() == null) ? "" : ", organization=" + this.getOrganization())
                + ((this.getPublisher() == null) ? "" : ", publisher=" + this.getPublisher())
                + ((this.getAddress() == null) ? "" : ", address=" + this.getAddress())
                + ((this.getMonth() == Integer.MAX_VALUE) ? "" : ", month=" + this.getMonth())
                + ((this.getNote() == null) ? "" : ", note=" + this.getNote())
                + ((this.getKey() == null) ? "" : ", key=" + this.getKey())
                + "}";
    }
}
