package com.hishamfacktory;

import java.util.ArrayList;
public class Deck {
    ArrayList<Card> deck ;
    public Deck(){
        deck = new ArrayList<>();
    }
    public Deck(boolean makeFullDeck){
        deck = new ArrayList<>();
        if(makeFullDeck) {
            for (int i = 0; i < 8; i++) {
                for (Suit suit : Suit.values()) {
                    for (Rank rank : Rank.values()) {
                        deck.add(new Card(suit, rank));
                    }
                }
            }
        }
    }
    public void shuffle(){
        ArrayList<Card> shuffled = new ArrayList<>();
        while(!deck.isEmpty()){
            int cardToPull = (int)(Math.random() * (deck.size()-1));
            shuffled.add(deck.get(cardToPull));
            deck.remove(cardToPull);
        }
        deck = shuffled;

        //shorter way to shuffle the deck by using collections
        //.shuffle(deck,new Random());

   }
    public void addCard(Card card){
        deck.add(card);
    }
    public Card takeCard(){
        Card cardToTake = new Card(deck.get(0));
        deck.remove(0);
        return cardToTake;
    }
    public boolean hasCard(){
        return !deck.isEmpty();
    }
    public void emptyDeck(){
        deck.clear();
    }
    public void addCards(ArrayList<Card> cards){
        this.deck.addAll(cards);
    }
    public void reloadDeckFromDiscarded(Deck discarded){
        this.addCards(discarded.getCards());
        this.shuffle();
        discarded.emptyDeck();
        System.out.println("*****************Ran out of cards, Creating new deck from discarded pile & shuffling the deck.***************************\n");

    }
    public ArrayList<Card> getCards(){
        return this.deck;
    }
    public int cardsLeft(){
        return deck.size();
    }


    public String toString(){
        String output = "";
        for(Card card : deck){
            output += card;
            output += "\n";
        }
        return output;
    }
}
