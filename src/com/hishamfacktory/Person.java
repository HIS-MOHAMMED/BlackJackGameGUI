package com.hishamfacktory;

public class Person {
    private String name;
    private Hand hand;

    public Person(String name, Hand hand){
        this.name = name;
        this.hand = hand;
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
        deck.addCard(discard.takeCard());
    }
    public boolean hasBlackJack(){
        if(hand.calculateValue() == 21) return true;
        else return false;
    }
}
