package com.hishamfacktory;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class Game {
    private int wins;
    private int losses;
    private int pushes;

    public Game(String name) {
        wins = 0;
        losses = 0;
        pushes = 0;
        Deck deck = new Deck(true);
        Deck discardDeck = new Deck();
        deck.shuffle();

        this.startRound(deck,name);
    }

    public void startRound(Deck deck,String name) {
        Player player = new Player(name);
        Dealer dealer = new Dealer();
        System.out.println("Welcome " + player.getName() + " :)");
        String quit = "";
        do {
            for (int i = 0; i < 2; i++) {
                player.getHand().takeCardFromDeck(deck);
                dealer.getHand().takeCardFromDeck(deck);
            }
            dealer.printFirstHand();
            System.out.println(player.getHand().toString("Your"));

            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to : 1) Hit  or 2) Stand");
            int option = sc.nextInt();
            boolean checking = true;
            switch (option) {
                case 1:
                    while (checking) {
                        System.out.println("The dealer gives you a card from the deck");
                        player.getHand().takeCardFromDeck(deck);
                        System.out.println(player.getHand().toString("Your"));
                        checking =player.makeDecision(player.getHand().calculateValue());
                    }
                    checking = true;
                    while (checking) {
                        System.out.println("Dealer draws a card");
                        System.out.println(dealer.getHand().toString("The dealer's"));
                        dealer.getHand().takeCardFromDeck(deck);
                        if (dealer.getHand().calculateValue() > 17) checking = false;
                    }
                    break;
                case 2:
                    checking = true;
                    System.out.println("You Stand");
                    while (checking) {
                        System.out.println(dealer.getHand().toString("The Dealer's"));
                        dealer.getHand().takeCardFromDeck(deck);
                        if (dealer.getHand().calculateValue() > 17) checking = false;

                    }
                    break;
            }
            int p = player.getHand().calculateValue(), d = dealer.getHand().calculateValue();
            finalResult(p,d);
            System.out.println("Starting Next Round.. Wins: " + wins + " Losses: " + losses + " Pushes: " + pushes);
            System.out.print("Type q to Quit or y to keep playing: ");

            quit = sc.next();
            player = new Player(name);
            dealer = new Dealer();
            System.out.println("..........................................................................");
        } while (quit != "quit" || quit != "q");
        System.out.println("Thank You , Keep Enjoying.");
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
}
