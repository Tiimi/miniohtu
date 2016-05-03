/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.UI;

import miniohtu.UI.Command;
import miniohtu.IO.IO;

/**
 *
 * @author leokallo
 */
public class Cancel implements Command {
    private final IO io;

    public Cancel(IO io) {
        this.io = io;
    }

    @Override
    public void execute() {
    }
    
}
