/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import mvc.controller.Controller;

/**
 *
 * @author Netbeans
 */
public class MyPanel extends JPanel implements Observer{

    Controller c;

    public MyPanel(Controller c) {
        this.c = c;
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                c.mousePressed(e.getPoint());
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                c.mouseDragged(e.getPoint());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        c.draw(g2);
    }

    public void setC(Controller c) {
        this.c = c;
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

}
