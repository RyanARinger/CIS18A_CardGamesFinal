package javaapplication2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JLabel;


public class CircleButton extends ClickablePanel {
    private final int XC = 10;
    private final int YC = 10;
    private final int XS = 10;
    private final int YS = 10;
    private final Font VERANDA = new Font("Veranda", 1,20);
    private Color c = Color.red;
    private JLabel label;
    
    
    
    public CircleButton(){
        super();
    }
    public CircleButton(Color x){
        super();
        this.c = x;
    }
    public CircleButton(Color x, String s){
        
        super();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        label = new JLabel(s);
        this.label.setFont(VERANDA);
//        this.add(label);
        this.addStuff( label, layout, gbc, 1,1,1,1);
        this.c = x;
    }
    
    public void setColor(Color x){
        this.c = x;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(this.c);
        g.fillOval(0, 0, 50, 50);
        this.setBackground(this.c);        
    }
    public void addStuff(JLabel l, GridBagLayout layout, GridBagConstraints gbc, int x, int y, int w, int h){
        
        
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        
        layout.setConstraints(l,gbc);
        this.add(l);
        
        
    }
}
