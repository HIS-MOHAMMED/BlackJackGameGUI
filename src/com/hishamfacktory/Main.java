package com.hishamfacktory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        String dealer_name = "Hisham";
        System.out.println("Welcome to Blackjack Game.");
        System.out.println("Dealer's name is Hisham and have 2000.0 $ budget");
        System.out.print("Player name: ");
        String player_name = sc.next();
        System.out.print("How many do you want to bet today?: ");
        double player_bankRoll = sc.nextDouble();
        System.out.print("How many the betRound: ");
        double betRound = sc.nextDouble();
        new Game(player_name,player_bankRoll,dealer_name,betRound);
    }
}
