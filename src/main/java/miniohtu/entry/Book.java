
package miniohtu.entry;

public class Book implements BaseEntry{
    // Required fields
    private String citationKey;
    private String author;
    private String title;
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
    
    public Book(String citationKey, String author, String title, String publisher, int year, 
            int volume, int series, String address, int edition, int month, String note, String key) {
        this.citationKey = citationKey;
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
    
    public Book(String citationKey, String author, String title, String publisher, int year) {
        this.citationKey = citationKey;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        
        this.volume = Integer.MAX_VALUE;
        this.series = Integer.MAX_VALUE;
        this.edition = Integer.MAX_VALUE;
        this.month = Integer.MAX_VALUE;
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
    
    public String toBibtex() {
        String bibtex = "@ARTICLE{" + this.getCitationKey() + "},\n"
                + "  author = {" + this.getAuthor() + "},\n"
                + "  title = {" + this.getTitle() + "},\n"
                + "  publisher = {" + this.getPublisher() + "},\n"
                + "  year = " + this.getYear() + ",\n"
                + ((this.getVolume() == Integer.MAX_VALUE) ? "" : "  volume = " + this.getVolume() + ",\n")
                + ((this.getSeries() == Integer.MAX_VALUE) ? "" : "  series = " + this.getSeries() + ",\n")
                + ((this.getAddress() == null) ? "" : "  address = {" + this.getAddress() + "},\n")
                + ((this.getEdition() == Integer.MAX_VALUE) ? "" : "  edition = " + this.getEdition() + ",\n")
                + ((this.getMonth() == Integer.MAX_VALUE) ? "" : "  month = " + this.getMonth() + ",\n")
                + ((this.getNote() == null) ? "" : "  note = {" + this.getNote() + "},\n")
                + "}";

        return bibtex;
    }

    @Override
    public String toString() {
        return "Book{" + "citationKey=" + citationKey + ", author=" + author + ", title=" + title + ", publisher=" + publisher + ", year=" + year + ", volume=" + volume + ", series=" + series + ", address=" + address + ", edition=" + edition + ", month=" + month + ", note=" + note + ", key=" + key + '}';
    }


    
    
}
