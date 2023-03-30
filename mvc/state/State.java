/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.state;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import mvc.model.Model;
import mvc.model.action.ActionBehavior;
import mvc.model.action.PaintAction;
import mvc.model.shape.FillBehavior;
import mvc.model.shape.MyShape;
import mvc.view.MyFrame;
import mvc.view.MyPanel;

/**
 *
 * @author Netbeans
 */
public class State {
    Model model;
    MyShape sampleShape;
    PaintAction action;

    public State(Model model) {
        this.model = model;
        sampleShape = new MyShape(new Rectangle2D.Double(), FillBehavior.Fill, Color.BLUE);
        model.setSampleShape(sampleShape);
        action = new PaintAction();
        action.setAb(ActionBehavior.Draw);
        action.setModel(model);
    }

    public State() {
    }

    public void setAction(PaintAction action) {
        this.action = action;
    }

    public PaintAction getAction() {
        return action;
    }

    public MyShape getSampleShape() {
        return sampleShape;
    }

    public void setSampleShape(MyShape sampleShape) {
        this.sampleShape = sampleShape;
    }

    public void setAction(ActionBehavior actionBehavior) {
        action.setAb(actionBehavior);
    }

    public void setRectangularShape(RectangularShape rs) {
        sampleShape.setShape(rs);
        model.setSampleShape(sampleShape);
    }

    public void setColor(Color c) {
        sampleShape.setColor(c);
        model.setSampleShape(sampleShape);
    }

    public void setFb(FillBehavior fb) {
        sampleShape.setFb(fb);
        model.setSampleShape(sampleShape);
    }
    
    
}
