package me.karunarathne.ProgrammingQuestions;

import java.util.ArrayList;

public class Card {
    Suit suit ;
    Rank rank ;

    public Card (Suit suit, Rank rank) {
        this.suit = suit ;
        this.rank = rank ;
    } 

    public static ArrayList <Card> createDeck () {
        ArrayList <Card> deck = new ArrayList <> () ;
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                deck.add( new Card (suit, rank)) ; 
            }
        }
        return deck ;
    }

    @Override
    public String toString() {
        return generateString() ;
    }

    private String generateString () {
        String ascii = """
        ┌─────────┐
        | @       |
        |         |
        |    #    |
        |         |
        |       @ |
        └─────────┘
                """ ;
        if (rank.equals(Rank.Ten)) {
            ascii = """
        ┌─────────┐
        | 10      |
        |         |
        |    #    |
        |         |
        |      10 |
        └─────────┘
                """ ;
        }

        return ascii.replace ("@", rank.toString()).replace("#", suit.toString()) ;
    }

    @Override
    public boolean equals (Object obj) {
        if (! obj.getClass().equals(Card.class)) return false ;

        Card theOther = (Card) obj ;
        return this.rank == theOther.rank && this.suit == theOther.suit ;
    }
}

enum Suit {
    Clubs ("♣"), Diamonds ("♢"), Hearts ("♡"), Spades ("♠") ;

    final String value ;

    Suit (String value) {
        this.value = value ;
    }

    @Override
    public String toString () {
        return value ;
    }
} 

enum Rank {
    Ace ("A"), King ("K"), Queen ("Q"), Jack ("J"), 
    Ten ("10") , Nine ("9"), Eight ("8"), Seven ("7"), 
    Six ("6"), Five ("5"), Four ("4"), Three ("3"), Deuce ("2") ;

    final String value ;

    Rank (String value) {
        this.value = value ;
    }

    @Override
    public String toString () {
        return value ;
    }
} 