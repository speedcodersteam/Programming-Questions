package me.karunarathne.ProgrammingQuestions ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

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
            System.out.println (card) ;
            flag ++ ;
            return (card.equals(selectedCard) && isOdd (flag)) ;
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

        return new Card (Suit.valueOf(suite.toUpperCase()), Rank.valueOf( getValue(rank) )) ;
    }

    private static String getValue (String rank) {
        return switch ( rank.charAt (0) ) {
            case 'C', 'c' -> "♣";
            case 'D', 'd' -> "♢";
            case 'H', 'h' -> "♡";
            case 'S', 's' -> "♠";
            default -> "";
        } ;
    }
}
