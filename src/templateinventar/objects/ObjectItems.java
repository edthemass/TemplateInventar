/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateinventar.objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import templateinventar.engine.Canvas;

/**
 *
 * @author P01004090
 */
public class ObjectItems extends Object{

    public ObjectItems(Canvas c, Image img, Point2D.Double pos, int numbers, int value, String name) {
        super(c, img);
        setStartPos(pos);
        this.name = name;
        this.numbers = numbers;
        this.value = value;
    }
    
    @Override
    public void render(Graphics2D g2d){
        // TODO IMAGE ITEM
        g2d.drawImage(imgFrame, (int) pos.getX(), (int) pos.getY(), null);   
        g2d.drawString(Integer.toString(numbers), (int) pos.getX() + 5, (int) pos.getY() + 20);
        // TEST
        g2d.drawString(name, (int) pos.getX() + 5, (int) pos.getY() + 40);
    }
}
