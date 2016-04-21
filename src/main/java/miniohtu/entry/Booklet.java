
package miniohtu.entry;

public class Booklet {
    // Required fields
    private String citationKey;
    private String title;
    
    // Optional fields
    private String author;
    private String howPublished;
    private String address;
    private int month;
    private int year;
    private String note;
    private String key;
    
    public Booklet(String citationKey, String title, String author, String howPublished, String address,
            int month, int year, String note, String key) {
        this.citationKey = citationKey;
        this.title = title;
        this.author = author;
        this.howPublished = howPublished;
        this.address = address;
        this.month = month;
        this.year = year;
        this.note = note;
        this.key = key;
    }
    
    public Booklet(String citationKey, String title) {
        this.citationKey = citationKey;
        this.title = title;
        
        this.year = Integer.MAX_VALUE;
        this.month = Integer.MAX_VALUE;
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
}
