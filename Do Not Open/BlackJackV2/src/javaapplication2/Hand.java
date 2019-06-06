package javaapplication2;

import java.util.ArrayList;

public class Hand {
    

    protected ArrayList<Integer> hand;
    
    public Hand(){
        this.hand = new ArrayList();
        
    }
    public Hand(int s){
        this.hand = new ArrayList();
        
    }
    
    public void push(int a){
        hand.add(a);
    }
    
}
