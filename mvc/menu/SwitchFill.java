/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.menu;

import mvc.model.shape.FillBehavior;
import mvc.state.State;

/**
 *
 * @author Netbeans
 */
public class SwitchFill implements Command{

    State state;
    FillBehavior fb;

    public SwitchFill(FillBehavior fb,State state) {
        this.state = state;
        this.fb = fb;
    }

    @Override
    public void execute() {
        state.setFb(fb);
    }
}
