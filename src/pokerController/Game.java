package pokerController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Game{

    private List<Player> players;
    private List<Card> board;

    public Game(List<Player> players, List<Card> board){
        this.players = players;
        this.board = board;
    }

    public Combination bestCombination(Player player){
        // In order to get combinations, the list of all combinations,
        List<Card> allCards = new ArrayList<Card>();
        allCards.addAll(board);
        allCards.addAll(player.getHand());

        List<Combination> combinations =  new ArrayList<Combination>();
        for(int i=0; i<6; i++){
            for(int j=i+1; j<7; j++){
                List<Card> current = new ArrayList<Card>();
                current.addAll(allCards);
                current.remove(i);
                current.remove(j);
                combinations.add(new Combination(current));
            }
        }

        // Can we sort the array with Comparable<Combination>?
        Collections.sort(combinations);
        return combinations.getLast();
    }

    public Player winningPlayer(){
        TreeMap<Combination, Player> bestCombinations = new TreeMap<Combination, Player>();
        for (Player player : players) {
            bestCombinations.put(bestCombination(player), player);
        }
        return bestCombinations.get(bestCombinations.lastKey());
    }
}