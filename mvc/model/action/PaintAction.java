/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.action;

import java.awt.geom.Point2D;
import mvc.model.Model;
import mvc.model.shape.MyShape;

/**
 *
 * @author Netbeans
 */
public class PaintAction {

    Model model;
    Point2D[] p;
    MyShape shape;
    ActionBehavior ab;

    public PaintAction( ActionBehavior ab) {
        this.ab = ab;
    }

    

    public void setAb(ActionBehavior ab) {
        this.ab = ab;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public PaintAction() {
        p = new Point2D[2];
    }
    
    public MyShape getShape() {
        return shape;
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }

    public void actionPress(Point2D p) {
        this.p[0] = p;
        shape =  ab.actionPress(model, this.p);

    }

    public void actionDrag(Point2D p1) {
        this.p[1] = p1;
        shape =  ab.actionDrag(model, this.p);
    }
}
