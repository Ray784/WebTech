import java.awt.*;  
import java.awt.event.*; 
import java.io.*; 
public class ClickBean extends Canvas implements MouseListener{   
    private int count;
    public ClickBean(){  
        addMouseListener(this);
        setSize(300,300);   
    }  
    public void setCount(int count){
        this.count = count;
        repaint();
    }
    public int getCount(){
        return this.count;
    }

    public void paint(Graphics g){
        g.drawString("Clicks: "+getCount(),50,50);
    }
    public void mouseClicked(MouseEvent e) {  
        setCount(getCount()+1);  
    }  
    public void mouseEntered(MouseEvent e) {}  
    public void mouseExited(MouseEvent e) {}  
    public void mousePressed(MouseEvent e) {}  
    public void mouseReleased(MouseEvent e) {}   
    
}  