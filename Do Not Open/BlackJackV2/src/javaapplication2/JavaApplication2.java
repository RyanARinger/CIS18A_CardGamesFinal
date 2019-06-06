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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class JavaApplication2 {

    public static int C = 0;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean done = false;
        
        menu();
        
            
    }
    public static void menu(){
        final Font VERANDA = new Font("Veranda", 1, 40);
        
        JFrame window1 = new JFrame("Jablinski");
        window1.setSize(800, 600);
//        window1.setLayout(new CardLayout());
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel post = new JPanel(new CardLayout());
        JPanel post1 = new JPanel(new GridBagLayout());
        JPanel pan = new JPanel(new GridBagLayout());
        pan.setBackground(Color.GRAY);
        post1.setBackground(Color.GRAY);
        LineBorder lb =new LineBorder(Color.BLACK);
        post.add(pan, "Hello");
        post.add(post1, "c1");
        window1.add(post);
        
        
        JLabel label = new JLabel("Welcome");
        label.setFont(VERANDA);
        WordButton b1 = new WordButton("Play");
        b1.setBorder(lb);
        b1.setFont(VERANDA);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                blackJack(window1, post1, post);
                
            }
        });
        
        WordButton b2 = new WordButton("Exit");
        b2.setBorder(lb);
        b2.setFont(VERANDA);
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
        
        
        
        window1.setVisible(true);
    }
    public static void addStuff(Container c, Component l, GridBagConstraints gbc, int x, int y){
        
        gbc.gridx = x;
        gbc.gridy = y;
        
        
        c.add(l, gbc);        
        
        
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void blackJack(JFrame window ,JPanel pan, JPanel post){
        Scanner scan = new Scanner(System.in);
        final Font VERANDA = new Font("Veranda", 1, 40);
        boolean done = false;
        
        String message = "You have 21, YOU WIN!!";
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        CardLayout cl = (CardLayout)post.getLayout();
        
        ArrayList<JPanel> cards = new ArrayList();
        
        
        final int WIN = 21;
        final int HSIZE = 2;
        int c = 0; // counter for the deck
        Deck deck = new Deck();
        BjHand player = new BjHand();
        BjHand dealer = new BjHand();
        
        cards.add(new JPanel(new GridBagLayout()));
        JPanel c4 = new JPanel(new GridBagLayout());
        JPanel c5 = new JPanel(new GridBagLayout());
        post.add(cards.get(1), "c3");
        post.add(c4, "c4");
        post.add(c5, "c5");
        JLabel test = new JLabel("Test");
        addStuff(cards.get(1), test, gbc, 0,0);
        for (int i = 0; i < 7; i++) {
            deck.shuffle();
        }
        
        for (int i = 0; i < (HSIZE * 2); i++) {
            if(i%2 == 0){
                player.setCards(c);
                C++;
                
            }
            else if(i%2 == 1){
                dealer.setCards(c);
                C++;
                
            }
            
        }
        
        final BjHand fp = new BjHand(player);
        final BjHand fd = new BjHand(dealer);
        final int fe = c;
        final Deck d = new Deck(deck);
        hitPanelMaker(player, dealer, deck, pan, c);
        addCards(player, deck);
        addCards(dealer, deck);
        if(player.getSum() == WIN){
            //System.out.println("YOU HAVE 21");
            //System.out.println("YOU WIN");
            JLabel win = new JLabel(message);
            win.setFont(VERANDA);
            addStuff(pan, win, gbc, 0,2);
            cl.next(post);
            
            
        }
        else{
            cl.next(post);
            
            WordButton hit1 = new WordButton("Hit");
            hit1.setBorder(new LineBorder(Color.BLACK));

            WordButton stay = new WordButton("Stay");
            stay.setBorder(new LineBorder(Color.BLACK));
//            ClickListener g = new ClickListener(){
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    hit(player, deck, c);
//                }
//            };
            hit1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    hit(fp, d, C);
                    C++;
                    cl.next(post);
                }
            });
            stay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stay.setIN(true);
                    cl.next(post);
                }
            });
            
            addStuff(pan, hit1, gbc, 0,3);
            addStuff(pan, stay, gbc, 1,3);

            stay.setFont(VERANDA);
            hit1.setFont(VERANDA);
            
            
        }
        
        
        
        
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    

    public static void addCards(BjHand a, Deck d){
        int sum = 0;
        int aces = 0;
        for (int i = 0; i < 2; i++) {
            if(d.cards[a.hand.get(i)].fValue > 10){
                sum += 10;
            }
            else if(d.cards[a.hand.get(i)].fValue == 1){
                sum += 11;
                aces++;
            }
            else {
                sum += d.cards[a.hand.get(i)].fValue;
            }
        }
        
        if(aces == 2){
            sum-=10;
        }
        
        a.setNAces(aces);
        a.setSum(sum);
    }
    
    public static void hit(BjHand fa, Deck fd, int fc){
        
        BjHand a = fa;
        Deck d = fd;
        int c = fc;
        
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
    
        public static void hitPanelMaker(BjHand a, BjHand b, Deck d, JPanel pan, int ci){
            
        Font Veranda = new Font("Veranda", 1, 40);
        
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        final BjHand fp = a;
        final Deck fd = d;
        final int fe = ci;
        JLabel dName = new JLabel("Dealer Cards: ");
        JLabel dealerCards = new JLabel("[" + d.cards[b.hand.get(0)].face + "->" + d.cards[b.hand.get(0)].suit + "]" 
                + "[FACE-DOWN]");
        JLabel pName = new JLabel("Your Cards: ");
        JLabel playerCards = new JLabel("[" + d.cards[a.hand.get(0)].face + "->" + d.cards[a.hand.get(0)].suit + "]" 
                + "["+ d.cards[a.hand.get(1)].face + "->" + d.cards[a.hand.get(1)].suit+"]");
        
//        WordButton hit1 = new WordButton("Hit");
//        hit1.setBorder(new LineBorder(Color.BLACK));
//        
//        WordButton stay = new WordButton("Stay");
//        stay.setBorder(new LineBorder(Color.BLACK));
        
//        hit1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//                hit(fp,fd,fe);
//            }
//        });
//        stay.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
        
        
//        stay.setFont(Veranda);
//        hit1.setFont(Veranda);
        dealerCards.setFont(Veranda);
        playerCards.setFont(Veranda);
        pName.setFont(Veranda);
        dName.setFont(Veranda);
        
        
        addStuff(pan, dealerCards, c, 1,0);
        addStuff(pan, playerCards, c, 1,1); 
        addStuff(pan, dName, c, 0,0);
        addStuff(pan, pName, c, 0,1);
//        addStuff(pan, hit1, c, 0,3);
//        addStuff(pan, stay, c, 1,3);
        
        
        }
        
        public static int getOne(){
            return 1;
        }
        public static int getZero(){
            return 0;
        }
}