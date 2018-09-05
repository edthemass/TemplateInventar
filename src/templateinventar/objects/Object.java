/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateinventar.objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import templateinventar.engine.Canvas;
import templateinventar.tools.Coord;

/**
 *
 * @author P01004090
 */
public class Object implements MouseListener, MouseMotionListener{

    Image imgFrame;
    int numbers = 1, value = 1, weight = 1;
    Point2D.Double posStart = new Point2D.Double();
    Point2D.Double pos = new Point2D.Double();
    Point2D.Double posAnker = new Point2D.Double();
    boolean inTouch = false;
    Canvas c;
    
    public Object(Canvas c, Image img) {
        this.c = c;
        this.imgFrame = img;
        setListener(c);
    }
    
    public void setStartPos(Point2D.Double p){
        posStart.setLocation(p);
        pos.setLocation(posStart);
    }
    
    private void setListener(Canvas c){
        c.addMouseListener(this);
        c.addMouseMotionListener(this);
    }

    public void update(){
        
    }
    
    public void render(Graphics2D g2d){
        g2d.drawImage(imgFrame, (int) pos.getX(), (int) pos.getY(), null);   
        g2d.drawString(Integer.toString(numbers), (int) pos.getX() + 5, (int) pos.getY() + 20);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(Coord.posCheck(e, imgFrame, pos) // CHECK OB ITEM BERÜHRT WIRD
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
            // SET FLAG NACH ABZUG DES ITEMS AUS DEM SLOT AUF: EMPTY_SLOT = TRUE;
            for(int i = 0; i < c.initMain.inv.tileList.size(); i++){
                if(Coord.posCheck(e, c.initMain.inv.tileList.get(i).img, c.initMain.inv.tileList.get(i).pos)){
                    c.initMain.inv.tileList.get(i).slotEmpty = true;
                    break;
                }
            }
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if((e.getButton() == 1) 
        && (inTouch)){
            for(int i = 0; i < c.initMain.inv.tileList.size(); i++){
                if((Coord.posCheck(e, c.initMain.inv.tileList.get(i).img, c.initMain.inv.tileList.get(i).pos))
                && (c.initMain.inv.tileList.get(i).slotEmpty)){
                    // BRING DAS ITEM IN DEN IVENTAR SLOT
                    pos.setLocation(c.initMain.inv.tileList.get(i).pos);
                    c.initMain.inv.tileList.get(i).slotEmpty = false;
                    break;
                } else {
                    // SPRINGE ZURÜCK ZUR START POSITION
                    pos.setLocation(posStart);
                }
            }
            inTouch = false;
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
}
