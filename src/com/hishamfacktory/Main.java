package com.hishamfacktory;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //Create game window
        JFrame frame = new JFrame("BlackJack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,700);

        Game blackJack = new Game("Hisham","Dealer",10,100);
        frame.add(blackJack);
        frame.setVisible(true);
        System.out.println("Project directory to start finding images from is: " + System.getProperty("user.dir"));



//        Scanner sc  = new Scanner(System.in);
//        String dealer_name = "Hisham";
//        System.out.println("Welcome to Blackjack Game.");
//        System.out.println("Dealer's name is Hisham and have 2000.0 $ budget");
//        System.out.print("Player name: ");
//        String player_name = sc.next();
//        System.out.print("How many do you want to bet today?: ");
//        double player_bankRoll = sc.nextDouble();
//        System.out.print("How many the betRound: ");
//        double betRound = sc.nextDouble();
        //new Game(player_name,player_bankRoll,dealer_name,betRound);
    }
}
