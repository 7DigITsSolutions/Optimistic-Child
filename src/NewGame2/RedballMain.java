/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewGame2;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 *
 * @author mazen
 */
public class RedballMain {

    public RedballMain() {
        JFrame wind = new JFrame("RedBall/GamePinfo");
        RedBall g = new RedBall();
        wind.add(g);
        wind.pack();
        wind.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        wind.setLocationRelativeTo(null);
        wind.setResizable(false);
        wind.setVisible(true);
        wind.addMouseMotionListener(g);

        Timer tt = new Timer(17, g);
        tt.start();

    }

    public static void main(String[] args) {
        new RedballMain();

    }

    public void setVisible(boolean b) {
        System.out.println("ok");
    }

}
