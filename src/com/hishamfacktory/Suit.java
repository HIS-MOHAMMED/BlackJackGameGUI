package com.hishamfacktory;

public enum Suit {
    CLUB("Club"),
    DIAMOND("Diamond"),
    HEART("Heart"),
    SPADE("Spade");

    String suitName;
    Suit(String suitName){
        this.suitName = suitName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
