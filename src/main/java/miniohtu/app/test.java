/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.app;

import miniohtu.entry.Conference;

/**
 *
 * @author antti
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conference conf = new Conference("cit_key", "author", "title", "booktitle", 1, "editor", 0, "org", "pub", null, 0, null, "key");
        System.out.println(conf);
    }
    
}
