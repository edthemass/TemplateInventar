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
    Point2D.Double posStart = new Point2D.Double();
    Point2D.Double pos = new Point2D.Double();
    Point2D.Double posAnker = new Point2D.Double();
    boolean inTouch = false;
    Canvas c;
    
    public LevelObject(Canvas c, Images img) {
        this.c = c;
        this.img = img;
        posStart.setLocation(200,200);
        pos.setLocation(posStart);
        c.addMouseListener(this);
        c.addMouseMotionListener(this);
    }

    public void update(){
        
    }
    
    public void render(Graphics2D g2d){
        g2d.drawImage(img.getImg(pic), (int) pos.getX(), (int) pos.getY(), null);   
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if(Coord.posCheck(e, img.getImg(pic), pos) // CHECK OB ITEM BERÜHRT WIRD
        && (e.getButton() == 1)){ // CHECK OB LINKER MOUSE BUTTON GEDRÜCKT IST
            inTouch = true;
            // TODO !!! ANKER (1)
            posAnker.setLocation(pos.getX() - e.getX(), pos.getY() - e.getY());
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if(inTouch){
            // TODO !!! ANKER (2)
            pos.setLocation(e.getX() + posAnker.getX(), e.getY() + posAnker.getY());
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if((e.getButton() == 1) 
        && (inTouch)){
            for(int i = 0; i < c.initMain.inv.tileList.size(); i++){
                if(Coord.posCheck(e, c.initMain.inv.tileList.get(i).img.getImg(pic), c.initMain.inv.tileList.get(i).pos)){
                    // BRING DAS ITEM IN DEN IVENTAR SLOT
                    System.err.println("hit " + c.initMain.inv.tileList.get(i).testname);inTouch = false;
                    pos.setLocation(c.initMain.inv.tileList.get(i).pos);
                    break;
                } else {
                    // SPRINGE ZURÜCK ZUR START POSITION
                    pos.setLocation(posStart);
                }
            }
            inTouch = false;
            System.err.println(inTouch);
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
}
