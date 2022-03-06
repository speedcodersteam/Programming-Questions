package me.karunarathne.ProgrammingQuestions;

import java.util.ArrayList;
import java.util.List;

public class Card {
    Suit suit ;
    Rank rank ;

    public Card (Suit suit, Rank rank) {
        this.suit = suit ;
        this.rank = rank ;
    } 

    public static List <Card> createDeck () {
        List <Card> deck = new ArrayList <> () ;
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
        | ##      |
        |         |
        |    #    |
        |         |
        |      ## |
        └─────────┘
                """ ;
        return ascii.replace("#", suit.toString()).replace("##", getLabel()) ;
    }

    private String getLabel() {
        if (rank == Rank.Ten) return "10" ;
        return " " + rank.toString() ;
    }
}

enum Suit {
    Clubs ("♣"), Diamonds ("♢"), Hearts ("♡"), Spades ("♠") ;

    String value ;

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

    String value ;

    Rank (String value) {
        this.value = value ;
    }

    @Override
    public String toString () {
        return value ;
    }
} 