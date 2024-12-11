package pokerController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinnerMain{
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        Winner winner = new Winner(null, null);

        List<Card> combinationPlayer = new ArrayList<Card>();
        combinationPlayer.add(new Card("H", "6"));
        combinationPlayer.add(new Card("H", "8"));
        combinationPlayer.add(new Card("H", "10"));
        combinationPlayer.add(new Card("H", "5"));
        combinationPlayer.add(new Card("H", "7"));
        Combination combination = new Combination(combinationPlayer);

        int[] evaluation = winner.getHashArray(combination);
        System.out.println(Arrays.toString(evaluation));
        System.out.println(winner.hashArrayToEvaluation(evaluation));
        
        // Board board = new Board();
        // Deck deck = new Deck(false);
        // int state = 1;
        // board.boardUpdate(state, deck);
        // state += 1;
        // board.boardUpdate(state, deck);  
        // state += 1;

        // List<Card> julesHand = new ArrayList<>();
        // julesHand.add(new Card("S", "10"));
        // julesHand.add(new Card("S", "9"));

        // List<Card> loicHand = new ArrayList<>();
        // loicHand.add(new Card("S", "8"));
        // loicHand.add(new Card("S", "7"));


        // Player Jules = new Player("Jules", julesHand, 1);
        // Player Loic = new Player("Loïc", loicHand, 1);
        // List<Player> players = new ArrayList<>();
        // players.add(Jules);
        // players.add(Loic);

        // Winner winner = new Winner(players, board);

        // Combination bestJules = winner.bestCombination(Jules);
        // Combination bestLoic = winner.bestCombination(Loic);

        // for (Card card : bestJules) {
        //     System.out.println(card.getColor() + " " + card.getValue());
        // }
        // for (Card card : bestLoic) {
        //     System.out.println(card.getColor() + " " + card.getValue());
        // }
    }
}
