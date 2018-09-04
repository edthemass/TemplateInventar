/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templateinventar.engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;

/**
 *
 * @author P01004090
 */
public class Canvas extends JComponent implements Runnable{

    public static final int FPS = 60;
    public static final long MAX_LOOP_TIME = 1000 / FPS;
    public boolean running = true;
    public InitMain initMain;
    
    public Canvas() {
        initMain = new InitMain(this);
        new Thread(this).start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        initMain.render(g2d);
    }
    
    @Override
    public void run() {
        long timestamp, oldTimestamp;
        while(running){
            oldTimestamp = System.currentTimeMillis();
            update();
            timestamp = System.currentTimeMillis();
            if(timestamp - oldTimestamp > MAX_LOOP_TIME) {
                //System.out.println("Wir zu spät!");
                continue;
            }
            render();
            timestamp = System.currentTimeMillis();
            //System.out.println(MAX_LOOP_TIME + " : " + (timestamp - oldTimestamp));
            if(timestamp-oldTimestamp <= MAX_LOOP_TIME) {
                try {
                    Thread.sleep(MAX_LOOP_TIME - (timestamp - oldTimestamp) );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void render(){
        //System.err.println("render");
        repaint();
    }
    
    public void update(){
        //System.err.println("update");
        initMain.update();
    }
}
