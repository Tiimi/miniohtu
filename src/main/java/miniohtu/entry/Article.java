
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
    
    public Article(String id, String author, String title, String journal, int year, int volume, 
            int number, String pages, String month, String note) {
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
    }
    
    // Required fields only.
    public Article(String id, String author, String title, String journal, int year, int volume) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this. volume = volume;
        
        this.number = Integer.MAX_VALUE;
        this.pages = null;
        this.month = null;
        this.note = null;
    }

    @Override
    public String toString() {
        return "Article title: " + this.title + " \nWritten by: " + this.author + " - year: " + this.year +
                "\nJournal: " + this.journal + " - volume: " + this.volume;
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

}
