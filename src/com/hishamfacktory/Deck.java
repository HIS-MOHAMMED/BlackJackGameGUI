package com.hishamfacktory;

import java.util.ArrayList;
public class Deck {
    ArrayList<Card> deck ;
    public Deck(){
        deck = new ArrayList<>();
    }
    public Deck(boolean makeFullDeck){
        deck = new ArrayList<>();
        if(makeFullDeck){
            for(Suit suit : Suit.values()){
                for(Rank rank : Rank.values()){
                    deck.add(new Card(suit,rank));
                }
            }
        }
    }
    public void shuffle(){
        ArrayList<Card> shuffled = new ArrayList<>();
        while(deck.size() > 0){
            int cardToPull = (int)(Math.random() * (deck.size()-1));
            shuffled.add(deck.get(cardToPull));
            deck.remove(cardToPull);
        }
        deck = shuffled;

        //shorter way to shuffle the deck by using collections
        //Collections.shuffle(deck,new Random());

   }
    public void addCard(Card card){
        deck.add(card);
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
