package com.hishamfacktory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Welcome to Blackjack Game.");
        System.out.print("Dealer name:");
        String dealer_name = sc.next();
        System.out.print("Player name: ");
        String player_name = sc.next();
        Game game = new Game(player_name,dealer_name+" (dealer)");
    }
}
