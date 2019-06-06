package javaapplication2;

public class BjHand extends Hand{
    
    private int sum;
    private boolean acesUsed;
    private int numAces;
    
    public BjHand(){
        super(2);
        this.sum = 0;
        this.acesUsed = false;
        this.numAces = 0;
    }
    
    public BjHand(BjHand h){
        super(2);
        this.numAces = h.getNAces();
        this.acesUsed = h.getAU();
        this.sum = h.getSum();
    }
    
    public void setCards(int b){
        this.hand.add(b);
    }
    
    public void setSum(int s){
        this.sum = s;
    }
    public void setAU(boolean a){
        this.acesUsed = a;
    }
    public void setNAces(int n){
        this.numAces = n;
    }
    
    public int getSum(){
        return this.sum;
    }
    public boolean getAU(){
        return this.acesUsed;
    }
    public int getNAces(){
        return this.numAces;
    }
}
