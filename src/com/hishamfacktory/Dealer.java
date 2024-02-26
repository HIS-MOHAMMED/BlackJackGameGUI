package com.hishamfacktory;

public class Dealer extends  Person{
    public Dealer(){
        super.setName("Dealer");
    }
    public void printFirstHand(){
        System.out.println(this.getName() +  " hand looks like this: ");
        System.out.print(super.getHand().getCard(0));
        System.out.println(" - The second card is face down");
    }
}
