package me.karunarathne.ProgrammingQuestions ;

import java.util.ArrayList;
import java.util.Collections;

public class Buru {

    public static void main(String[] args) {
        ArrayList<Card> deck = Card.createDeck() ;

        Collections.shuffle (deck) ;

        for (Card card: deck) System.out.println(card.toString());
    }
}
