package com.hishamfacktory;

public class Game {
    private int wins;
    private int losses;
    private int pushes;

    public Game(String name){
        wins = 0;
        losses = 0;
        pushes = 0;
        Deck deck = new Deck(true);
        Deck discardDeck = new Deck();
        deck.shuffle();
        Player player = new Player(name);
        Dealer dealer = new Dealer();
        System.out.println("Welcome " + player.getName() + " :)");
        this.startRound(player,dealer,deck,discardDeck);
    }
    public void startRound(Player player,Dealer dealer,Deck deck,Deck discard){
        while(true){
            for(int i = 0 ; i < 2 ; i++){
                dealer.getHand().takeCardFromDeck(deck);
                player.getHand().takeCardFromDeck(deck);
            }
            System.out.print("The Dealer Cards are: ");
            dealer.printFirstHand();
            System.out.print("The Player Cards are: ");
            System.out.println(player.getHand().toString());
            if(player.hasBlackJack()) {
                System.out.println("The Player win.");
                break;
            }
            else if(dealer.hasBlackJack()){
                System.out.println("The Dealer win.");
                break;
            }else{
                System.out.println("Do you want hit?");
                break;
            }

        }
    }
}
