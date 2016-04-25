/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.app;

import miniohtu.bibtex.BibtexEncoding;

/**
 *
 * @author antti
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "" + (char) 1000;
        System.out.println(BibtexEncoding.encodeBibtexEncoding(s));
    }
    
}
