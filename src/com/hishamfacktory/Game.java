package com.hishamfacktory;

import java.util.Objects;
import java.util.Scanner;

public class Game {
    //declare some variables needed for Game class
    private Deck deck,discarded;
    private double betRound;
    private Player player;
    private Dealer dealer;
    private int wins,losses,pushes;

    /*
    Constructor for Game,creates our variables and starts the game
     */
    public Game(String Player_name,double player_bankRoll,String dealer_name,double betRound){
        //create a new deck with 52 cards
        deck = new Deck(true);
        discarded = new Deck();

        //create the people
        dealer = new Dealer(dealer_name);
        player = new Player(Player_name,player_bankRoll);
        this.betRound = betRound;

        //shuffle the deck and start the round
        deck.shuffle();
        startRound();
    }

    public void startRound() {
        Scanner sc = new Scanner(System.in);
        try {
            if (player.getBankRoll() >= betRound && dealer.getBankRoll() >= betRound) {
                if (wins > 0 || losses > 0 || pushes > 0) {
                    System.out.println("\nWins: "+wins + "  Loses: " + losses + "  Pushes: " + pushes + " | " + player.getName() +
                            "'s budget is: " + player.getBankRoll() + " | " + dealer.getName() + "'s budget is: " + dealer.getBankRoll() + "\n");
                    System.out.print("\nQuit or keep continue(y or n?)");
                    String result = sc.next();

                    if (result.equals("Y") || result.equals("y") || result.equals("yes")) {
                        System.out.println("..........................................New Round................................................................");
                        player.getHand().discardHandToDeck(discarded);
                        dealer.getHand().discardHandToDeck(discarded);
                    } else {
                       finalResults();
                    }
                }else{
                    System.out.println(".............................................New Game................................................................");
                    player.getHand().discardHandToDeck(discarded);
                    dealer.getHand().discardHandToDeck(discarded);
                }
            } else {
                String refundDeicion;
                double refundBudget;
                if (player.getBankRoll() < betRound) {
                    finalResults();
                    System.out.print(player.getName() + "'s budget was ended......Do you want to refund?(y or n)? ");
                    refundDeicion = sc.next();
                    if (refundDeicion.equals("y")) {
                        System.out.print("How many do you want to refund: ");
                        refundBudget = sc.nextDouble();
                        player.setBankRoll(refundBudget);
                        startRound();
                    }else{
                        System.out.println("Thank You  Have a nice day.");
                        System.exit(0);
                    }
                } else {
                    finalResults();
                    System.out.println("Dealer refund his budget to 2000.0");
                    dealer.setBankRoll(2000.0);
                    startRound();
                }
            }
        }catch (Exception e) {
            System.out.println("Invalid Input");
            startRound();
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
                player.decrease_budget(betRound);
                dealer.increase_budget(betRound);
                startRound();
            }
        }
        if(player.hasBlackJack()){
            player.printHand();
            System.out.println("Player has BlackJack.You Win :)");
            wins++;
            player.increase_budget(betRound);
            dealer.decrease_budget(betRound);
            startRound();
        }
        player.makeDecision(deck,discarded);
        if(player.getHand().calculateValue() > 21){
            System.out.println("You have gone over 21 ");
            losses++;
            player.decrease_budget(betRound);
            dealer.increase_budget(betRound);
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
            player.increase_budget(betRound);
            dealer.decrease_budget(betRound);
        }
        else if(dealer_result > player_result){
            System.out.println("You Lose..");
            losses++;
            player.decrease_budget(betRound);
            dealer.increase_budget(betRound);
        }
        else if(player_result > dealer_result){
            System.out.println("You win..");
            wins++;
            player.increase_budget(betRound);
            dealer.decrease_budget(betRound);
        }
        else {
            System.out.println("Push");
            pushes++;
        }
        //start new round
        startRound();
    }
    public void finalResults(){
        System.out.println("..............................................Game Finished...............................................");
        System.out.println("Thank You");
        System.out.println("Final Results: Wins= " + wins + " Loses= " + losses + " Pushes= " + pushes + "\n");
        wins = 0;
        losses = 0;
        pushes = 0;
    }

}
