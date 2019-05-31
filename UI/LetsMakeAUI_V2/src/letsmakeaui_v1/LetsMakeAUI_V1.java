package letsmakeaui_v1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LetsMakeAUI_V1 {

   public static void main(String[] args) {
        
       JFrame window = new JFrame();
       ClickablePanel pan = new ClickablePanel();
       
       pan.addActionListener(new ActionListener () {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println("CLICK");
           }
       });
       pan.setVisible(true);
       
       window.setSize(800, 600);
       
       window.add(pan);
       
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       window.setVisible(true);
       
    }
    
}
