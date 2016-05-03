package miniohtu.entry;

import java.util.Map;
import miniohtu.bibtex.BibtexEncoding;

public class Booklet implements BaseEntry {

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

    public static final String[] mandatoryFields = {"String:citation key", "String:title"};
    public static final String[] optionalFields = {"String:author", "String:howPublished", "String:address", "Integer:month", "Integer:year", "String:note", "String:key"};

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

    public Booklet(Map<String, String> fieldValues) {
        this.citationKey = fieldValues.get("citation key");
        this.title = fieldValues.get("title");
        this.author = fieldValues.get("author");
        this.howPublished = fieldValues.get("howPublished");
        this.address = fieldValues.get("address");
        this.month = Integer.parseInt(fieldValues.get("month"));
        this.year = Integer.parseInt(fieldValues.get("year"));
        this.note = fieldValues.get("note");
        this.key = fieldValues.get("key");
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
        String bibtex = "@BOOKLET{" + this.getCitationKey() + ",\n"
                + "  title = {" + this.getTitle() + "},\n"
                + ((this.getAuthor() == null) ? "" : "  author = {" + this.getAuthor() + "},\n")
                + ((this.getHowPublished() == null) ? "" : "  howpublished = {" + this.getHowPublished() + "},\n")
                + ((this.getAddress() == null) ? "" : "  address = {" + this.getAddress() + "},\n")
                + ((this.getMonth() == Integer.MAX_VALUE) ? "" : "  month = " + this.getMonth() + ",\n")
                + ((this.getYear() == Integer.MAX_VALUE) ? "" : "  year = " + this.getYear() + ",\n")
                + ((this.getNote() == null) ? "" : "  note = {" + this.getNote() + "},\n")
                + "}";
        return BibtexEncoding.encodeToBibtex(bibtex);
    }

    @Override
    public String toString() {
        return "Booklet{" + "citationKey=" + citationKey + ", title=" + title
                + ((this.getAuthor() == null) ? "" : ", author=" + this.getAuthor())
                + ((this.getHowPublished() == null) ? "" : ", howpublished=" + this.getHowPublished())
                + ((this.getAddress() == null) ? "" : ", address=" + this.getAddress())
                + ((this.getMonth() == Integer.MAX_VALUE) ? "" : ", month=" + this.getMonth())
                + ((this.getYear() == Integer.MAX_VALUE) ? "" : ", year=" + this.getYear())
                + ((this.getNote() == null) ? "" : ", note=" + this.getNote())
                + ((this.getKey() == null) ? "" : ", key=" + this.getKey())
                + "}";
    }
}
