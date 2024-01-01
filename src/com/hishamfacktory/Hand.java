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
    public void discardHandToDeck(Deck discard){
        discard.addCard(hand.get(0));
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
    public String toString(String str){
        return "";
    }
    public String toString(boolean flag){
        System.out.println("The dealer's hand looks like this: ");
        return "" + this.hand.get(0);
    }
    public Card getCard(int index){
        return this.hand.get(index);
    }
}
