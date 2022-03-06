package me.karunarathne.ProgrammingQuestions ;

import java.util.Arrays;
import java.util.Collections;

public class Buru {
    private static Card [] deck ;

    public static void main(String[] args) {
        deck = Collections.shuffle ( Arrays.asList( Card.createDeck())) ;
    }
}
