package pokerController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvaluateMain{
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
                
        Board board = new Board();
        Deck deck = new Deck(false);
        int state = 1;
        board.boardUpdate(state, deck);
        state += 1;
        board.boardUpdate(state, deck);  
        state += 1;

        List<Card> julesHand = new ArrayList<>();
        julesHand.add(new Card("S", "10"));
        julesHand.add(new Card("S", "9"));

        List<Card> loicHand = new ArrayList<>();
        loicHand.add(new Card("S", "8"));
        loicHand.add(new Card("S", "7"));

        Player Jules = new Player("Jules", julesHand, 1);
        Player Loic = new Player("Loïc", loicHand, 1);
        List<Player> players = new ArrayList<>();
        players.add(Jules);
        players.add(Loic);

        Evaluate game = new Evaluate(players, board);

        List<Combination> allJules = game.allCombinations(Jules);
        List<Combination> allLoic = game.allCombinations(Loic);

        for (Combination combination : allJules) {
            combination.print();
        }
        // for (Card card : bestJules) {
        //     System.out.println(card.getColor() + " " + card.getValue());
        // }
        // for (Card card : bestLoic) {
        //     System.out.println(card.getColor() + " " + card.getValue());
        // }
    }
}
