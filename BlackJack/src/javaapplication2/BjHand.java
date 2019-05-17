package javaapplication2;

public class BjHand extends Hand{
    
    private int sum;
    
    public BjHand(){
        super(2);
        this.sum = 0;
    }
    
    public void setCards(int a, int b){
        this.hand[a] = b;
    }
    
    public void setSum(int s){
        this.sum = s;
    }
    
    public int getSum(){
        return this.sum;
    }
}
