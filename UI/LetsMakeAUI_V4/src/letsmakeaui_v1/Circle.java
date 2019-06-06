package letsmakeaui_v1;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends ClickablePanel{
    private final int XC = 100;
    private final int YC = 100;
    private final int XS = 100;
    private final int YS = 100;
    private Color c = Color.red;
    
    public Circle(){
        super();
    }
    public Circle(Color x){
        super();
        this.c = x;
    }
    
    public void setColor(Color x){
        this.c = x;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(this.c);
        g.fillOval(0, 0, 100, 100);
    }
}
