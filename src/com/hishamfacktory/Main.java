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
    }
}
