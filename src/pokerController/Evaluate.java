package pokerController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Evaluate{

    private List<Player> players;
    private Board board;

    public Evaluate(List<Player> players, Board board){
        this.players = players;
        this.board = board;
    }

    public List<Card> all(Player player){
        List<Card> allCards = new ArrayList<Card>();
        for (Card card : board) {
            allCards.add(card);
        }
        allCards.addAll(player.getHand());
        return allCards;
    }

    public List<Card> remove(List<Card> allCards, int i, int j){
        List<Card> res = new ArrayList<Card>();
        res.addAll(allCards);
        res.remove(i);
        res.remove(j);
        //Combination ret = new Combination(res);
        return res;
    }

    public List<Combination> allCombinations(Player player){
        List<Card> allCards = new ArrayList<Card>();
        for (Card card : board) {
            allCards.add(card);
        }
        allCards.addAll(player.getHand());

        List<Combination> combinations =  new ArrayList<Combination>();
        for(int i=0; i<6; i++){
            for(int j=i+1; j<7; j++){
                List<Card> current = new ArrayList<Card>();
                current.addAll(allCards);
                current.remove(j);
                current.remove(i);
                combinations.add(new Combination(current));
            }
        }
        return combinations;
    }
    
    public Combination bestCombination(Player player){
        List<Card> allCards = new ArrayList<Card>();
        for (Card card : board) {
            allCards.add(card);
        }
        allCards.addAll(player.getHand());

        List<Combination> combinations =  new ArrayList<Combination>();
        for(int i=0; i<6; i++){
            for(int j=i+1; j<7; j++){
                List<Card> current = new ArrayList<Card>();
                current.addAll(allCards);
                current.remove(j);
                current.remove(i);
                combinations.add(new Combination(current));
            }
        }
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

    @Override
    public String toString(){
        String str = "";
        for (Player player : players) {
            str += player.toString();
            str += ", ";
        }
        str += board.toString();
        return str;
    }
}