package com.hishamfacktory;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){

        this.suit = suit;
        this.rank = rank;
    }
    public Card(Card card){
        this.suit = card.suit;
        this.rank = card.rank;
    }
    public int getValue(){
        return rank.rankValue;
    }
    public Suit getSuit(){
        return suit;
    }
    public Rank getRank(){
        return  rank;
    }
    public String toString(){
        return("[" + rank + " Of " + suit + "] " + "(" + this.getValue() + ")");
    }
}
