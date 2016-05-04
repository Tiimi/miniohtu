/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.UI;

import miniohtu.IO.IO;

/**
 *
 * @author leokallo
 */
public class Unknown implements Command {
    private final IO io;
    private final String komento;

    public Unknown(IO io, String command) {
        this.io = io;
        this.komento = command;
    }

    @Override
    public void execute() {
        io.print("Viite tyyppiä: " + komento + " ei ole.\n\n");
    }
    
}
