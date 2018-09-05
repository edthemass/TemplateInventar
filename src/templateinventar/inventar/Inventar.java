/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateinventar.inventar;

import java.awt.Graphics2D;
import java.util.ArrayList;
import templateinventar.engine.Canvas;
import templateinventar.engine.Images;

/**
 *
 * @author P01004090
 */
public class Inventar {
    
    private final Images img;
    public final ArrayList<InventarTile> tileList = new ArrayList<InventarTile>();
    
    public Inventar(Canvas c, Images img) {
        this.img = img;
        int height = 10;// Normal 10
        
        tileList.add(new InventarTile(c, img.getImg(4), 20, "s1"));
        tileList.add(new InventarTile(c, img.getImg(4), 110, "s2"));
        tileList.add(new InventarTile(c, img.getImg(4), 200, "s3"));
        tileList.add(new InventarTile(c, img.getImg(4), 290, "s4"));
        tileList.add(new InventarTile(c, img.getImg(4), 380, "s5"));
        tileList.add(new InventarTile(c, img.getImg(4), 470, "s6"));
    }
    
    public void update(){
        
    }
    
    public void render(Graphics2D g2d){
        g2d.drawRect(10, 10, 10, 10);
        //Inventar Rahmen
        g2d.drawImage(img.getImg(1), 0, 0, null);
        //
        for(int i = 0; i < tileList.size(); i++){
            tileList.get(i).draw(g2d);
        }
        

//Inventar tile from 0-5
//        g2d.drawImage(img.getImg(2), (int)s0.getX(), (int)s0.getY(), null);
//        g2d.drawImage(img.getImg(2), (int)s1.getX(), (int)s1.getY(), null);
//        g2d.drawImage(img.getImg(2), (int)s2.getX(), (int)s2.getY(), null);
//        g2d.drawImage(img.getImg(2), (int)s3.getX(), (int)s3.getY(), null);
//        g2d.drawImage(img.getImg(2), (int)s4.getX(), (int)s4.getY(), null);
//        g2d.drawImage(img.getImg(2), (int)s5.getX(), (int)s5.getY(), null);
    }
    
}
