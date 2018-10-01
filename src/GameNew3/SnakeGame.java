package GameNew3;

import javax.swing.JFrame;

public class SnakeGame {
    

    
    public  SnakeGame() {   
        Window f1= new Window();
        		//Setting up the window settings
		f1.setTitle("Snake");
		f1.setSize(400,400);
		f1.setVisible(true);
               f1.setLocationRelativeTo(null);
                       f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        new SnakeGame();

           

	}

    public void setVisible(boolean b) {
        System.out.println("ok");
    }
}
