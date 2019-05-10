package win_class;


public class BjWin extends Win{
    
    
    public static final int TO = 21;
    private int player;
    private int dealer;
    private String winner;
    
    
    public BjWin(){
        super();
    }
    
    public BjWin(int p, int d){
        this.player = p;
        this.dealer = d;
        this.setVic(false);
    }
    
    public void setPlayer(int p){
        this.player = p;
    }
    
    public void setDealer(int d){
        this.dealer = d;
    }
    
    public void setWinner(String w){
        this.winner = w;
    }
    
    public int getPlayer(){
        return this.player;
    }
    
    public int getDealer(){
        return this.dealer;
    }
    
    public String getWinner(){
        return this.winner;
    }
    
    public int findScore(int a){
        int b = TO - a;
        if(b < 0){
            b = 100;
        }
        return b;
    }
    
    public void findWinner(){
        
        if(this.findScore(this.player) > this.findScore(this.dealer)){
            this.winner = "Player";
        }
        else if(this.findScore(this.player) < this.findScore(this.dealer)){
            this.winner = "Dealer";
        }
        else{
            this.winner = "Push";
        }
    }
}