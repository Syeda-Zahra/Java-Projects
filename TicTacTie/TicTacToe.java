import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import javafx.scene.layout.Pane;
import java.awt.Insets;
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

public class TicTacToe
{
    private JFrame frame;
    private JPanel panel;
    private JPanel panel1;
    //private JPanel panel2;
    JButton buttons[] = new JButton[9]; 
    int count=0;
    private ExitListener e1;
    private JButton exit;
    private boolean hasWinner;
    private boolean goFirst;
    

    public TicTacToe(boolean goFirst)
    { frame=new JFrame("Syeda Zahra 500623477");
      frame.setSize(500,500);
      frame.setVisible(true);
      panel=new JPanel();
      panel1=new JPanel();
      
      hasWinner=false;
      this.goFirst=goFirst;
      
      GridLayout grid=new GridLayout(3,3);
      
      frame.setResizable(false);
      
      panel.setLayout(grid);
       
      
       for(int i = 0; i <= 8; i++)
        {
            
            buttons[i] = new JButton();
            buttons[i].setText("");
            
         if(goFirst==true){
             count=0;
            buttons[i].addActionListener(new ButtonListener ());
        }
        if(goFirst==false){
            count=1;
            //int random=(int)(Math.random()*8+1);
            buttons[0].setText("X");
            count++; 
            buttons[i].addActionListener(new ButtonListener ());
        
         //break;   
              
        }
        panel.add(buttons[i]);
    }
        panel.setBounds(100,100,200,200);
        //frame.add(panel2);
        frame.add(panel);
        
        
        exit=new JButton();
        exit.setText("Exit");
       //exit.setBounds(100,200,70,20);
       
       e1=new ExitListener();
       exit.addActionListener(e1);
      
       panel1.setBounds(100,400, 70,20);
       
       
       frame.add(panel1);
      frame.repaint();
    }
    private class ButtonListener implements ActionListener
    {
       
        public void actionPerformed(ActionEvent e) 
        {
            
            JButton buttonClicked = (JButton)e.getSource(); 
          
            String a=buttonClicked.getText(); 
    
            
         if(count%2==0 && a.equals("")){
          if((checkIfTie() == false) &&(checkIfComputerWins() == false)&&
           (checkIfUserWins() == false)){
          buttonClicked.setText("O");
          panel.repaint();
          count++;
        }
    
          if(!(a.equals(""))){
              count--;}//this ensures that count is at the right place because whenever we click 
                       //count increments but if we click on a non empty squared then count should stay the same.
              
           if (count%2==1 && a.equals("")){
                if((checkIfTie() == false) &&(checkIfComputerWins() == false)&&
           (checkIfUserWins() == false)){//add ai somewhere here...after button is clicked the computer makes a move randomely somwehere
           
            try{//try catch for computer's move
                
                Thread.sleep(500);}
                catch(InterruptedException ex){
                Thread.currentThread().interrupt();}
                for(int i=0; i<=8; i++){
                //int random=(int)(Math.random()*8+1);<--sometimes the X doesnt get drawn because the random button chosen is 
                if(buttons[i].getText().equals("") ){
                buttons[i].setText("X");
                break;
                }
                
                }
                panel.repaint();
              count++;//incements count so the user can make its move next
            
            }
            }
        
        }
           
    if(checkIfUserWins() == true)//add quit
            {
            
               panel1.setBackground(Color.GREEN);
                panel1.add(exit);
               frame.repaint();
              
            }
            else if(checkIfComputerWins() == true)//add quit
            {
            
               panel1.setBackground(Color.RED);
               panel1.add(exit);
               frame.repaint();
              
            }
            else if(checkIfTie() == true)//add quit
            {
            
               panel1.setBackground(Color.YELLOW);
               panel1.add(exit);
               frame.repaint();
              
            }
   }
    /**Array button arrangement:
                  0 | 1 | 2
                  3 | 4 | 5
                  6 | 7 | 8 */
                  
