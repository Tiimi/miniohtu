package miniohtu.entry;

public class Article {

    // Required fields

    private String id;
    private String author;
    private String title;
    private String journal;
    private int year;

    // Optional fields
    private int volume;
    private int number;
    private String pages;
    private int month;
    private String note;

    public Article(String id, String author, String title, String journal, int year, int volume,
            int number, String pages, int month, String note) {
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
    public Article(String id, String author, String title, String journal, int year) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;

        this.volume = Integer.MAX_VALUE;
        this.number = Integer.MAX_VALUE;
        this.pages = null;
        this.month = Integer.MAX_VALUE;
        this.note = null;
    }

    @Override
    public String toString() {
        return "Article title: " + this.title + " \nWritten by: " + this.author + " - year: " + this.year
                + "\nJournal: " + this.journal + " - volume: " + this.volume;
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

    public int getMonth() {
        return month;
    }

    public String getNote() {
        return note;
    }

}
