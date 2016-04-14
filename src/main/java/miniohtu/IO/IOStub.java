/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.IO;

import java.util.ArrayList;

/**
 *
 * @author antti
 */
public class IOStub implements IO {

    String[] input;
    int i;
    ArrayList<String> prints;
    
    public IOStub(String[] input) {
        this.input = input;
        i = 0;
        prints = new ArrayList<String>();
    }

    @Override
    public void print(String s) {
        prints.add(s);
    }

    @Override
    public String nextString() {
        if (i>=input.length) return "";
        return input[i++];
    }

    @Override
    public int nextInt() {
        return Integer.parseInt(nextString());
    }
    
    public ArrayList<String> getPrintouts() {
        return prints;
    }
}
