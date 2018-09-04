/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateinventar.inventar;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import templateinventar.engine.Canvas;
import templateinventar.engine.Images;
import templateinventar.tools.Coord;

/**
 *
 * @author P01004090
 */
public class InventarTile implements MouseListener{
    
    String testname;
    Images img;
    Point2D.Double pos = new Point2D.Double();
    int height = 12, pic = 2;
    
    public InventarTile(Canvas c, Images img, int x, String n) {
        this.testname = n;
        this.img = img;
        this.pos.setLocation(x, height);
        c.addMouseListener(this);
    }

    public void update(){
        
    }
    
//    private boolean posCheck(MouseEvent e, int pic, Point2D.Double pos){
//        if((e.getX() > pos.getX())
//        && (e.getY() > pos.getY())
//        && (e.getX() < (pos.getX() + img.getImg(pic).getWidth(null)))
//        && (e.getY() < (pos.getY() + img.getImg(pic).getHeight(null)))){
//            return true;
//        } else {
//            return false;
//        }
//    }
    
    public void draw(Graphics2D g2d){
        g2d.drawImage(img.getImg(2), (int)pos.getX(), (int)pos.getY(), null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if(Coord.posCheck(e, img.getImg(pic), pos)){
            System.err.println("pressed " + testname + e.getPoint());
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
