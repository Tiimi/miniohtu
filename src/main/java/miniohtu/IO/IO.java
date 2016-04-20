/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.IO;

/**
 *
 * @author antti
 */
public interface IO {
    
    public void print(String s);
    public String nextString();
    public int nextInt() throws NumberFormatException;
    
}
