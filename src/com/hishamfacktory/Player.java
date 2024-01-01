package com.hishamfacktory;

import java.util.Scanner;

public class Player extends Person{
    public Player(String name){
        super.setName(name);
    }
    public void makeDecision(Deck deck, Deck discarded){
        Scanner sc = new Scanner(System.in);
        int decision = 0;
        boolean getNum = true;
        while(getNum){
            try{
                System.out.println("Would you like to 1) hit or 2) stand");
                decision = sc.nextInt();
                getNum = false;
            }catch (Exception e){
                System.out.println("Invalid Input.");
                sc.next();
            }
        }
        if(decision == 1){
            this.hit(deck,discarded);
            if(this.getHand().calculateValue() > 20){
                return;
            }else{
                this.makeDecision(deck,discarded);
            }

        }else{
            System.out.println("You stand...");
        }
    }
}
