/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Observable;
import mvc.model.shape.*;
/**
 *
 * @author Netbeans
 */
public class Model extends Observable {

    MyShape sampleShape;
    MyShape currentShape;
    ArrayList<MyShape> listShape;

    public Model() {
        listShape = new ArrayList<>();
    }

    public void draw(Graphics2D g2) {
        for (MyShape x : listShape) {
            x.draw(g2);
        }

    }

    public void setSampleShape(MyShape sampleShape) {
        this.sampleShape = sampleShape;
    }

    public MyShape actionPressDraw(Point2D[] p) {
        currentShape = sampleShape.clone();
        listShape.add(currentShape);
        setChanged();
        notifyObservers();
        return currentShape;
    }

    public MyShape acctionDragDraw(Point2D[] p) {
        currentShape.getShape().setFrameFromDiagonal(p[0], p[1]);
        setChanged();
        notifyObservers();
        return currentShape;
    }

    public MyShape acctionDragMove(Point2D[] p) {
        if(currentShape!=null){
        double deltaX = p[1].getX()-p[0].getX();
        double deltaY = p[1].getY()-p[0].getY();
        double maxX=currentShape.getShape().getMaxX()+deltaX;
        double maxY=currentShape.getShape().getMaxY()+ deltaY;
        double minX = currentShape.getShape().getMinX()+deltaX;
        double minY = currentShape.getShape().getMinY()+deltaY;
        currentShape.getShape().setFrameFromDiagonal(minX, minY, maxX, maxY);
        p[0]=p[1];
        setChanged();
        notifyObservers();
        }
        return currentShape;
    }

    public MyShape acctionPressMove(Point2D[] p) {
        currentShape=null;
        for (MyShape x : listShape) {
            if (x.getShape().contains(p[0])) {
                currentShape = x;
                return currentShape;
            }
        }
        return currentShape;
    }

}
