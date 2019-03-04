
/**
 * Write a description of class PokerHandTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Arrays;

public class PokerHandTester
{
  
    public static void main(String[] args){
     
    //Array C to only test cards 
    Card[] c= {new Card('C', 12),
    new Card('D', 3),
    new Card('S', 2),
    new Card('H', 10),
    new Card('C', 4),
    new Card('C', 13),
    new Card('D', 8),
    new Card('S', 14),
    new Card('H', 13),
    new Card('C', 9)};
    
    Card[] c1= {new Card('C', 11),
    new Card('D', 6),
    new Card('S', 14),
    new Card('H', 11),
    new Card('C', 8)};
    
    Card[] c2= {new Card('C', 12),
    new Card('D', 4),
    new Card('S', 8),
    new Card('H', 11),
    new Card('D', 2)};
    
    Card[] c3= {new Card('C', 9),
    new Card('D', 9),
    new Card('S', 13),
    new Card('H', 12),
    new Card('C', 4)};
    
    Card[] c4= {new Card('C', 13),
    new Card('D', 2),
    new Card('H', 9),
    new Card('H', 10),
    new Card('S', 4)};
    
    Card[] c5= {new Card('C', 14),
    new Card('S', 6),
    new Card('S', 7),
    new Card('H', 8),
    new Card('D', 9)};
   
    PokerHand[] PH={ new PokerHand(c1), new PokerHand(c2),
    new PokerHand(c3), new PokerHand(c4), new PokerHand(c5)};
   
     
    Arrays.sort(c1);
    Arrays.sort(c2);
    Arrays.sort(c3);
    Arrays.sort(c4);
    Arrays.sort(c5);
     
    //pringting 
    System.out.println("Before Sorting Array");
    System.out.println("Comparing cards\n");
        for(int i=0; i<c.length-1; i++){
            
        System.out.println(" Card 1 is: " +c[i]+ " and Card 2 is: " +c[i+1]+"\n The difference between the two is: " +c[i].compareTo(c[i+1]));
    }
         
    System.out.println("\nComparing hand\n");
    
    for(int j=0; j<PH.length-1; j++){
        
        System.out.println("Hand 1 is: " +PH[j]+ "\n\nand Hand 2 is: "+PH[j+1]+"\nThe difference between the two is: "+ PH[j].compareTo(PH[j+1])+"\n");
    }
    
    Arrays.sort(c);
    
 
    Arrays.sort(PH);
    
      System.out.println("After Sorting Array");
    System.out.println("Comparing cards\n");
        for(int i=0; i<c.length-1; i++){
            
        System.out.println(" Card 1 is: " +c[i]+ " and Card 2 is: " +c[i+1]+"\n The difference between the two is: " +c[i].compareTo(c[i+1]));
    }
         
    System.out.println("\nComparing hand\n");
    
    for(int j=0; j<PH.length-1; j++){
        
        System.out.println("Hand 1 is: " +PH[j]+ "\n\nand Hand 2 is: "+PH[j+1]+"\nHigh Card is: "+ PH[j].compareTo(PH[j+1])+"\n");
    }
    
}
    
    
 }

