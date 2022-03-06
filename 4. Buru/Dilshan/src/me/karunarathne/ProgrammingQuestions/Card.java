package me.karunarathne.ProgrammingQuestions;

public class Card {
    Suit suit = null ;
    String rank = null ;

    public Card (Suit suit, Rank rank) {

    }

    public Card (Suit suit, String rank) {
        
    }

    @Override
    public String toString() {
        return super.toString() ;
    }
}

enum Suit {
    Clubs, Diamonds, Hearts, Spades 
} 

enum Rank {
    Ace, King, Queen, Jack, Ten , Nine, Eight, Seven, Six, Five, Four, Three, Deuce
} 