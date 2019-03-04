public class Card implements Comparable<Card>
{
    // instance variables - replace the example below with your own
    private char suite;
    private int rank;

    /**
     * Constructor for objects of class Card
     */
    public Card()
    {}
    
    public Card(char suite, int rank)
    {
        // initialise instance variables
        this.suite=suite;
        this.rank=rank;
    }
    //class methods
    public int getRank(){
       
        return rank;
    }
    
    public String getSuite(){
        String S="";
        
        if(suite=='C'){
            S="clubs";
        }
        else if(suite=='D'){
            S="diamonds";
        }
        else if(suite=='S'){
            S="spades";
        }
        else if(suite=='H'){
            S="hearts";
        }
        return S;
    }
    
    @Override
    public boolean equals(Object o){
     if (this==o){
        return true;
        }
     if (!(o instanceof Card)){
        return false;
        }
        Card c= (Card) o;
        
        return (c.rank==this.rank) && (c.suite==this.suite);
    }
    
    @Override
    public String toString()
    {
        String s="";
        if(getRank()>11){
            
        if (getRank()==11){
            s="Jack";
        }
        else if(getRank()==12){
            s="Queen";
        }
        else if(getRank()==13){
        s="King";
        }
        else if(getRank()==14){
            s="Ace";
            
        }
        return s+" of "+getSuite();
            
    }
     
    else
        return getRank()+" "+"of"+" "+getSuite();
    }
    
    @Override 
    public int compareTo(Card c){
        if(this.equals(c)){
        return 0;}
        int result=this.rank-c.rank;
        return result;
        
    }
}
