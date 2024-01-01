package com.hishamfacktory;

import java.util.Scanner;

public class Game {
    //declare some variables needed for Game class
    private Deck deck,discarded;
    private Player player;
    private Dealer dealer;
    private int wins,losses,pushes;

    /*
    Constructor for Game,creates our variables and starts the game
     */
    public Game(String name){
        //create a new deck with 52 cards
        deck = new Deck(true);
        discarded = new Deck();

        //create the people
        dealer = new Dealer();
        player = new Player(name);

        //shuffle the deck and start the round
        deck.shuffle();
        startRound();
    }

    public void startRound() {
        //Give the dealer two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        //Give the player two cards
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        dealer.printFirstHand();
        player.printHand();

        if(dealer.hasBlackJack()){
            dealer.printHand();
            if(player.hasBlackJack()){
                System.out.println("You both have 21 - Push.");
                pushes++;
                startRound();
            }
            else{
                System.out.println("Dealer has BlackJack.You lose.");
                losses++;
                startRound();
            }
        }
        if(player.hasBlackJack()){
            player.printHand();
            System.out.println("Player has BlackJack.You Win :)");
            wins++;
            startRound();
        }
        player.makeDecision(deck,discarded);
    }
    public void finalResult(int p, int d) {
        if (p == 21) {
            wins++;
            System.out.println("You Won.");
        } else if (p > d && p < 21) {
            wins++;
            System.out.println("You Won.");
        } else if (p < 21 && d > 21) {
            wins++;
            System.out.println("The dealer busts.");
        } else if (d == 21) {
            losses++;
            System.out.println("The dealer Won.");
        } else if (p > 21) {
            losses++;
            System.out.println("You busts");
        } else if (d > p && d < 21) {
            losses++;
            System.out.println("You busts");
        }
    }
    public void printDiscarded(){
        System.out.println("Discarded Cards: ");
        for(Card card : discarded.deck){
            System.out.print(card.toString() + " | ");
        }
        System.out.println();
    }
}
