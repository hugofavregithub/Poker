package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import pokerController.Card;
import pokerController.Deck;

public class DeckMain {
 
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Deck deck = new Deck(true);
        for (Card card : deck) {
            System.out.println(card.getColor() + " " + card.getValue());
        }
    }
}