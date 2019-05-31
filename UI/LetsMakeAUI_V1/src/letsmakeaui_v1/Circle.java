package letsmakeaui_v1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Circle extends JPanel{
    
    private int x = 0;
    private int y = 0;
    private int width = 0;
    private int height = 0;
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        this.setBounds(x, y, 100, 100);
        g.fillOval(y,x,100,100);
    }
    
    
    public void setX(int c){
        this.x = c;
    }
    public void setY(int c){
        this.y = c;
    }
    public void setWidth(int w){
        this.width = w;
    }
    public void setHeight(int h){
        this.height = h;
    }
    
    public int getx(){
        return this.x;
    }
    public int gety(){
        return this.y;
    }
    public int getwidth(){
        return this.width;
    }
    public int getheight(){
        return this.height;
    }
}
