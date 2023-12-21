package com.hishamfacktory;


import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand ;
    public Hand(){
        hand = new ArrayList<>();
    }
    public void takeCardFromDeck(Deck deck){
        hand.add(deck.takeCard());
    }
    public void discardHandToDeck(Deck discard){
        discard.addCard(hand.get(0));
    }
    public int calculateValue(){
        return 0;
    }
    public String toString(){
        String output  = "";
        for(Card card : hand){
            output += card + " - ";
        }
        return output;
    }
}
