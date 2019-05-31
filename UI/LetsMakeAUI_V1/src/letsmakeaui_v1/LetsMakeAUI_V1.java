package letsmakeaui_v1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LetsMakeAUI_V1 {

   public static void main(String[] args) {
        
       JFrame window = new JFrame();
       Circle c = new Circle();
       
       window.setSize(800, 600);
       c.addMouseListener(new HoverListener());
       
       window.add(c);
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       window.setVisible(true);
       
    }
    
}
