package com.hishamfacktory;

import javax.swing.*;
import java.awt.*;

public class Dealer extends  Person{
    public Dealer(String name){
        super.setBankRoll(2000.0);
        super.setName(name);
    }
    public void printFirstHand(JLabel[] cardPics){
        System.out.println(this.getName() +  " hand looks like this: ");
        System.out.print(super.getHand().getCard(0));
        System.out.println(" - The second card is face down");

        for (int i = 0; i < 11; i++) {
            cardPics[i].setVisible(false);
        }
        //show the first card for dealer
        String rank = this.getHand().getCard(0).getRank().toString();
        String suit = this.getHand().getCard(0).getSuit().toString();
        String filename = rank + suit +".png";
        System.out.println(filename);
        cardPics[0].setIcon(new ImageIcon(new ImageIcon(Game.IMAGE_DIR+filename).getImage().getScaledInstance(Game.CARD_WIDTH,Game.CARD_HEIGHT, Image.SCALE_SMOOTH)));
        cardPics[0].setVisible(true);

        //show card down of second card for dealer.
        cardPics[1].setIcon(new ImageIcon(new ImageIcon(Game.IMAGE_DIR+"CardDown.png").getImage().getScaledInstance(Game.CARD_WIDTH,Game.CARD_HEIGHT, Image.SCALE_SMOOTH)));
        cardPics[1].setVisible(true);
    }
}
