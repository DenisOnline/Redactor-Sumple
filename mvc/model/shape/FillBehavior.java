/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.shape;

import java.awt.Graphics2D;

/**
 *
 * @author Netbeans
 */
public enum FillBehavior {
    Fill{
        @Override
        public void draw(MyShape s, Graphics2D g) {
            g.fill(s.getShape());
        }
    },
    NoFill{
        @Override
        public void draw(MyShape s, Graphics2D g) {
            g.draw(s.getShape());
        }
    };
    public abstract void draw(MyShape s,Graphics2D g);
    
}
