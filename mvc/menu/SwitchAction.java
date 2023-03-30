/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.menu;

import mvc.model.action.ActionBehavior;
import mvc.state.State;

/**
 *
 * @author Netbeans
 */
public class SwitchAction implements Command{
    ActionBehavior ab;
    State state;

    public SwitchAction(ActionBehavior ab, State state) {
        this.ab = ab;
        this.state = state;
    }

   
    @Override
    public void execute() {
        state.setAction(ab);
    }
    
}
