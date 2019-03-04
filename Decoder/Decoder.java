

import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class Decoder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Decoder
{
    // instance variables - replace the example below with your own
    private JFrame frame;
    private JButton bit1;
    private JButton bit2;
    private JButton bit3;
    private JButton bit4;
    private int bb1=0;
    private int bb2=0;
    private int bb3=0;
    private int bb4=0;
    
    private Button1Listener b1;//to implement these
    private Button2Listener b2;
    private Button3Listener b3;
    private Button4Listener b4;
    
    private int value=0;
    private int count1=0;
    private int count2=0;
    private int count3=0;
    private int count4=0;
    
    private JButton exit;
    private JLabel label;
    private ExitListener e1;

    /**
     * Constructor for objects of class Decoder
     */
    public Decoder()
    {
        frame=new JFrame("4-bit Decoder");
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        
        bit1=new JButton();//initially they will all be zero
        bit1.setText("0");
        bit1.setBounds(50,15,70,20);
        b1=new Button1Listener();
        bit1.addActionListener(b1);
        
        bit2=new JButton();
        bit2.setText("0");
        bit2.setBounds(50,30,70,20);
        b2=new Button2Listener();
        bit2.addActionListener(b2);
        
        bit3=new JButton();
        bit3.setText("0");
        bit3.setBounds(50,45,70,20);
        b3=new Button3Listener();
        bit3.addActionListener(b3);
        
        bit4=new JButton();
        bit4.setText("0");
        bit4.setBounds(50,60,70,20);
        b4=new Button4Listener();
        bit4.addActionListener(b4);
        
        label=new JLabel();
        label.setText("Value=0");
        label.setBounds(150,45,70,20);
        
        exit=new JButton();
        exit.setText("Exit");
        exit.setBounds(150,100,70,20);
        e1=new ExitListener();
        exit.addActionListener(e1);
        
       frame.add(bit1);
       frame.add(bit2);
       frame.add(bit3);
       frame.add(bit4);
       frame.add(label);
       frame.add(exit);
       frame.repaint();
    }
    
    private class Button1Listener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    count1++;
    if (count1%2!=0){
        bb1=1; 
    }
    else 
    {bb1=0;}
    bit1.setText(""+bb1);
    value=(bb1*1)+(bb2*2)+(bb3*4)+(bb4*8);
    label.setText("Value="+value);
    label.repaint();
}
}
   private class Button2Listener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    count2++;
    if (count2%2!=0){
        bb2=1; 
    }
    else 
    {bb2=0;}
    bit2.setText(""+bb2);
    value=(bb1*1)+(bb2*2)+(bb3*4)+(bb4*8);
    label.setText("Value="+value);
    label.repaint();
    }
}
   private class Button3Listener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    count3++;
    if (count3%2!=0){
        bb3=1; 
    }
    else 
    {bb3=0;}
    bit3.setText(""+bb3);
    value=(bb1*1)+(bb2*2)+(bb3*4)+(bb4*8);
    label.setText("Value="+value);
    label.repaint();
    }
}
   private class Button4Listener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    count4++;
    if (count4%2!=0){
        bb4=1; 
    }
    else 
    {bb4=0;}
    bit4.setText(""+bb4);
    value=(bb1*1)+(bb2*2)+(bb3*4)+(bb4*8);
    label.setText("Value="+value);
    label.repaint();
    }
}

 private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
    Decoder d=new Decoder();
    }

   
}
