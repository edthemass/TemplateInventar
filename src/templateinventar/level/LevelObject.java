/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateinventar.level;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import templateinventar.engine.Canvas;
import templateinventar.engine.Images;
import templateinventar.tools.Coord;

/**
 *
 * @author P01004090
 */
public class LevelObject implements MouseListener, MouseMotionListener{

    Images img;
    int pic = 3;
    Point2D.Double pos = new Point2D.Double();
    
    public LevelObject(Canvas c, Images img) {
        this.img = img;
        pos.setLocation(200,200);
        c.addMouseListener(this);
        c.addMouseMotionListener(this);
    }

    public void update(){
        
    }
    
    public void render(Graphics2D g2d){
        //g2d.drawRect(10, 10, 10, 10);
        g2d.drawImage(img.getImg(pic), (int) pos.getX(), (int) pos.getY(), null);   
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        if(Coord.posCheck(e, img.getImg(pic), pos)){
//            System.err.println("clicked item");
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(Coord.posCheck(e, img.getImg(pic), pos)){
            System.err.println("clicked item");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}
