package pokerController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Winner{

    private List<Player> players;
    private Board board;

    public Winner(List<Player> players, Board board){
        this.players = players;
        this.board = board;
    }

    public int[] getHashArray(Combination combination){
        int[] res = new int[14];
        if(combination.straightFlush()[0]=="Y"){
            res[0] = Integer.parseInt(combination.straightFlush()[1]);
        }
        if(combination.quad()[0] == "Y"){
            res[1] = Integer.parseInt(combination.quad()[1]);
        }
        if(combination.fullHouse()[0]=="Y"){
            res[2] = Integer.parseInt(combination.quad()[1]);
            res[3] = Integer.parseInt(combination.quad()[2]);
        }
        if(combination.flush()[0] == "Y"){
            res[4] = Integer.parseInt(combination.flush()[2]);
        }
        if(combination.straight()[0] == "Y"){
            res[5] = Integer.parseInt(combination.straight()[1]);
        }
        if(combination.set()[0] == "Y"){
            res[6] = Integer.parseInt(combination.set()[1]);
        }
        if(combination.pair()[0] == "Y"){
            if(combination.pair()[1] == "2"){
                res[7] = Integer.parseInt(combination.pair()[3]);
            }
            else{
                res[7] = 0;
            }
            res[8] = Integer.parseInt(combination.pair()[2]);
        }
        
        // Now, we add the kickers.
        int i = 0;
        for (Card card : combination) {
            res[13-i] = Integer.parseInt(card.getValue());
            i += 1;
        }
        return res;
    }

    public int hashArrayToEvaluation(int[] array){
        int res = 0;
        for (int i=0; i<14; i++){
            res += Math.pow(array[i], 13-i);
        }
        return res;
    }

    public Combination bestCombination(Player player){
        // In order to get combinations, the list of all combinations,
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