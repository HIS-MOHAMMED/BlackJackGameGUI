package com.hishamfacktory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Game  extends JPanel {
    private  JLabel lblScore,lblPlayerHandVal,lblDealerHandVal,lblGameMessage;

    public static final int CARD_WIDTH = 100;
    public static final int CARD_HEIGHT = 145;
    public static final String IMAGE_DIR="cardsImages/";

    JLabel[] lbldealer;
    JLabel[] lblplayer;

    //declare some variables needed for Game class
    private Deck deck,discarded;
    private double betRound;
    private Player player;
    private Dealer dealer;
    private int wins,losses,pushes;

    //declare some buttons for GUI
    private  JButton btnHit,btnStand,btnNextRound;

    /*
    Constructor for Game GUi
     */
    public Game(String player_name , String dealer_name,double betRound,double bankRoll){
        //create a new deck with 52 cards
        deck = new Deck(true);

        //create a new empty deck
        discarded = new Deck();

        //create the people
        player = new Player(player_name,bankRoll);
        dealer = new Dealer(dealer_name);
        this.betRound = betRound;

        //shuffle cards
        deck.shuffle();
        setupGUI();
        startRound();

    }
    private void setupGUI(){
        //size of JPanal
        this.setSize(900,700);

        btnHit = new JButton("Hit");
        btnHit.setBounds(10,10,55,20);
        btnHit.setFocusable(false);

        btnHit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.hit(deck,discarded);
                 updateScreen();
                 checkBusts();
                 playerHas21();
                 if(player.getHand().calculateValue() < 21){
                     lblGameMessage.setText("Hit or Stand??");
                 }
            }
        });

        btnStand = new JButton("Stand");
        btnStand.setBounds(70,10,100,20);
        btnStand.setFocusable(false);

        btnStand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DealerTurns();
                hasBlacks();
                checkWins();
                updateScreen();
                dealer.printHand(lbldealer);

                btnStand.setVisible(false);
                btnHit.setVisible(false);
                btnNextRound.setVisible(true);
            }
        });

        btnNextRound = new JButton("Next Round");
        btnNextRound.setBounds(180,10,140,20);
        btnNextRound.setFocusable(false);

        btnNextRound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblGameMessage.setText("Starting round!Hit or Stand?");
                btnHit.setVisible(true);
                btnStand.setVisible(true);
                btnNextRound.setVisible(false);
                startRound();
            }
        });


        this.setLayout(null);


        this.add(btnHit);
        this.add(btnStand);
        this.add(btnNextRound);

        //initialize the arrays that holds cards
        lblplayer = new JLabel[11];
        lbldealer = new JLabel[11];

        //set the initial location of the card on the screen
        int initialCardX = 10,      initiaCardlY = 150;

        //for each card that can possibly be displayed in the array
        for (int i = 0; i < lbldealer.length; i++) {

            //set them to new cards face down
            //done with JLabels and ImageIcons
            lbldealer[i] = new JLabel(new ImageIcon(new ImageIcon(IMAGE_DIR+"CardDown.png").getImage().getScaledInstance(CARD_WIDTH,CARD_HEIGHT,Image.SCALE_SMOOTH)));
            lblplayer[i] = new JLabel(new ImageIcon(new ImageIcon(IMAGE_DIR+"CardDown.png").getImage().getScaledInstance(CARD_WIDTH,CARD_HEIGHT,Image.SCALE_SMOOTH)));

            //Use setBounds to set the width/height of each card, and their positions
            lbldealer[i].setBounds(initialCardX,initiaCardlY,CARD_WIDTH,CARD_HEIGHT);
            lblplayer[i].setBounds(initialCardX,initiaCardlY+250,CARD_WIDTH,CARD_HEIGHT);

            //add the JLabel to the JPanel so we can see it later
            this.add(lbldealer[i]);
            this.add(lblplayer[i]);

            //increment the x/y values of each card by some amount, this will make them appear "stacked" so users can see each one
            initialCardX += 50;
            initiaCardlY -= 18;
        }
        //make scoreBorad
        lblScore = new JLabel("[Wins: 0]     [Loses: 0]    [Pushes: 0]");
        lblScore.setFont(new Font("Arial",1,12));
        lblScore.setBounds(500,10,300,50);
        lblScore.setForeground(Color.WHITE);
        this.add(lblScore);

        //message borad
        lblGameMessage = new JLabel("Starting round! Hit or Stand?");
        lblGameMessage.setBounds(470,200,350,40);
        lblGameMessage.setFont(new Font("Arial",1,20));
        lblGameMessage.setForeground(Color.WHITE);
        this.add(lblGameMessage);

        //Hand values on display
        lblDealerHandVal = new JLabel("Dealer's Hand Value:");
        lblPlayerHandVal = new JLabel("Player's Hand Value:");
        lblDealerHandVal.setBounds(20, 280, 300, 50);
        lblPlayerHandVal.setBounds(20, 530, 300, 50);
        lblDealerHandVal.setForeground(Color.white);
        lblPlayerHandVal.setForeground(Color.white);
        this.add(lblDealerHandVal);
        this.add(lblPlayerHandVal);
    }
    //This just makes the background of the "table" dark green
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.decode("#18320e"));
        g.fillRect(0,0,1000,1000);
    }
    public void startRound() {
        if(wins > 0 || losses > 0 || pushes > 0) {
                    player.getHand().discardHandToDeck(discarded);
                    dealer.getHand().discardHandToDeck(discarded);
        }
        //check make sure the deck has at least 4 cards
        if(deck.cardsLeft() < 4){
            deck.reloadDeckFromDiscarded(discarded);
        }
        //Give the dealer two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        //Give the player two cards
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        dealer.printFirstHand(lbldealer);
        player.printHand(lblplayer);
        lblDealerHandVal.setText("Dealer's Hand Value: " + dealer.getHand().calculateFirstCardValue());
        lblPlayerHandVal.setText("Player's Hand Value: " + player.getHand().calculateValue());
        hasBlacks();
    }
    public void DealerTurns(){
        //Now it's the dealer's turn
        while(dealer.getHand().calculateValue() < 17){
            dealer.hit(deck,discarded);
            updateScreen();
        }
    }
    public void checkWins(){
        lblDealerHandVal.setText("Dealer;s Hand Value: "+dealer.getHand().calculateValue());

        //prepare results to make comparisons
        int  player_result = player.getHand().calculateValue();
        int dealer_result = dealer.getHand().calculateValue();
        if(dealer_result > 21){
            lblGameMessage.setText("Dealer busts..");
            wins++;
        }
        else if(dealer_result > player_result){
            lblGameMessage.setText("You Lose..");
            losses++;

        }
        else if(player_result > dealer_result){
            lblGameMessage.setText("You win..");
            wins++;
        }
        else {
            lblGameMessage.setText("Push");
            pushes++;

        }
    }
    public void hasBlacks(){
        if(dealer.hasBlackJack()){
            if(player.hasBlackJack()){
                pushes++;
                lblGameMessage.setText("You both have 21 - Push.");
                btnHit.setVisible(false);
                btnStand.setVisible(false);
                btnNextRound.setVisible(true);

            }
            else{
                losses++;
                lblGameMessage.setText("Dealer has BlackJack.You lose.");
                btnHit.setVisible(false);
                btnStand.setVisible(false);
                btnNextRound.setVisible(true);

            }
        }
        if(player.hasBlackJack()){
            wins++;
            lblGameMessage.setText("Player has BlackJack.You Win:)");
            btnHit.setVisible(false);
            btnStand.setVisible(false);
            btnNextRound.setVisible(true);

        }
    }
    public void updateScreen(){
        lblPlayerHandVal.setText("Player's Hand Value: " + player.getHand().calculateValue());
        player.printHand(lblplayer);
        lblScore.setText("[Wins:"+wins+"]     [Loses:"+losses+"]    [Pushes:"+ pushes+"]");
    }
    public void playerHas21(){
        if(player.getHand().calculateValue() == 21){
            lblGameMessage.setText("You have 21!");
            wins++;
            btnHit.setVisible(false);
            btnStand.setVisible(false);
            btnNextRound.setVisible(true);
        }
    }
    public void checkBusts(){
        //check if the player has a bust
        if(player.getHand().calculateValue() > 21){
            lblGameMessage.setText("You Busts - Over 21");
            losses++;
            btnHit.setVisible(false);
            btnStand.setVisible(false);
            btnNextRound.setVisible(true);
        }
    }
}
