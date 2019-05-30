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
        
        boolean done = false;

        // Input or initialize values Here
        
        window.setSize(X,Y);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        window.add(drawableArea);
        window.setVisible(true);

        // Process/Calculations Here
        while(!done){
            OptionButton ryan = new OptionButton();
            ryan.setBounds(10,10,100,100);
            drawableArea.add(ryan);
        }

        // Output Located Here


        // Exit
    }

}
