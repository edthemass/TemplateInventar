/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateinventar.engine;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author P01004090
 */
public class Images {
    private final String PATH = "src\\images\\";
    private String[] SOURCE = {"car.png", "inventar.png", "tile.png", "cash.png", "empty.png"};
    private ArrayList<Image> image;
    private BufferedImage img = null;

    public Images() {
        image = new ArrayList<Image>();
        try {
            for (String SOURCE1 : SOURCE) {
                img = ImageIO.read(new File(PATH + SOURCE1));
                image.add(img);
            } 
        } catch (IOException ex) {
            Logger.getLogger(Images.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Image getImg(int i){
        return image.get(i);
    }
}
