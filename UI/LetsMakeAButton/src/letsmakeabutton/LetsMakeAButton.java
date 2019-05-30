/* 
 * Author: Ryan Ringer
 * Created on: May 29th, 2019
 * File: LetsMakeAButton
 * Purpose: Make a fucking button
 */

package letsmakeabutton;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LetsMakeAButton {

    public static void main(String[] args) {
        // Seed random number or initialize scanner
        
        
        // Constant Variables
        final int X = 800;
        final int Y = 600;

        // Declare all Variables Here
        JFrame window = new JFrame("Button");
        JPanel drawableArea = new JPanel();
        JButton ryan = new JButton("Ryan");
        JButton jazz = new JButton("Jazz");

        // Input or initialize values Here
        ryan.setBounds(10,10,100,100);
        jazz.setBounds(10,10,100,100);
        window.setSize(X,Y);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawableArea.add(ryan);
        drawableArea.add(jazz);
        window.add(drawableArea);
        window.setVisible(true);

        // Process/Calculations Here
        jazz.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("*Click*");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("*Unclick*");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jazz.setBackground(Color.blue);
                jazz.setForeground(Color.yellow);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jazz.setBackground(null);
                jazz.setForeground(null);
            }
        });
        ryan.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("*Click*");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("*Unclick*");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ryan.setBackground(Color.blue);
                ryan.setForeground(Color.yellow);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ryan.setBackground(null);
                ryan.setForeground(null);
            }
            
            });

        // Output Located Here


        // Exit
    }

}
