/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.IO;

import java.util.Scanner;

/**
 *
 * @author antti
 */
public class ConsoleIO implements IO {
    
    private Scanner scanner;
    
    public ConsoleIO(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public String nextString() {
        return scanner.nextLine();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }

    
}
