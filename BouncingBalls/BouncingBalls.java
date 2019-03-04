import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.MouseInputAdapter;
import java.util.LinkedList;
import java.util.ListIterator;
import javafx.scene.layout.Pane;
import java.lang.*;

public class BouncingBalls extends JPanel
{
    ArrayList<Circle> circles =new ArrayList<Circle>();
    MouseShaper m1;
    JFrame frame;
    boolean hasManyShapes=false;
    int time=10;
    int max=30;
    int min=0;
  public BouncingBalls(){
    frame=new JFrame("Shapes Window");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(640, 480);
    m1=new MouseShaper();
    KeyTracker kt=new KeyTracker();
    
    //circles.add(new Circle(100,100));
    
    this.setBackground(Color.BLACK);
    this.setPreferredSize(new Dimension(640, 480));
    this.addMouseListener(m1);
    frame.addKeyListener(kt);
    frame.add(this);
    
    frame.pack();
    frame.setLayout(null);
    frame.setVisible(true);
  }
    
   
@Override
   protected void paintComponent(Graphics g){
       super.paintComponent(g);
       for(Circle c: circles)
       c.draw(g);
   
}

public void Animate(){//add delay in the form of a variable 
while(true){
    try{
        Thread.sleep(time);
    }
    catch(InterruptedException ex){
    Thread.currentThread().interrupt();
    }
    this.repaint();
}
}

public boolean hasTenShapes(){
if(circles.size()<10){
    //hasManyShapes=false;
    return false;
}
else
{//hasManyShapes=true;
  //System.out.println("Too many shapes");
throw new RuntimeException();}
//return true;
}

public class Circle{
   private int x,y, dx=1, dy=1;
    private Color c;
 public Circle(int x, int y){
 this.x=x;
 this.y=y;
 c=new Color((int)(Math.random()*0x1000000));
}
        
    public void draw(Graphics g){
        x+=dx;
        y+=dy;
        if (x<=0) dx=1;
        if(x>=BouncingBalls.this.getWidth()-50) dx=-1;
        if (y<=0) dy=1;
        if(y>=BouncingBalls.this.getHeight()-50) dy=-1;
        
    Graphics2D g2d=(Graphics2D) g;
    
    g2d.setColor(c);//here we are randomizing the colour of each circle
    g2d.fillOval(x,y,50,50);
    
}
public int getY(){
    return y;
}
public int getX(){
        return x;
    }

}

public class MouseShaper implements MouseListener{
  public void mouseClicked(MouseEvent m){
      int x=m.getX(), y=m.getY(), b=m.getButton(); 
    
    
        if(SwingUtilities.isLeftMouseButton(m)){//only 10 shapes at a time
   
 
      //do this test in another method in the top level class, then put it in try
      //if(circles.size()==10){//throw exception here
            try{ //try works
                if(hasTenShapes()==true){
                hasManyShapes=true;
                
            }
            }  
            catch(RuntimeException ex){
              System.out.println("Too many shapes");
        
            }
      // }
   
        if(circles.size()<10){
            circles.add(new Circle(x-25, y-25));
           BouncingBalls.this.repaint();
        
        }
/*else 
{count=10;
throw new RuntimeException();
}*/

}
   else if(SwingUtilities.isRightMouseButton(m)){
    
        for (int i=0; i<circles.size(); i++)
       {
         int cx=circles.get(i).getX()+25;
         int cy=circles.get(i).getY()+25;
         double dist=Math.sqrt((x-cx)*(x-cx)+(y-cy)*(y-cy));
         if(dist<=25){
            circles.remove(i);
            i--;
            }
         
   }
   BouncingBalls.this.repaint();
}
 
}

  public void mouseEntered(MouseEvent m){}
   public void mouseExited(MouseEvent m){}
   public void mousePressed(MouseEvent m){}
   public void mouseReleased(MouseEvent m){}
 }
 
 public class KeyTracker implements KeyListener{
    public void keyPressed(KeyEvent m){
    int code=m.getKeyCode();
  
  if(code==KeyEvent.VK_UP){
      if(time>0){
      time=time-10; }
    }
  if(code==KeyEvent.VK_DOWN){
    if(time<=30){
      time=time+10;
    }
}
}
    public void keyReleased(KeyEvent m){}
    public void keyTyped(KeyEvent m){}
    
    }
  
public static void main(String[] args){
    BouncingBalls bb=new BouncingBalls();
   bb.Animate();//you call animate so it animates it
    
    }

    
}

  
