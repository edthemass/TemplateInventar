/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateinventar.objects;

import java.awt.geom.Point2D;
import templateinventar.engine.Canvas;
import templateinventar.engine.Images;

/**
 *
 * @author P01004090
 */
public class ObjectMoney extends Object{

    public ObjectMoney(Canvas c, Images img, Point2D.Double pos, int numbers, int value) {
        super(c, img);
        this.posStart = pos;
        //this.pos = posStart;
        this.numbers = numbers;
        this.value = value;
    }
    
}
