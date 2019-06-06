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
        
        JFrame window = new JFrame("Hello");
        window.setSize(800,600);
        JPanel pan = new JPanel();
        WordButton label = new WordButton("you're getting closer");
        
        label.setFont(new Font("Veranda", 1, 20));
        label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yeet();
            }
        });
        GridBagLayout layout = new GridBagLayout();
        pan.setBorder(new LineBorder(Color.BLACK));
        pan.setLayout(layout);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        addStuff(pan, label, layout, gbc, 5, 5, 10, 10);
        
//        gbc.gridx = 5;
//        gbc.gridy = 5;
//        gbc.gridwidth = 10;
//        gbc.gridheight = 10;
//        
//        layout.setConstraints(label, gbc);
//        pan.add(label);


        window.add(pan);
        window.setVisible(true);
        
        
        
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
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

