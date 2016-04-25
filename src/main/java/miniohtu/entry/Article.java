package miniohtu.entry;

import miniohtu.bibtex.BibtexEncoding;

public class Article implements BaseEntry{

    // Required fields

    private String citationKey;
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

    public Article(String citationKey, String author, String title, String journal, int year, int volume,
            int number, String pages, int month, String note) {
        this.citationKey = citationKey;
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
    public Article(String citationKey, String author, String title, String journal, int year) {
        this.citationKey = citationKey;
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
    public String toBibtex() {
        String bibtex = "@ARTICLE{" + this.getCitationKey() + "},\n"
                + "  author = {" + this.getAuthor() + "},\n"
                + "  title = {" + this.getTitle() + "},\n"
                + "  yournal = {" + this.getJournal() + "},\n"
                + "  year = " + this.getYear() + ",\n"
                + ((this.getNumber() == Integer.MAX_VALUE) ? "" : "  number = " + this.getNumber() + ",\n")
                + ((this.getPages() == null) ? "" : "  pages = {" + this.getPages() + "},\n")
                + ((this.getMonth() == Integer.MAX_VALUE) ? "" : "  month = " + this.getMonth() + ",\n")
                + ((this.getNote() == null) ? "" : "  note = {" + this.getNote() + "},\n")
                + ((this.getVolume() == Integer.MAX_VALUE) ? "" : "  volume = " + this.getVolume() + ",\n")
                + "}";
        return BibtexEncoding.encodeBibtexEncoding(bibtex);
    }

    @Override
    public String toString() {
        return "Article title: " + this.title + " \nWritten by: " + this.author + " - year: " + this.year
                + "\nJournal: " + this.journal + " - volume: " + this.volume;
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
