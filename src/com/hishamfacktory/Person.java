package com.hishamfacktory;

public abstract class Person {
    private String name;
    private Hand hand;

    public Person(){
        this.name = "";
        this.hand = new Hand();
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
        discard.addCard(deck.takeCard());
    }
    public boolean hasBlackJack(){
        if(this.getHand().calculateValue() == 21) return true;
        else return false;
    }
}