    public boolean checkIfTie(){
           
          if( (checkAdjacentTie(0,1) || checkAdjacentTie(1,2)) && 
              (checkAdjacentTie(3,4) || checkAdjacentTie(4,5))&&
              (checkAdjacentTie(6,7) || checkAdjacentTie(7,8)) && 
              (checkAdjacentTie(0,3) || checkAdjacentTie(3,6))&&
              (checkAdjacentTie(1,4) || checkAdjacentTie(4,7)) && 
              (checkAdjacentTie(2,5) || checkAdjacentTie(5,8))&&
              (checkAdjacentTie(0,4) || checkAdjacentTie(4,8)) && 
              (checkAdjacentTie(2,4) || checkAdjacentTie(4,6))){ 
            hasWinner=true;
            return hasWinner;
        }
            else 
           return hasWinner;
            
            
    }
    
    public boolean checkIfUserWins(){
         if( checkAdjacentUser(0,1)&& checkAdjacentUser(1,2) )
           {  
            hasWinner=true;
              
            }
            else if( checkAdjacentUser(3,4) && checkAdjacentUser(4,5) )
            {   
                hasWinner=true;
               
            }
            else if ( checkAdjacentUser(6,7) && checkAdjacentUser(7,8))
             {
                hasWinner=true;
              
            }
            
            else if ( checkAdjacentUser(0,3) && checkAdjacentUser(3,6))
                {hasWinner=true;
             }
            
             else if ( checkAdjacentUser(1,4) && checkAdjacentUser(4,7))
            {hasWinner=true;
               
            }
            else if (checkAdjacentUser(2,5) && checkAdjacentUser(5,8))
            {hasWinner=true;
           
            }
          
            else if ( checkAdjacentUser(0,4) && checkAdjacentUser(4,8))
            {hasWinner=true;
             }
             
            else if (checkAdjacentUser(2,4) && checkAdjacentUser(4,6))
               {hasWinner=true;
              }
            else 
            {hasWinner=false;}
                
             return hasWinner;
    }
    public boolean checkIfComputerWins(){
           
            if( checkAdjacentComputer(0,1)&& checkAdjacentComputer(1,2) ) 
           {  
            hasWinner=true;
             
            }
            else if( checkAdjacentComputer(3,4) && checkAdjacentComputer(4,5) )
            {   
                hasWinner=true;
             }
            else if ( checkAdjacentComputer(6,7) && checkAdjacentComputer(7,8))
              {
                hasWinner=true;
             }
            
           
            else if ( checkAdjacentComputer(0,3) && checkAdjacentComputer(3,6))
             {hasWinner=true;
               
            }
            else if ( checkAdjacentComputer(1,4) && checkAdjacentComputer(4,7))
            {hasWinner=true;
             
            }
            else if (checkAdjacentComputer(2,5) && checkAdjacentComputer(5,8))
               {hasWinner=true;
             
            }
            
            else if ( checkAdjacentComputer(0,4) && checkAdjacentComputer(4,8))
              {hasWinner=true;
              
            }
            else if (checkAdjacentComputer(2,4) &&checkAdjacentComputer(4,6))
               {hasWinner=true;
               }
            else 
            {
                hasWinner=false;}
                return hasWinner;
          }
        
        public boolean checkAdjacentUser(int a, int b)
        {
            if ( buttons[a].getText().equals("O") && buttons[b].getText().equals("O") && !buttons[a].getText().equals("") )
                return true;
            else
                return false;
        }
        
         public boolean checkAdjacentComputer(int a, int b)
        {
            if ( buttons[a].getText().equals("X") && buttons[b].getText().equals("X") && !buttons[a].getText().equals("") )
                return true;
            else
                return false;
        }
        
        public boolean checkAdjacentTie(int a, int b)
        {
            if (!( buttons[a].getText().equals(buttons[b].getText()))&& !buttons[a].getText().equals("") && !buttons[b].getText().equals("") )
                return true;
            else
                return false;
        }
        
    }
    
    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
   
       public static void main(String[] args) 
    {
        
        TicTacToe game1 = new TicTacToe(true);//WHEN USER GOES FIRST
        TicTacToe game2 = new TicTacToe(false);//WHEN COMPUTER GOES FIR
    }
}