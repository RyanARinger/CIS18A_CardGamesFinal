package letsmakeaui_v1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JPanel;



public class ClickablePanel extends JPanel{
    
    private ArrayList<ActionListener> actionListeners;
    
    public ClickablePanel(){
        
        actionListeners = new ArrayList();
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ClickablePanel.this.performAction();
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
    }
    
    public void addActionListener(ActionListener al){
        this.actionListeners.add(al);
    }
    
    public void performAction(){
        for(int i = 0; i < actionListeners.size() ; i++) {
            actionListeners.get(i).actionPerformed(new ActionEvent(this,0,"Click"));
        }
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
    }
}
