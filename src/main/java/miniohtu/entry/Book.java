
package miniohtu.entry;

public class Book {
    // Required fields
    private String id;
    private String author;
    private String title;
    private String journal;
    private int year;
    private int volume;
    
    // Optional fields
    private int number;
    private String series;
    private String address;
    private int edition;
    private String month;
    private String note;
    private String key;
    
    public Book(String id, String author, String title, String journal, int year, int volume,
            int number, String series, String address, int edition, String month, String note, String key) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this.volume = volume;
        
        this.number = number;
        this.series = series;
        this.address = address;
        this.edition = edition;
        this.month = month;
        this.note = note;
        this.key = key;
    }
    
    public Book(String id, String author, String title, String journal, int year, int volume) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this.volume = volume;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getJournal() {
        return journal;
    }

    public int getYear() {
        return year;
    }

    public int getVolume() {
        return volume;
    }

    public int getNumber() {
        return number;
    }

    public String getSeries() {
        return series;
    }

    public String getAddress() {
        return address;
    }

    public int getEdition() {
        return edition;
    }

    public String getMonth() {
        return month;
    }
 
    public String getNote() {
        return note;
    }

    public String getKey() {
        return key;
    }
    
    
}
