/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import mvc.model.Model;
import mvc.state.State;
import mvc.view.MyFrame;
import mvc.view.MyPanel;

/**
 *
 * @author Netbeans
 */
public class Controller {

    Model model;
    MyFrame frame;
    MyPanel panel;
    State state;
            

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }

    public Controller() {
        model = new Model();
        state = new State(model);
        panel = new MyPanel(this);
        model.addObserver(panel);
        frame = new MyFrame(state);
        frame.setPanel(panel);
        
    }

    public void mousePressed(Point point) {
        state.getAction().actionPress(point);
    }

    public void mouseDragged(Point point) {
        state.getAction().actionDrag(point);
    }

    

}
