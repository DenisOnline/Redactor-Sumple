/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.menu;

import java.awt.Color;
import javax.swing.JColorChooser;
import mvc.state.State;

/**
 *
 * @author Netbeans
 */
public class SwitchColor implements Command {

    Color c;
    State state;

    public SwitchColor(State state) {
        this.state = state;
    }

    @Override
    public void execute() {
        Color c = JColorChooser.showDialog(null, "choose color", Color.BLACK);
        state.setColor(c);
    }
}
