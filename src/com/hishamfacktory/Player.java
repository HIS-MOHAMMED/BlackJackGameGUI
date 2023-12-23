package com.hishamfacktory;

import java.util.Scanner;

public class Player extends Person{
    public Player(String name){
        super.setName(name);
    }
    public boolean makeDecision(int value){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to 1) hit or 2) stand");
        value = sc.nextInt();
        if(value == 1){
            return true;
        }else {
            return false;
        }
    }
}
