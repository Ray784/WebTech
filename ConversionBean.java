import java.awt.*;

public class ConversionBean extends Canvas{
    private double rupee,usd;
    public ConversionBean(){
        setSize(200,200);
    }
    public void paint(Graphics g){
        g.drawString("rupee "+getRupee(),100,100);
        g.drawString("usd "+getUsd(),100,150);
    }
    public void setRupee(double rupee){
        this.rupee = rupee;
        Exchange();
    }
    public void setUsd(double usd){
        this.usd = usd;
    }
    public double getRupee(){
        return this.rupee;
    }
    public double getUsd(){
        return this.usd;
    }
    public void Exchange(){
        double rup = getRupee();
        double us = rup/(double)60;
        setUsd(us);
        repaint();
    }
}

/*how to run it:
Step 1: compile java file as javac ConversionBean.java
Step 2: write ConversionBean.mft
Step 3: create ConversionBean.jar using the command- jar cfm ConversionBean.jar ConversionBean.mft ConversionBean.class
Step 4: open c:/beans/beanbox/run.bat
Step 5: click file Loadjar
Step 6: browse and select ConversionBean.jar*/ 