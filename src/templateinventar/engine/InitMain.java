/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateinventar.engine;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import templateinventar.inventar.Inventar;
import templateinventar.objects.ObjectMoney;

/**
 *
 * @author P01004090
 */
public class InitMain {
    
    public Images img;
    public Inventar inv;
    //Object lo;
    public ObjectMoney money;
    
    public InitMain(Canvas c) {
        this.img = new Images();
        inv = new Inventar(c, img);
        money = new ObjectMoney(c, img.getImg(4), new Point2D.Double(300,300), 34, 1);
    }
    
    public void update(){
        inv.update();
        money.update();
    }
    
    public void render(Graphics2D g2d){
        
        inv.render(g2d);
        money.render(g2d);
    }
    
}
