package letsmakeaui_v1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class LetsMakeAUI_V1 {

    public static void main(String[] args) {
        
        
        JFrame frame = new JFrame("Hello");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel pan = new JPanel(layout);
        JLabel label = new JLabel("hi");
        JLabel label1 = new JLabel("hi");
        JLabel label2 = new JLabel("hi");
        JLabel label3 = new JLabel("hi");
        JLabel label4 = new JLabel("hi");
        addStuff(pan, label, layout, gbc, 0,0,5,5);
        addStuff(pan, label1, layout, gbc, 1,5,5,5);
        addStuff(pan, label2, layout, gbc, 2,5,5,5);
        addStuff(pan, label3, layout, gbc, 3,5,5,5);
        addStuff(pan, label4, layout, gbc, 4,5,5,5);
        pan.add(label);
        frame.add(pan);
        frame.setVisible(true);
       
    }
    
    public static void addStuff(JPanel p, JLabel l, GridBagLayout layout, GridBagConstraints gbc, int x, int y, int w, int h){
        
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        
        layout.setConstraints(l,gbc);
        p.add(l);
        
    }
    
    public static void yeet(){
        System.out.println("YEET");
    }
}

