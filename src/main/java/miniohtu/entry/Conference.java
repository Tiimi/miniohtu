
package miniohtu.entry;

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
    private int pages;
    private String organization;
    private String publisher;
    private String address;
    private int month;
    private String note;
    private String key;
    
    public Conference(String citationKey, String author, String title, String bookTitle, int year) {
        this.citationKey = citationKey;
        this.author = author;
        this.title = title;
        this.bookTitle = bookTitle;
        this.year = year;
        
        this.pages = Integer.MAX_VALUE;
        this.month = Integer.MAX_VALUE;
    }
    
    public Conference(String citationKey, String author, String title, String bookTitle, int year,
            String editor, int pages, String organization, String publisher, String address, int month,
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
    
    public int getPages() {
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
        String bibtex = "@CONFERENCE{" + this.getCitationKey() + "},\n"
                + "  author = {" + this.getAuthor() + "},\n"
                + "  title = {" + this.getTitle() + "},\n"
                + "  booktitle = {" + this.getBookTitle() + "},\n"
                + "  year = " + this.getYear() + ",\n"
                + ((this.getEditor() == null) ? "" : "  editor = " + this.getEditor() + ",\n")
                + ((this.getPages() == Integer.MAX_VALUE) ? "" : "  pages = {" + this.getPages() + "},\n")
                + ((this.getOrganization() == null) ? "" : "  organization = " + this.getOrganization() + ",\n")
                + ((this.getPublisher() == null) ? "" : "  publisher = " + this.getPublisher() + ",\n")
                + ((this.getAddress() == null) ? "" : "  address = " + this.getAddress() + ",\n")
                + ((this.getMonth() == Integer.MAX_VALUE) ? "" : "  month = " + this.getMonth() + ",\n")
                + ((this.getNote() == null) ? "" : "  note = {" + this.getNote() + "},\n")
                + ((this.getKey() == null) ? "" : "  key = " + this.getKey() + ",\n")
                + "}";
        return BibtexEncoding.encodeToBibtex(bibtex);
    }
    
    @Override
    public String toString() {
        return "Conference{" + "citationKey=" + citationKey + ", author=" + author + ", title=" + title
                + ", bookTitle=" + bookTitle + ", year=" + year 
                + ((this.getEditor() == null) ? "" : ", editor=" + this.getEditor())
                + ((this.getPages() == Integer.MAX_VALUE) ? "" : ", pages=" + this.getPages())
                + ((this.getOrganization() == null) ? "" : ", organization=" + this.getOrganization())
                + ((this.getPublisher() == null) ? "" : ", publisher=" + this.getPublisher())
                + ((this.getAddress() == null) ? "" : ", address=" + this.getAddress())
                + ((this.getMonth() == Integer.MAX_VALUE) ? "" : ", month=" + this.getMonth())
                + ((this.getNote() == null) ? "" : ", note=" + this.getNote())
                + ((this.getKey() == null) ? "" : ", key=" + this.getKey())
                + "}";
    }
}
