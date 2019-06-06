package javaapplication2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;



public class WordButton extends JLabel{
    
    private final ArrayList<ActionListener> actionListeners;
    private boolean ifNeeded;
    
    public WordButton(String s){
        super(s);
        this.setFont(new Font("Veranda", 1, 20));
        actionListeners = new ArrayList();
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                WordButton.this.performAction();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                enter();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exit();
            }
        });           
    }
    
    public void setIN(boolean i){
        this.ifNeeded = i;
    }
    public boolean getIN(){
        return this.ifNeeded;
    }
    public void addActionListener(ActionListener al){
        this.actionListeners.add(al);
    }
    
    public void performAction(){
        for(int i = 0; i < actionListeners.size() ; i++) {
            actionListeners.get(i).actionPerformed(new ActionEvent(this,0,"Click"));
        }
    }
    
    public void enter(){
        this.setFont(new Font("Veranda", 1, 41));
        this.setForeground(Color.red);
    }
    public void exit(){
        this.setFont(new Font("Veranda", 1, 40));
        this.setForeground(null);
    }
}
