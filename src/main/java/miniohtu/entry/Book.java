
package miniohtu.entry;

public class Book {
    // Required fields
    private String id;
    private String author;
    private String title;
    private String publisher;
    private int year;
    
    // Optional fields
    private int volume;
    private String series;
    private String address;
    private int edition;
    private String month;
    private String note;
    private String key;
    
    public Book(String id, String author, String title, String publisher, int year, int volume,
            String series, String address, int edition, String month, String note, String key) {
        this.id = id;
        this.author = author;
        this.title = title;
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
    
    public Book(String id, String author, String title, String publisher, int year) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        
        this.volume = Integer.MAX_VALUE;
        this.edition = Integer.MAX_VALUE;
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

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getVolume() {
        return volume;
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

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", author=" + author + ", title=" + title + ", publisher=" + publisher + ", year=" + year + ", volume=" + volume + ", series=" + series + ", address=" + address + ", edition=" + edition + ", month=" + month + ", note=" + note + ", key=" + key + '}';
    }


    
    
}
