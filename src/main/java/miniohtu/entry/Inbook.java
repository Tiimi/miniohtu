
package miniohtu.entry;

public class Inbook {
    // Required fields
    private String citationKey;
    private String author;
    private String title;
    private int chapter;
    private String publisher;
    private int year;
    
    // Optional fields
    private int volume;
    private int series;
    private String address;
    private int edition;
    private int month;
    private String note;
    private String key;
    
    public Inbook(String citationKey, String author, String title, int chapter, String publisher, int year) {
        this.citationKey = citationKey;
        this.author = author;
        this.title = title;
        this.chapter = chapter;
        this.publisher = publisher;
        this.year = year;
        
        this.volume = Integer.MAX_VALUE;
        this.series = Integer.MAX_VALUE;
        this.edition = Integer.MAX_VALUE;
        this.month = Integer.MAX_VALUE;
    }
    
    public Inbook(String citationKey, String author, String title, int chapter, String publisher, int year,
            int volume, int series, String address, int edition, int month, String note, String key) {
        this.citationKey = citationKey;
        this.author = author;
        this.title = title;
        this.chapter = chapter;
        this.publisher = publisher;
        this.year = year;
        this.volume = volume;
        this.series = series;
        this.address = address;
        this.edition = edition;
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
    
    public int getChapter() {
        return chapter;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getVolume() {
        return volume;
    }
    
    public int getSeries() {
        return series;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getEdition() {
        return edition;
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
}
