package me.karunarathne.ProgrammingQuestions ;

import java.util.Stack;

public class PatternMaker {
    private static Stack <Character> stack = null ;

    public static void main(String[] args) {
        stack = new Stack <Character> () ;

        printPattern ( Integer.valueOf( args [0] )) ;
    }

    private static void printPattern(int level) {
        int base = getBaseLength (level) ;
        int halfDepth = getDepth (level) ;
        
        patternMaker (base, halfDepth) ;
        patternPrinter () ;
    }

    private static void patternPrinter() {
        stack.pop() ;
        while (! stack.isEmpty() ) {
            System.out.print ( stack.pop() ) ;
        }
    }

    private static void patternMaker(int base, int halfDepth) {
        addNPrint ('\n') ; addNPrint ('\n') ;
        // Base Line
        for (int i=1; i<=base; i++) addNPrint ('*') ;
        addNPrint ('\n') ;

        // Intermediate Lines
        for (int curDepth=1; curDepth<=halfDepth-2; curDepth++) {
            // starting spaces
            for (int i=1; i<=curDepth; i++) addNPrint (' ') ;

            addNPrint ('*') ; // the single astrix

            // spaces in middle
            for (int i=1; i<=(base-2 -(curDepth*2)) ; i++) addNPrint (' ') ;
            
            addNPrint ('*') ; // the single astrix

            // spaces after
            for (int i=1; i<=curDepth; i++) addNPrint (' ') ;
            addNPrint ('\n') ;
        }

        // Final Line
        for (int i=0; i<=(base/2)-1; i++) addNPrint (' ') ;
        addNPrint ('*') ;
        for (int i=0; i<=(base/2)-1; i++) addNPrint (' ') ;
        addNPrint ('\n') ;
    }

    private static void addNPrint (char character) {
        System.out.print (character) ;
        stack.add (character) ;
    }

    private static int getDepth(int level) {
        return (2 + level) ;
    }

    private static int getBaseLength(int level) {
        return ( 4 + ((2 * level) - 1)) ;
    }
}
