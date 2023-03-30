/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.action;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import mvc.model.Model;
import mvc.model.shape.MyShape;

/**
 *
 * @author Netbeans
 */
public enum ActionBehavior {
    Draw{
        

        @Override
        public MyShape actionPress(Model model, Point2D[] p) {
            return model.actionPressDraw(p);
        }

        @Override
        public MyShape actionDrag(Model model, Point2D[] p) {
            return model.acctionDragDraw(p);
        }
    },Move{
        

        @Override
        public MyShape actionPress(Model model, Point2D[] p) {
           return  model.acctionPressMove(p);
        }

        public MyShape actionDrag(Model model, Point2D[] p) {
            return model.acctionDragMove(p);
        }
    };
   
   
    public abstract MyShape actionPress(Model model,Point2D []p);
    public abstract MyShape actionDrag(Model model,Point2D []p);
    
}
