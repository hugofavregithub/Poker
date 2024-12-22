package pokerController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EvaluateMain{
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
         
        // First, we create a board, players and then a game.
        Board board = new Board();
        Deck deck = new Deck(true);
        int state = 1;
        board.boardUpdate(state, deck);
        state += 1;
        board.boardUpdate(state, deck);  
        state += 1;
        board.boardUpdate(state, deck);  


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
        System.out.println(game.toString());

        ArrayList<Card> all = new ArrayList<Card>();
        for (Card card : board) {
            all.add(card);
        }
        for (Card card : julesHand) {
            all.add(card);
        }
        all.remove(0);
        all.remove(0);
        Combination combination = new Combination(all);
        System.out.println(combination.toString());

        List<Combination> julesCombinations = new ArrayList<>();
        julesCombinations = game.allCombinations(Jules);
        System.out.println(julesCombinations.toString());


        Combination julesBestCombination = game.bestCombination(Jules);
        Combination loicBestCombination = game.bestCombination(Loic);
        System.out.println("Jules's best combination : " + julesBestCombination.toString() + ", Loïc best combination : " + loicBestCombination.toString());
        Player winner = game.winningPlayer();
        System.out.println(winner);
    }
}
