/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.entry;

import miniohtu.IO.IO;

/**
 *
 * @author leokallo
 */
public abstract class AddOperation implements Command {
    
    protected final String mandatoryFields = "Syötä pakolliset kentät\n";
    protected final String optionalFields = "\nSyötä valinnaiset kentät:\n";
    protected IO io;
    
    public AddOperation(IO io) {
        this.io = io;
    }
    
    protected int askInteger(String kentanNimi) {
        int kokonaisluku = 0;
        while (true) {
            io.print(kentanNimi + ": ");
            try {
                kokonaisluku = io.nextInt();
                break;
            } catch (NumberFormatException e) {
                io.print("Virhe: anna kokonaisluku\n");
            }
        }

        return kokonaisluku;
    }

    protected String askString(String kentanNimi) {
        io.print(kentanNimi + ": ");
        return io.nextString();
    }
    
    protected String askOptionalString(String fieldValue) {
        String s = askString(fieldValue);
        if (s.isEmpty() || s == "") {
            return null;
        }
        return s;
    }
    
    protected int askOptionalInteger(String fieldValue) {
        while(true) {
            String s = askOptionalString(fieldValue);
            if (s == null) {
                return Integer.MAX_VALUE;
            }
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                io.print("Virhe: anna kokonaisluku tai tyhjä.\n");
            }
        }        
    }
}
