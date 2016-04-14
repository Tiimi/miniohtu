
package miniohtu.entry;

public class Article {
    // Required fields
    private String id;
    private String author;
    private String title;
    private String journal;
    private int year;
    private int volume;
    
    // Optional fields
    private int number;
    private String pages;
    private String month;
    private String note;
    private String key;
    
    public Article(String id, String author, String title, String journal, int year, int volume, 
            int number, String pages, String month, String note, String key) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this.volume = volume;
        
        this.number = number;
        this.pages = pages;
        this.month = month;
        this.note = note;
        this.key = key;
    }
    
    // Required fields only.
    public Article(String id, String author, String title, String journal, int year, int volume) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this. volume = volume;
        
        this.number = -1;
        this.pages = null;
        this.month = null;
        this.note = null;
        this.key = null;
    }

    @Override
    public String toString() {
        return "Article title: " + this.title + " \nWritten by: " + this.author;
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

    public String getPages() {
        return pages;
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
