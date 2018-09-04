/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateinventar.tools;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

/**
 *
 * @author P01004090
 */
public class Coord {
    
    public static boolean posCheck(MouseEvent e, Image img, Point2D.Double pos){
        if((e.getX() > pos.getX())
        && (e.getY() > pos.getY())
        && (e.getX() < (pos.getX() + img.getWidth(null)))
        && (e.getY() < (pos.getY() + img.getHeight(null)))){
            return true;
        } else {
            return false;
        }
    }
}
