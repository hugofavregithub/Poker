package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import pokerController.Board;
import pokerController.Card;
import pokerController.Deck;

public class BoardMain {
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Board board = new Board();
        Deck deck = new Deck();
        int state = 1;
        board.boardUpdate(state, deck);
        for (Card card : board) {
            System.out.println(card.getColor() + " " + card.getValue());
        }
        System.out.println(""); 
        state += 1;
        board.boardUpdate(state, deck);
        for (Card card : board) {
            System.out.println(card.getColor() + " " + card.getValue());
        }
        System.out.println(""); 
        state += 1;
        board.boardUpdate(state, deck);
        for (Card card : board) {
            System.out.println(card.getColor() + " " + card.getValue()); 
        }
        System.out.println(""); 
    }
}
