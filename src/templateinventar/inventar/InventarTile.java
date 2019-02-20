/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateinventar.inventar;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import templateinventar.engine.Canvas;


/**
 *
 * @author P01004090
 */
public class InventarTile implements MouseListener{
    
    public String testname;
    public Image img;
    public Point2D.Double pos = new Point2D.Double();
    int height = 12, pic = 2;
    public boolean slotEmpty = true;
    
    public InventarTile(Canvas c, Image img, int x, String n) {
        this.testname = n;
        this.img = img;
        this.pos.setLocation(x, height);
        c.addMouseListener(this);
    }

    public void update(){
        
    }
    
    public void draw(Graphics2D g2d){
        g2d.drawImage(img, (int)pos.getX(), (int)pos.getY(), null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}
    
    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
