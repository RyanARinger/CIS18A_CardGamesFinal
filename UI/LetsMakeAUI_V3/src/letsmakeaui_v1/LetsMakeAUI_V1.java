package letsmakeaui_v1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class LetsMakeAUI_V1 {

    public static void main(String[] args) {
        
    JFrame frame = new JFrame();
    frame.setLayout(new GridBagLayout());
    JPanel panel = new JPanel();
    JLabel jlabel = new JLabel("This is a label");
    jlabel.setFont(new Font("Verdana",1,20));
    panel.add(jlabel);
    panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
    frame.add(panel, new GridBagConstraints());
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
       
       
    }
    
    public static void sixtyNine(){
        System.out.println("69");
    }
    
}

