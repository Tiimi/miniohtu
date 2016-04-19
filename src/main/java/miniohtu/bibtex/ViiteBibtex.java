/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.bibtex;

import miniohtu.entry.Article;

/**
 *
 * @author antti
 */
public class ViiteBibtex {
    
    public static String toBibtexEntry(Article a) {
        String bibtex = "@ARTICLE{" + a.getId() + "},\n"
                + "  author = {" + a.getAuthor() + "},\n"
                + "  title = {" + a.getTitle() +  "},\n"
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
    
}
