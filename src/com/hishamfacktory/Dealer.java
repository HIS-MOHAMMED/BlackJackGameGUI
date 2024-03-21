package com.hishamfacktory;

public class Dealer extends  Person{
    public Dealer(String name){
        super.setName(name);
    }
    public void printFirstHand(){
        System.out.println(this.getName() +  " hand looks like this: ");
        System.out.print(super.getHand().getCard(0));
        System.out.println(" - The second card is face down");
    }
}
