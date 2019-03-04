
/**
 * Write a description of class PokerHand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * 
 */
import java.util.Scanner;
public class PokerHand implements Comparable<PokerHand>  //implements Comparable

{
    // instance variables - replace the example below with your own
    private Card[] cards;

    /**
     * Constructor for objects of class PokerHand
     */
    
    
    
    public PokerHand(Card[] cards)
    {
       this.cards=cards;
       
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    
    public boolean validate ()
    {
        for(int i=0; i<4;i++)
        {
          if(cards[i].equals(cards[i+1]))
         {
            return false;
         }
    }
     return true;
    }
   
 
       public boolean hasDuplicate(Card card) {
        for (int i=0; i<cards.length;i++) { 
            Card c=cards[i];
            if (c.equals(card)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean validateAgainst(PokerHand hand) {
        for (int i=0; i<cards.length;i++) {
            Card c=cards[i];
            if (hand.hasDuplicate(c)) {
                return false;
            }
        }
        
        return true;
    }
    
      @Override
   
      public String toString() {
        
          StringBuffer sb = new StringBuffer();
      
        
        for(int i=0; i<cards.length; i++) {
            Card c=cards[i];
            sb.append("\n").append(c.toString());
            
        }
        return sb.toString();
    }
    //if high card is positive go hand 1 wins if high card is negative hand 2 wins
    @Override
    public int compareTo(PokerHand ph){
        if(this.equals(ph)){
              return 0;}
              
              
        int highcard=this.cards[0].getRank();
        int temp=0;
        
        for(int i=0; i<this.cards.length; i++){//cars[i]comparetocard[j] put it in my if statements 
           for(int j=0; j<ph.cards.length; j++){//if compareto>0 if compareto<0
            //if(this.cards[i].getRank()>ph.cards[j].getRank())
      
          
        if(this.cards[i].compareTo(ph.cards[j])>0)
           {
              
               highcard=this.cards[i].getRank();}
            
            else if(this.cards[i].compareTo(ph.cards[j])<0)
            {
                
                highcard=ph.cards[j].getRank()*(-1);
            }
        
    
     if(this.cards[i].compareTo(ph.cards[j])==0){

for(int k=0; k<this.cards.length-1; k++){//cars[i]comparetocard[j] put it in my if statements 
           for(int l=0; l<ph.cards.length-1; l++){//if compareto>0 if compareto<0
            //if(this.cards[i].getRank()>ph.cards[j].getRank())
      
            if(this.cards[k].compareTo(ph.cards[l])==0){
          
                if (this.cards[k+1].compareTo(ph.cards[l+1])>0){
                    highcard=this.cards[k+1].getRank();
        }
        else 
        highcard=ph.cards[l+1].getRank()*-1;
       
    
    }
}
  }
}
}
}
        return highcard;//if sensitive result than 'this' wins is negative ph wins
        
    }

    

}