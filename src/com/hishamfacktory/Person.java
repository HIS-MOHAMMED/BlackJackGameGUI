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
        if(!deck.hasCard()){
            deck.reloadDeckFromDiscarded(discard);
        }
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.getName() + " get card");
        this.printHand();
    }
    public boolean hasBlackJack(){
        if(this.getHand().calculateValue() == 21) return true;
        else return false;
    }
    public void printHand(){
        System.out.println(this.getName() +  " hand looks like this: ");
        String output  = "";
        for(Card card : this.hand.getHand()){
            output += card + " - ";
        }
        output += " Valued at: " + this.hand.calculateValue();
        System.out.println(output);
    }
}
