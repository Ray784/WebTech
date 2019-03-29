import java.awt.*;  
import java.awt.event.*;  
public class MouseBean extends Frame implements MouseListener{   
    private int count;
    MouseBean(){  
        addMouseListener(this);
        setSize(300,300);  
        setLayout(null);  
        setVisible(true);  
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
    public void setCount(int count){
        this.count = count;
        repaint();
    }
    public int getCount(){
        return this.count;
    }
    public static void main(String[] args) {  
        new MouseBean();  
    }  
}  