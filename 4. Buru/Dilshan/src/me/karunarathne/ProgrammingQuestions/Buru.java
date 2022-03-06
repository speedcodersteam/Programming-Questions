package me.karunarathne.ProgrammingQuestions ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static me.karunarathne.ProgrammingQuestions.Finder.findRank;
import static me.karunarathne.ProgrammingQuestions.Finder.findSuite;

public class Buru {
    private static ArrayList <Card> deck ;
    private static Scanner scanner ;

    public static void main(String[] args) {
        play() ;
    }

    public static void play () {
        try {
            scanner = new Scanner(System.in);
            deck = Card.createDeck();

            while (true) {
                if (!mainLoop()) break;
            }
        } catch (Exception e) {
            e.printStackTrace() ;
        } finally {
            scanner.close() ;
        }
    }

    private static boolean mainLoop ()  {
        Collections.shuffle (deck) ;

        System.out.println ("Select a card") ;

        String result = check ( cardSelector ()) ? "You won !" : "You lost !" ;
        System.out.println ("\n\t" + result) ;

        System.out.print ("Would you like to play again (Y/N) > ") ;
        return ! scanner.nextLine().equalsIgnoreCase("n");
    }

    private static boolean check (Card selectedCard) {
        int flag = 1 ;
        for (Card card: deck) {
            flag ++ ;
            if (isOdd (flag)) {
                System.out.println (card) ;
                if ( card.equals ( selectedCard )) return true ;
            }
        }
        return false ;
    }

    private static boolean isOdd (int number) {
        return number % 2 == 0 ;
    }

    private static Card cardSelector() {
        System.out.println ("""
                \tS - Spades ♠\t\tD - Diamonds ♢
                \tC - Clubs ♣\t\tH - Hearts ♡
                    """) ;
        System.out.print ("\tSelect Suite > ") ;
        String suite = scanner.nextLine() ;

        System.out.println ("A, K, Q, J, 10, 9 ... 2") ;
        System.out.print ("\tSelect Rank > ") ;
        String rank = scanner.nextLine() ;

        return new Card (findSuite (suite), findRank (rank) ) ;
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
            case "2" -> "Two";
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
