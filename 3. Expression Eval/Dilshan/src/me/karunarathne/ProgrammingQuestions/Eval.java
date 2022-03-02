package me.karunarathne.ProgrammingQuestions ;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Eval {
    private static Stack <Character> mainStack = null ;

    public static void main(String[] args) {
        mainStack = new Stack <Character> () ;

        while (true) {
            if (! mainLoop ()) break ;
        }
    }

    private static boolean mainLoop() {
        return populateMainStack () ;
    }

    private static boolean populateMainStack () {
        System.out.print ("Enter your expression (Q to quit) >  ") ;
        String input = null ;
        try (Scanner scanner = new Scanner (System.in)) {
            input = scanner.nextLine() ;
        }

        if (input.equalsIgnoreCase("q")) return false ;

        reverseAndPopulate (input) ;

        return true ;
    }

    private static void reverseAndPopulate (String input) {
        char [] characters = input.toCharArray() ;
        Collections.reverse (Arrays.asList (characters));
        for (char c: characters) mainStack.add(c) ;
    }
}
