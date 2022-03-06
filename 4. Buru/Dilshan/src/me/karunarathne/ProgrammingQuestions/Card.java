package me.karunarathne.ProgrammingQuestions;

public class Card {
    Suit suit = null ;
    Rank rank = null ;

    public Card (Suit suit, Rank rank) {

    } 

    public Card (Suit suit, String rank) {
        
    } 

    @Override
    public String toString() {
        return generateString() ;
    }

    private String generateString () {
        // return "┌─────────┐\n| " + getLabel () + "      |\n"  + 
        //         """
        //     |         |
        //     |         |
        //     |         |
        //         """ +
        //     "|       " + getLabel () + "|\n└─────────┘ ";

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