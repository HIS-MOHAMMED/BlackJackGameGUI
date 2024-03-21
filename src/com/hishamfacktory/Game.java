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
    public Game(String Player_name,String Dealer_name){
        //create a new deck with 52 cards
        deck = new Deck(true);
        discarded = new Deck();

        //create the people
        dealer = new Dealer(Dealer_name);
        player = new Player(Player_name);

        //shuffle the deck and start the round
        deck.shuffle();
        startRound();
    }

    public void startRound() {
        Scanner sc = new Scanner(System.in);
        if(wins > 0 || losses > 0 || pushes > 0) {
            System.out.print("\nQuit or keep continue(y or n?)");
            String result = sc.next();
            try {
                if (result.equals("Y") || result.equals("y") || result.equals("yes")) {
                    System.out.println(".............................................New Round................................................................");
                    System.out.println("Starting  Next Round.....Wins: " + wins + " Loses: " + losses + " Pushes: " + pushes +"\n");
                    player.getHand().discardHandToDeck(discarded);
                    dealer.getHand().discardHandToDeck(discarded);
                }else{
                    System.out.println("Thank You");
                    System.out.println("Final Results: Wins= " + wins + " Loses= " + losses + " Pushes= " + pushes);
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                startRound();
            }
        }
        //check make sure the deck has at least 4 cards
        if(deck.cardsLeft() < 4){
            deck.reloadDeckFromDiscarded(discarded);
        }
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
        if(player.getHand().calculateValue() > 21){
            System.out.println("You have gone over 21 ");
            losses++;
            startRound();
        }
        //Now it's the dealer's turn
        dealer.printHand();
        while(dealer.getHand().calculateValue() < 17){
            dealer.hit(deck,discarded);
        }
        //prepare results to make comparisons
        int  player_result = player.getHand().calculateValue();
        int dealer_result = dealer.getHand().calculateValue();
        if(dealer_result > 21){
            System.out.println("Dealer busts..");
            wins++;
        }
        else if(dealer_result > player_result){
            System.out.println("You Lose..");
            losses++;
        }
        else if(player_result > dealer_result){
            System.out.println("You win..");
            wins++;
        }
        else {
            System.out.println("Push");
            pushes++;
        }
        //start new round
        startRound();


    }

}
