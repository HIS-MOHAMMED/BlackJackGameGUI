package com.hishamfacktory;

public class Dealer extends  Person{
    public Dealer(){
        super.setName("Dealer");
    }
    public void printFirstHand(){
        System.out.print(this.getHand().toString(true));
        System.out.println(" - Second is hide.");
    }
}
