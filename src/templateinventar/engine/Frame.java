/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateinventar.engine;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author P01004090
 */
public class Frame extends JFrame{

    public Frame(){
        this.setSize(new Dimension(800,400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new Canvas());
        this.setVisible(true);
    }
    
}
