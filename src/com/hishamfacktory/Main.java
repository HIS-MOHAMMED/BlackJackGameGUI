package com.hishamfacktory;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to Blackjack Game.");
        //Create and start the Game
        Game game = new Game();
        //Create a standard deck of 52 cards
        Deck deck = new Deck(true);
        deck.shuffle();
        System.out.println(deck);


    }
}
