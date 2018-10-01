/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Omar-LT
 */
public class Video1 extends JFrame {

    /**
     * @param args the command line arguments
     */
    public Video1() {
        NativeInterface.open();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("YouTube Video");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(getBrowser(), BorderLayout.CENTER);
                frame.setSize(400, 300);
                frame.setVisible(true);
            }
        });

        NativeInterface.runEventPump();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                NativeInterface.close();
            }
        }));

    }

    public static JPanel getBrowser() {
        JPanel wbPanel = new JPanel(new BorderLayout());
        JWebBrowser wb = new JWebBrowser();
        wbPanel.add(wb, BorderLayout.CENTER);
        wb.setBarsVisible(false);
        wb.navigate("https://youtu.be/An2OaIbPSII");
        return wbPanel;

    }

    public static void main(String[] args) {
       new Video1();

    }

}
