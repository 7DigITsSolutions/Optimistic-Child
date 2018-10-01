/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NewGame1;

/**
 *
 * @author Max
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.nio.file.Files.size;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main_play extends JFrame {
    final static int WINDOW_WIDTH = 600;
    final static int WINDOW_HEIGHT = 400;

    public Main_play() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new GamePanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_play();
    }
}
