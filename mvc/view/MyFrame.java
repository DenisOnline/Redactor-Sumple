/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import mvc.menu.SwitchAction;
import mvc.menu.SwitchColor;
import mvc.menu.SwitchState;
import mvc.menu.SwitchFill;
import mvc.menu.SwitchShape;
import mvc.model.action.ActionBehavior;
import static mvc.model.action.ActionBehavior.Draw;
import static mvc.model.action.ActionBehavior.Move;
import mvc.model.shape.FillBehavior;
import mvc.model.shape.MyShape;
import mvc.state.State;

/**
 *
 * @author Netbeans
 */
public class MyFrame extends JFrame {

    MyPanel panel;
    State state;

    public void setPanel(MyPanel panel) {
        this.panel = panel;
        add(panel);
    }

    public MyFrame(State state) {
        this.state = state;
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        ArrayList<Action> menuItems = new ArrayList<>();
//        menuItems.add(new SwitchEntity("открыть файл", new ImageIcon("rectangle.gif"),
//                new OpenFile(state)));
//        menuItems.add(new SwitchEntity("создать файл", new ImageIcon("rectangle.gif"),
//                new SaveFile(state)));
        menuItems.add(new SwitchState("прямоугольник", new ImageIcon("rectangle.gif"),
                new SwitchShape(new Rectangle2D.Double(),state)));
        menuItems.add(new SwitchState("овал", new ImageIcon("ellipse.gif"),
                new SwitchShape(new Ellipse2D.Double(),state)));
        menuItems.add(new SwitchState("незалитый", new ImageIcon("nofill.gif"),
                new SwitchFill( FillBehavior.NoFill,state)));
        menuItems.add(new SwitchState("залитый", new ImageIcon("fill.gif"),
                new SwitchFill( FillBehavior.Fill,state)));
        menuItems.add(new SwitchState("рисовать", new ImageIcon("draw.gif"),
                new SwitchAction( Draw,state)));
        menuItems.add(new SwitchState("двигать", new ImageIcon("move.gif"),
                new SwitchAction( Move,state)));
//        menuItems.add(new SwitchUndo("undo", new ImageIcon("undo.gif"), undoMachine));
//        menuItems.add(new SwitchRedo("redo", new ImageIcon("redo.gif"), undoMachine));
        menuItems.add(new SwitchState("выбор цвета", new ImageIcon("colors.gif"),
                new SwitchColor(state)));

        ArrayList<JMenu> menus = new ArrayList<>();
       // menus.add(new JMenu("Файл"));
        menus.add(new JMenu("Фигура"));
        menus.add(new JMenu("Заливка"));
        menus.add(new JMenu("Действие"));
       // menus.add(new JMenu("Undo/redo"));
        menus.add(new JMenu("Цвет"));
        int i = 0;
        int k = menuItems.size()-2;
        for (JMenu m : menus) {
            menuBar.add(m);
            
            if (i < k) {
                m.add(menuItems.get(i));
                m.add(menuItems.get(i + 1));
                i += 2;
            } else {
                m.add(menuItems.get(i));
            }
        }
        JToolBar toolBar = new JToolBar();
        for (Action x : menuItems) {
            toolBar.add(x);
        }

        add(toolBar, BorderLayout.NORTH);

//////////////////////////////////////////////////////////////
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

}
