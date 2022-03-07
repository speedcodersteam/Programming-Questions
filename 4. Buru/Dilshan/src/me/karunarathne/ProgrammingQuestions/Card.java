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
                \t\t┌─────────┐
                \t\t| @       |
                \t\t|         |
                \t\t|    #    |
                \t\t|         |
                \t\t|       @ |
                \t\t└─────────┘
                """ ;
        if (rank.equals(Rank.Ten)) {
            ascii = """
                \t\t┌─────────┐
                \t\t| 10      |
                \t\t|         |
                \t\t|    #    |
                \t\t|         |
                \t\t|      10 |
                \t\t└─────────┘
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

class Finder {
    public static Rank findRank (String keyword) {
        return Rank.valueOf ( getRank ( keyword.toUpperCase ()) ) ;
    }

    private static String getRank (String rankString) {
        return switch (rankString) {
            case "A" -> "Ace";
            case "K" -> "King";
            case "Q" -> "Queen";
            case "J" -> "Jack";
            case "10" -> "Ten";
            case "9" -> "Nine";
            case "8" -> "Eight";
            case "7" -> "Seven";
            case "6" -> "Six";
            case "5" -> "Five";
            case "4" -> "Four";
            case "3" -> "Three";
            case "2" -> "Deuce";
            default -> null;
        };
    }

    public static Suit findSuite (String keyword) {
        return Suit.valueOf( getSuite ( keyword.toUpperCase () )) ;
    }

    private static String getSuite (String suiteLetter) {
        return switch ( suiteLetter.charAt (0) ) {
            case 'C', 'c' -> "Clubs";
            case 'D', 'd' -> "Diamonds";
            case 'H', 'h' -> "Hearts";
            case 'S', 's' -> "Spades";
            default -> "";
        } ;
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