package com.hishamfacktory;

import javax.swing.*;
import java.awt.*;

public abstract class Person {
    private String name;
    private Hand hand;

    public double getBankRoll() {
        return bankRoll;
    }

    public void setBankRoll(double bankRoll) {
        this.bankRoll = bankRoll;
    }

    private double bankRoll;

    public Person(){
        this.name = "";
        this.hand = new Hand();
        this.bankRoll = 0.0;
    }
    public Hand getHand(){
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void hit(Deck deck,Deck discard){
        if(!deck.hasCard()){
            deck.reloadDeckFromDiscarded(discard);
        }
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.getName() + " get card");
    }
    public boolean hasBlackJack(){
        return this.getHand().calculateValue() == 21;
    }
    public void printHand(JLabel[] cardPics){
        System.out.println(this.getName() +  " hand looks like this: ");
        String output  = "";
        for(Card card : this.hand.getHand()){
            output += card + " - ";
        }
        output += " Valued at: " + this.hand.calculateValue();
        System.out.println(output);
        //iterate through each card, update pic, hide remaining
        for (int i = 0; i < 11; i++) {
            cardPics[i].setVisible(false);
        }
        for (int i = 0; i < this.hand.getHandSize() ; i++) {
            String rank = this.hand.getCard(i).getRank().toString();
            String suit = this.hand.getCard(i).getSuit().toString();
            String filename = rank + suit +".png";
            System.out.println(filename);
            cardPics[i].setIcon(new ImageIcon(new ImageIcon(Game.IMAGE_DIR+filename).getImage().getScaledInstance(Game.CARD_WIDTH,Game.CARD_HEIGHT, Image.SCALE_SMOOTH)));
            cardPics[i].setVisible(true);
        }
    }
    public void increase_budget(double betRound){
        this.bankRoll += betRound;
    }
    public void decrease_budget(double betRound){
        this.bankRoll -= betRound;
    }
}
