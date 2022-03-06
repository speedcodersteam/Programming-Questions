package me.karunarathne.ProgrammingQuestions ;

import java.util.ArrayList;
import java.util.Collections;
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

    private static boolean mainLoop () throws Exception {
        Collections.shuffle (deck) ;

        System.out.println ("Select a card") ;
        Card selectedCard = cardSelector () ;

        System.out.print ("Would you like to play again (Y/N) > ") ;
        return ! scanner.nextLine().equalsIgnoreCase("n");
    }

    private static Card cardSelector() {
        System.out.println ("\n\tS - Spades ♠\t\tD - Diamonds ♢\n" +
                            "\tC - Clubs ♣\t\tH - Hearts ♡") ;
        System.out.print ("\tSelect Suite > ") ;
        scanner.nextLine() ;
    }
}
