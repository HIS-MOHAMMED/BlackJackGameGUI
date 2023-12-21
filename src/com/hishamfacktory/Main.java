package com.hishamfacktory;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to Blackjack Game.");
        Deck deck = new Deck(true);
        Hand hand = new Hand();
        hand.takeCardFromDeck(deck);
        hand.takeCardFromDeck(deck);
        hand.takeCardFromDeck(deck);

        System.out.println("Test hand now has the following cards: ");
        System.out.println(hand);
        System.out.println("Test Deck now looks like this: ");
        deck.shuffle();
        System.out.println(deck);


    }
}
