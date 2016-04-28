
package miniohtu.entry;

import miniohtu.bibtex.BibtexEncoding;

public class Booklet implements BaseEntry{
    // Required fields
    private String citationKey;
    private String title;
    
    // Optional fields
    private String author;
    private String howPublished;
    private String address;
    private int month = Integer.MAX_VALUE;
    private int year = Integer.MAX_VALUE;
    private String note;
    private String key;
    
    public Booklet(String citationKey, String title) {
        this.citationKey = citationKey;
        this.title = title;  
    }
    
    public Booklet(String citationKey, String title,
            String author, String howPublished, String address, int month,
            int year, String note, String key) {
        this(citationKey, title);     
        this.author = author;
        this.howPublished = howPublished;
        this.address = address;
        this.month = month;
        this.year = year;
        this.note = note;
        this.key = key;
    } 

    public String getCitationKey() {
        return citationKey;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getHowPublished() {
        return howPublished;
    }

    public String getAddress() {
        return address;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getNote() {
        return note;
    }
    
    public String getKey() {
        return key;
    }
    
    @Override
    public String toBibtex() {
        String bibtex = "@BOOKLET{" + this.getCitationKey() + "},\n"
                + "  title = {" + this.getTitle() + "},\n"
                + ((this.getAuthor()== null) ? "" : "  author = {" + this.getAuthor() + "},\n")            
                + ((this.getHowPublished()== null) ? "" : "  howpublished = {" + this.getHowPublished()+ "},\n")
                + ((this.getAddress() == null) ? "" : "  address = {" + this.getAddress() + "},\n")
                + ((this.getMonth() == Integer.MAX_VALUE) ? "" : "  month = " + this.getMonth() + ",\n")
                + ((this.getYear() == Integer.MAX_VALUE) ? "" : "  year = " + this.getYear() + ",\n")
                + ((this.getNote() == null) ? "" : "  note = {" + this.getNote() + "},\n")
                + "}";
        return BibtexEncoding.encodeToBibtex(bibtex);
    }
    
    @Override
    public String toString() {
        return "Booklet{" + "citationKey=" + citationKey + ", title=" + title + ", author=" + author + ", howPublished=" + howPublished 
                + ", address=" + address + ", month=" + month + ", year=" + year + ", note=" + note + ", key=" + key + "}";
    }
}
