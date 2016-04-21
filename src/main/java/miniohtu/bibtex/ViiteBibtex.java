package miniohtu.bibtex;

import miniohtu.entry.Article;
import miniohtu.entry.Book;
import miniohtu.entry.Booklet;

public class ViiteBibtex {

    public static String toBibtex(Article article) {
        String bibtex = "@ARTICLE{" + article.getId() + "},\n"
                + "  author = {" + article.getAuthor() + "},\n"
                + "  title = {" + article.getTitle() + "},\n"
                + "  yournal = {" + article.getJournal() + "},\n"
                + "  year = {" + article.getYear() + "},\n"
                + ((article.getNumber() == Integer.MAX_VALUE) ? "" : "  number = " + article.getNumber() + ",\n")
                + ((article.getPages() == null) ? "" : "  pages = {" + article.getPages() + "},\n")
                + ((article.getMonth() == Integer.MAX_VALUE) ? "" : "  month = " + article.getMonth() + ",\n")
                + ((article.getNote() == null) ? "" : "  note = {" + article.getNote() + "},\n")
                + ((article.getVolume() == Integer.MAX_VALUE) ? "" : "  volume = " + article.getVolume() + ",\n")
                + "}";
        return bibtex;
    }

    public static String toBibtex(Book book) {
        String bibtex = "@ARTICLE{" + book.getId() + "},\n"
                + "  author = {" + book.getAuthor() + "},\n"
                + "  title = {" + book.getTitle() + "},\n"
                + "  publisher = {" + book.getPublisher() + "},\n"
                + "  year = {" + book.getYear() + "},\n"
                + ((book.getVolume() == Integer.MAX_VALUE) ? "" : "  volume = " + book.getVolume() + ",\n")
                + ((book.getSeries() == null) ? "" : "  series = {" + book.getSeries() + "},\n")
                + ((book.getAddress() == null) ? "" : "  address = {" + book.getAddress() + "},\n")
                + ((book.getEdition() == Integer.MAX_VALUE) ? "" : "  edition = " + book.getEdition() + ",\n")
                + ((book.getMonth() == null) ? "" : "  month = {" + book.getMonth() + "},\n")
                + ((book.getNote() == null) ? "" : "  note = {" + book.getNote() + "},\n")
                + "}";

        return bibtex;
    }
    
    public static String toBibtex(Booklet booklet) {
        String bibtex = "@BOOKLET{" + booklet.getId() + "},\n"
                + "  title = {" + booklet.getTitle() + "},\n"
                + ((booklet.getAuthor()== null) ? "" : "  author = {" + booklet.getAuthor() + "},\n")            
                + ((booklet.getHowPublished()== null) ? "" : "  howpublished = {" + booklet.getHowPublished()+ "},\n")
                + ((booklet.getAddress() == null) ? "" : "  address = {" + booklet.getAddress() + "},\n")
                + ((booklet.getMonth() == null) ? "" : "  month = {" + booklet.getMonth() + "},\n")
                + ((booklet.getYear() == Integer.MAX_VALUE) ? "" : "  year = {" + booklet.getYear() + "},\n")
                + ((booklet.getNote() == null) ? "" : "  note = {" + booklet.getNote() + "},\n")
                + "}";
        return bibtex;
    }
}
