package miniohtu.bibtex;

import miniohtu.entry.Article;
import miniohtu.entry.Book;

public class ViiteBibtex {

    public static String toBibtex(Article a) {
        String bibtex = "@ARTICLE{" + a.getId() + "},\n"
                + "  author = {" + a.getAuthor() + "},\n"
                + "  title = {" + a.getTitle() + "},\n"
                + "  yournal = {" + a.getJournal() + "},\n"
                + "  year = {" + a.getYear() + "},\n"
                + ((a.getNumber() == Integer.MAX_VALUE) ? "" : "  number = " + a.getNumber() + ",\n")
                + ((a.getPages() == null) ? "" : "  pages = {" + a.getPages() + "},\n")
                + ((a.getMonth() == null) ? "" : "  month = " + a.getMonth() + ",\n")
                + ((a.getNote() == null) ? "" : "  note = {" + a.getNote() + "},\n")
                + "  volume = " + a.getVolume() + ",\n"
                + "}";
        return bibtex;
    }
    
    public static String toBibtex(Book b) {
        return null;
    }
}
