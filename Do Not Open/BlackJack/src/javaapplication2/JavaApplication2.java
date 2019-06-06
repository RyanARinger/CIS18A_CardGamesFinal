package javaapplication2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class JavaApplication2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        
        menu();
        
            
    }
    public static void menu(){
        final Font VERANDA = new Font("Veranda", 1, 20);
        
        JFrame window1 = new JFrame("Jablinski");
        window1.setSize(800, 600);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel post = new JPanel();
        JPanel pan = new JPanel(new GridBagLayout());
        LineBorder lb =new LineBorder(Color.BLACK);
        
        JLabel label = new JLabel("Welcome");
        label.setFont(VERANDA);
        WordButton b1 = new WordButton("Play");
        b1.setBorder(lb);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(window1.getLayout());
                blackJack(window1, cl);                
            }
        });
        
        WordButton b2 = new WordButton("Exit");
        b2.setBorder(lb);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window1.dispose();
            }
        });
        
        
        
        gbc.anchor = GridBagConstraints.CENTER;
        
        addStuff(pan,label,gbc, 0,0);
        addStuff(pan,b1,gbc, 0,1);
        addStuff(pan,b2,gbc, 0,2);
        post.add(pan);
        
        window1.add(post, "Hello");
        window1.setVisible(true);
    }
    public static void addStuff(Container c, Component l, GridBagConstraints gbc, int x, int y){
        
        gbc.gridx = x;
        gbc.gridy = y;
        
        
        c.add(l, gbc);        
        
        
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    public static void blackJack(JFrame window, CardLayout cl){
        Scanner scan = new Scanner(System.in);
        
        final int WIN = 21;
        final int HSIZE = 2;
        int c = 0; // counter for the deck
        Deck deck = new Deck();
        BjHand player = new BjHand();
        BjHand dealer = new BjHand();
        int choice = 1;
        
        for (int i = 0; i < 7; i++) {
            deck.shuffle();
        }
        
        for (int i = 0; i < (HSIZE * 2); i++) {
            if(i%2 == 0){
                player.setCards(i/2, c);
                c++;
                
            }
            else if(i%2 == 1){
                dealer.setCards(i/2, c);
                c++;
                
            }
            
        }
        
        
        
        showTable(player, dealer, deck);
        addCards(player, deck);
        addCards(dealer, deck);
        
        if(player.getSum() == WIN){
            System.out.println("YOU HAVE 21");
            System.out.println("YOU WIN");
        }
        else{

            while(choice == 1){

                System.out.println("Your Sum : " + player.getSum());
                System.out.println("WOULD YOU LIKE TO HIT");
                System.out.println("(1)Yes or (0)No");
                choice = Integer.parseInt(scan.nextLine());

                if(choice == 1){
                    hit(player, deck, c);
                    c++;
                }
                if(player.getSum() == 21){
                    System.out.println("YOU HAVE 21");
                    System.out.println("YOU WIN");
                    choice = 0;
                }
                else if(player.getSum() > WIN){
                    aceManage(player, deck);
                    if(player.getSum() > WIN){
                        System.out.println("BUST");
                        choice = 0;
                    }
                }
            }
            if(dealer.getSum() < 17){
                while(dealer.getSum() < 17){
                    hit(dealer, deck, c);
                    c++;
                    System.out.println(dealer.getSum());
                    if(dealer.getSum() > WIN){
                        System.out.println("BUST");
                    }
                }
            }
            else{
                System.out.println(dealer.getSum());
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public static void addCards(BjHand a, Deck d){
        int sum = 0;
        int aces = 0;
        for (int i = 0; i < 2; i++) {
            if(d.cards[a.hand[i]].fValue > 10){
                sum += 10;
            }
            else if(d.cards[a.hand[i]].fValue == 1){
                sum += 11;
                aces++;
            }
            else {
                sum += d.cards[a.hand[i]].fValue;
            }
        }
        
        if(aces == 2){
            sum-=10;
        }
        
        a.setNAces(aces);
        a.setSum(sum);
    }
    
    public static void hit(BjHand a, Deck d, int c){
        
        int sum = a.getSum();
        int aces = 0;
        boolean bust = false;
        boolean done = false;
        
        
        d.cards[c].showCard();
        System.out.println("");
        
        if(d.cards[c].fValue > 10){
            sum += 10;
        }
        else{
            if(d.cards[c].face.equals("Ace")){
                sum += 11;
                aces ++;
            }
            else{
                sum += d.cards[c].fValue;
            }
        }
            
        a.setNAces(a.getNAces() + aces);
        a.setSum(sum);
    }
    
    public static void aceManage(BjHand a, Deck d){
        int aces = a.getNAces();
        int sum = a.getSum();
        boolean safe = false;
        
        while(!safe){
            if(aces > 0){
                sum -= 10;
                if(sum < 21){
                    safe = true;
                }
                aces--;
            }
            else{
                safe = true;
            }
        }
        
        a.setSum(sum);
        a.setNAces(aces);
    }
        public static void showTable(BjHand a, BjHand b, Deck d){
//        JFrame hitFrame = new JFrame("BlackJack");
//        hitFrame.setSize(800, 600);
//        JPanel post = new JPanel();
//        JPanel pan = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        
//        
//        System.out.println("[" + d.cards[b.hand[0]].face + "->" + d.cards[b.hand[0]].suit + "]" + "[FACE-DOWN]");
//        
//        
//        JLabel dealerCards = new JLabel("[" + d.cards[b.hand[0]].face + "->" + d.cards[b.hand[0]].suit + "]" + "[FACE-DOWN]");
//        JLabel playerCards = new JLabel("[" + d.cards[a.hand[0]].face + "->" + d.cards[a.hand[0]].suit + "]" 
//                + "["+ d.cards[a.hand[1]].face + "->" + d.cards[a.hand[1]].suit+"]");
//        
//        dealerCards.setFont(new Font("Veranda", 1, 20));
//        playerCards.setFont(new Font("Veranda", 1, 20));
//        
//        gbc.anchor = GridBagConstraints.CENTER;
//        
//        addStuff(pan,dealerCards,gbc, 0,0);
//        addStuff(pan,playerCards,gbc, 0,1);
//        
//        post.add(pan);
//        
//        hitFrame.add(post);
//        hitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        hitFrame.setVisible(true);
        
        Font Veranda = new Font("Veranda", 1, 20);

        JPanel hit = new JPanel(new GridBagLayout());
        JLabel dealerCards = new JLabel("[" + d.cards[b.hand[0]].face + "->" + d.cards[b.hand[0]].suit + "]" + "[FACE-DOWN]");
        JLabel playerCards = new JLabel("[" + d.cards[a.hand[0]].face + "->" + d.cards[a.hand[0]].suit + "]" 
                + "["+ d.cards[a.hand[1]].face + "->" + d.cards[a.hand[1]].suit+"]");          
        dealerCards.setFont(Veranda);
        playerCards.setFont(Veranda);
        
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        
        
        addStuff(hit, dealerCards, c, 0, 0);
        addStuff(hit, dealerCards, c, 0, 1);
        
        
    }
//    public static void showTable(BjHand a, BjHand b, Deck d){
//        System.out.println("DEALER CARDS");
//        d.cards[b.hand[0]].showCard();
//        System.out.println("[FACE-DOWN]\n");
////        d.cards[b.hand[1]].showCard();
//        System.out.println("");
//        
//        System.out.println("YOUR CARDS");
//        for (int i = 0; i < 2; i++) {
//            d.cards[a.hand[i]].showCard();
//            
//            
//        }
//        System.out.println("");
//    }
    
}