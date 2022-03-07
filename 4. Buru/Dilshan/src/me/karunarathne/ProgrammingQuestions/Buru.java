package me.karunarathne.ProgrammingQuestions ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static me.karunarathne.ProgrammingQuestions.Finder.findRank;
import static me.karunarathne.ProgrammingQuestions.Finder.findSuite;
import static me.karunarathne.ProgrammingQuestions.Prints.*;

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

            Prints.printTitle () ;

            while (true) {
                if (!mainLoop()) break;
            }
        } catch (Exception e) {
            e.printStackTrace() ;
        } finally {
            scanner.close() ;

            printFooter () ;
        }
    }

    private static boolean mainLoop ()  {
        Collections.shuffle (deck) ;

        println ("Select a card", PrintColor.BLUE) ;

        String result = check ( cardSelector ()) ? "You won !" : "You lost !" ;
        println ("\t" + result, PrintColor.PURPLE) ;

        print ("\nWould you like to play again (Y/N) > ", PrintColor.BLUE) ;
        return ! scanner.nextLine().equalsIgnoreCase("n");
    }

    private static boolean check (Card selectedCard) {
        int flag = 1 ;
        println ("\n\tLet's Play... ", PrintColor.PURPLE) ;
        println ("\tYour card will appear in GREEN", PrintColor.GREEN) ;
        println ("\tYour opponent's card will appear in RED\n", PrintColor.RED) ;

        for (Card card: deck) {
            flag ++ ;
            if (isOdd (flag)) {
                println (card.toString(), PrintColor.GREEN) ;
                if ( card.equals ( selectedCard )) return true ;
            } else {
                println (card.toString(), PrintColor.RED) ;
                if ( card.equals ( selectedCard )) return false ;
            }
        }
        return false ;
    }

    private static boolean isOdd (int number) {
        return number % 2 == 0 ;
    }

    private static Card cardSelector() {
        println ("\tS - Spades ♠\t\tD - Diamonds ♢\t\tC - Clubs ♣\t\tH - Hearts ♡", PrintColor.GREEN) ;
        print ("\tSelect Suite > ", PrintColor.CYAN) ;
        String suite = scanner.nextLine() ;

        println ("\tA, K, Q, J, 10, 9 ... 2", PrintColor.GREEN) ;
        print ("\tSelect Rank > ", PrintColor.CYAN) ;
        String rank = scanner.nextLine() ;

        return new Card (findSuite (suite), findRank (rank) ) ;
    }
}
