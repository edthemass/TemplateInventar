/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateinventar.engine;

import java.awt.Graphics2D;
import templateinventar.inventar.Inventar;
import templateinventar.objects.InvObject;

/**
 *
 * @author P01004090
 */
public class InitMain {
    
    public Images img;
    public Inventar inv;
    InvObject lo;
    
    public InitMain(Canvas c) {
        this.img = new Images();
        inv = new Inventar(c, img);
        lo = new InvObject(c, img);
    }
    
    public void update(){
        inv.update();
        lo.update();
    }
    
    public void render(Graphics2D g2d){
        //g2d.drawRect(10, 10, 10, 10);
        //g2d.drawImage(img.getImg(0), 0, 0, null);
        
        inv.render(g2d);
        lo.render(g2d);
    }
    
}
