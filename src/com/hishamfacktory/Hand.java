package com.hishamfacktory;


import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand ;
    public Hand(){
        hand = new ArrayList<>();
    }
    public ArrayList<Card> getHand(){
        return  this.hand;
    }
    public void takeCardFromDeck(Deck deck){
        hand.add(deck.takeCard());
    }
    public int calculateValue(){
        //initialize variable to count total value
        int value = 0;
        //iterate through hand to calculate the value
        for(Card card: hand){
            if(card.getValue() == 11 && value + 11 > 21 ){
                value += 1;
                continue;
            }
            value += card.getValue();
        }
        return value;
    }
    public void discardHandToDeck(Deck discardDeck){
        discardDeck.addCards(hand);
        hand.clear();
    }
    public Card getCard(int index){
        return this.hand.get(index);
    }
}
