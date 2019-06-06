/* 
 * Author: Ryan Ringer
 * Created on: 
 * File:
 * Purpose:
 */

package javaapplication19;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JavaApplication19 {

    public static void main(String[] args) {
        // Seed random number or initialize scanner


        // Constant Variables
        

        // Declare all Variables Here
        JFrame window = new JFrame("hello");
        window.setSize(800,600);
        
        JPanel post = new JPanel(new CardLayout());
        JPanel pan = new JPanel(new GridBagLayout());
        JPanel pan1 = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints c1 = new GridBagConstraints();
        
        JLabel label = new JLabel("Hello");
        JButton b1 = new JButton("Hello");
        b1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout cl = (CardLayout)(post.getLayout());
                cl.next(post);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        JLabel label1 = new JLabel("Goodbye");
        JButton b2 = new JButton("Goodbye");
        b2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        pan.add(label, c);
        
        c.gridx = 0;
        c.gridy = 1;
        pan.add(b1, c);
        
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        pan1.add(label1, c);
        
        c.gridx = 0;
        c.gridy = 1;
        pan1.add(b2, c);
        
        post.add(pan , "c1");
        post.add(pan1, "c2");
        
        window.add(post);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        // Input or initialize values Here


        // Process/Calculations Here


        // Output Located Here


        // Exit
    }

}
