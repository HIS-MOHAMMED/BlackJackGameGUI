package com.hishamfacktory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Welcome to Blackjack Game.");
        System.out.print("Can you give me your name: ");
        String name = sc.next();
        Game game = new Game(name);
    }
}
