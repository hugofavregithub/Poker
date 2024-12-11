package pokerController;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Class representing combination of cards and evaluates them.
 */

public class Combination implements Comparable<Combination>, Iterable<Card>{
    /** List of 5 cards representing combination */
    private List<Card> combinationPlayer;
    
    public Combination(List<Card> combinationPlayer){
        this.combinationPlayer = combinationPlayer;
        Collections.sort(combinationPlayer); //We sort cards.
    }

    /**
     * Method to make this class iterable
     * 
     * @return iterable list
     */
    public Iterator<Card> iterator(){
        return combinationPlayer.iterator();
    }

    /**
     * Determined if there is a pair or double pair
     * 
     * @return an array of 4 strings. 1st is "Y" if there is a pair "N" otherwise.
     * 2nd is the number of pair. 3rd is the value of the strongest pair. 4th is the value of the second pair or null.
     */
    public String[] pair(){
        String[] res = new String[4];
        res[0] = "N";
        String[] quad = this.quad();
        String[] set = this.set();
        int count = 0;
        for(int i = 0; i < this.combinationPlayer.size() - 1; i++){
            if(this.combinationPlayer.get(i).getValue() == this.combinationPlayer.get(i + 1).getValue()){
                if((quad[0] == "N" || quad[1] != this.combinationPlayer.get(i).getValue()) && (set[0] == "N" || set[1] != this.combinationPlayer.get(i).getValue())){ //verified that it's just a pair and no set or quad
                    count += 1;
                    if(count == 1){
                        res[0] = "Y";
                        res[1] = "1";
                        res[2] = this.combinationPlayer.get(i).getValue();
                    }
                    else{
                        res[1] = "2";
                        res[3] = this.combinationPlayer.get(i).getValue();
                    }
                    
                }
                
            }
        }
        
        return res;
    }

    /**
     * Determined if there is a set
     * 
     * @return An array of Strings. 1st is "Y" or "N" if there is a set or no. 2nd is the value of set.
     */
    public String[] set(){
        String[] res = new String[2];
        res[0] = "N";
        for(int i = 0; i < this.combinationPlayer.size() - 2; i++){
            if(this.combinationPlayer.get(i).getValue() == this.combinationPlayer.get(i + 1).getValue() && this.combinationPlayer.get(i).getValue() == this.combinationPlayer.get(i + 2).getValue()){
                if(this.quad()[0] == "N"){
                res[0] = "Y";
                res[1] = this.combinationPlayer.get(i).getValue();
                }
            }
        }
        return res;
    }

    /**
     * Determined if there is a quad.
     * 
     * @return An array of Strings. 1st is "Y" or "N" if there is a quad or no. 2nd is the value of quad. 
     */
    public String[] quad(){
        String[] res = new String[2];
        res[0] = "N";
        for(int i = 0; i < this.combinationPlayer.size() - 3; i++){
            if(this.combinationPlayer.get(i).getValue() == this.combinationPlayer.get(i + 1).getValue() && this.combinationPlayer.get(i).getValue() == this.combinationPlayer.get(i + 2).getValue() && this.combinationPlayer.get(i).getValue() == this.combinationPlayer.get(i + 3).getValue()){
                res[0] = "Y";
                res[1] = this.combinationPlayer.get(i).getValue();
            }
        }
        return res;
    }

    /**
     * Determined if there is a flush.
     * 
     * @return An array of Strings. 1st is "Y" or "N" if there is a flush or no. 2nd is the color of the flush. 
     * 3rd is the value of the stronger card of the flush.
     */
    public String[] flush(){
        String[] res = new String[3];
        res[0] = "Y";
        String color = this.combinationPlayer.get(0).getColor();
        for (Card card : combinationPlayer) {
            if(card.getColor() != color){
                res[0] = "N";
            }
        }
        if(res[0] == "Y"){
            res[1] = color;
            String value = this.combinationPlayer.getLast().getValue();
            res[2] = value;
        }
        return res;
    }

    /**
     * Determined if there is a full house.
     * 
     * @return An array of Strings. 1st is "Y" or "N" if there is a full house or no. 2nd is the value of the set. 
     * 3rd is the value of the pair.
     */
    public String[] fullHouse(){
        String[] res = new String[3];
        res[0] = "N";
        String[] set = this.set();
        if(set[0] == "Y"){
            for (int i = 0; i < this.combinationPlayer.size() - 1; i++) {
                if(this.combinationPlayer.get(i).getValue() != set[1]){ // if I don't look a card of the set
                    if(this.combinationPlayer.get(i).getValue() == this.combinationPlayer.get(i + 1).getValue()){ //if this card is equal to the next one
                        res[0] = "Y";
                        res[1] = set[1];
                        res[2] = this.combinationPlayer.get(i).getValue();
                    }
                }
            }
        }
        return res;
    }

    /**
     * Determined if there is a straight.
     * 
     * @return An array of Strings. 1st is "Y" or "N" if there is a straight or no. 2nd is the strongest card of the straight.
     */
    public String[] straight(){
        String[] res = new String[2];
        res[0] = "Y";
        res[1] = combinationPlayer.getLast().getValue();
        for (int i = 0; i < this.combinationPlayer.size() - 1; i++){
            Card currentCard = this.combinationPlayer.get(i);
            Card nextCard = this.combinationPlayer.get(i + 1);
            if(currentCard.hashCode() + 1 != nextCard.hashCode()){
                res[0] = "N";
                break;
            }
        }
        if(res[0] == "N" && this.combinationPlayer.getLast().getValue() == "A"){ //Case of Ace can be 1.
            if(combinationPlayer.get(0).getValue() == "2" && combinationPlayer.get(1).getValue() == "3" && combinationPlayer.get(2).getValue() == "4" && combinationPlayer.get(3).getValue() == "5"){
                res[0] = "Y";
                res[1] = "5";
            }
        }
        return res;
    }


    /**
     * Determined if there is a straight flush.
     * 
     * @return An array of Strings. 1st is "Y" or "N" if there is a straight flush or no. 2nd is the value of the straight stronger card. 
     * 3rd is the color of the flush.
     */
    public String[] straightFlush(){
        String[] res = new String[3];
        res[0] = "N";
        String[] straight = this.straight();
        String[] flush = this.flush();
        if(straight[0] == "Y" && flush[0] == "Y"){
            res[0] = "Y";
            res[1] = straight[1];
            res[2] = flush[1];
        }
        return res;
    }

    /**
     * Evaluation of this combination
     * 
     * @return Integer representing the value of the combination.
     */
    @Override
    public int hashCode(){
        String[] straightFlush = this.straightFlush();
        String[] quads = this.quad();
        String[] fullHouse = this.fullHouse();
        String[] flush = this.flush();
        String[] straight = this.straight();
        String[] set = this.set();
        String[] pair = this.pair();

        int res = 0;

        if(straightFlush[0] == "Y"){
            Card card = new Card(straightFlush[2], straightFlush[1]);
            int factor = card.hashCode();
            res += factor * Math.pow(15.0, 15.0);
        }

        if(quads[0] == "Y"){
            Card card = new Card("S",quads[1]);
            int factor = card.hashCode();
            res += factor * Math.pow(15.0,14.0);
        }

        if(fullHouse[0] == "Y"){
            Card cardSet = new Card("S", fullHouse[1]);
            Card cardPair = new Card("S", fullHouse[2]);
            int factorSet = cardSet.hashCode();
            int factorPair = cardPair.hashCode();
            res += (factorSet * (Math.pow(15.0, 13.0))) + (factorPair * (Math.pow(15.0, 12.0))); 
        }

        if(flush[0] == "Y"){
            Card card = new Card(flush[1], flush[2]);
            int factor = card.hashCode();
            res += factor * Math.pow(15.0, 11.0);
        }

        if(straight[0] == "Y"){
            Card card = new Card("S", straight[1]);
            int factor = card.hashCode();
            res += factor * Math.pow(15.0, 10.0);
        }

        if(set[0] == "Y"){
            Card card = new Card("S", set[1]);
            int factor = card.hashCode();
            res += factor * Math.pow(15.0, 9.0);
        }

        if(pair[0] == "Y" && Integer.parseInt(pair[1]) == 2){
            Card lowestCard = new Card("S", pair[2]);
            Card strongerCard = new Card("S", pair[3]);
            int strongFactor = strongerCard.hashCode();
            int lowFactor = lowestCard.hashCode();
            System.out.println("factor : " + strongFactor + ", " + lowFactor);
            System.out.println("res before " + res);
            res += (strongFactor * Math.pow(15.0, 8.0)) + (lowFactor * Math.pow(15.0, 7.0));
            System.out.println("res after " + res);
        }

        if(pair[0] == "Y" && Integer.parseInt(pair[1]) == 1){
            Card card = new Card("S", pair[2]);
            int factor = card.hashCode();
            res += factor * Math.pow(15.0, 6.0);
        }

        System.out.println("res before kickers " + res);
        double i = 1.0;
        for (Card card : this.combinationPlayer) {
            int factor = card.hashCode();
            res += factor * Math.pow(15.0, i);
            i += 1.0;
        }
        System.out.println("res after kickers " + res);

        return res;
    }


    /**
     * Determined if two combination are equals
     * 
     * @return a boolean representing if the 2 combinations are equal or not.
     */
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Combination)){
            return false;
        }
        Combination combination = (Combination) o;
        return combination.hashCode() == this.hashCode();
    }


    /**
     * Compare 2 combinations
     * 
     * @return An integer representing if this combination is stronger or not than an other combination.
     * -1 if this combination is lowest than the other. 0 if there are equal. 1 otherwise.
     */

    @Override
    public int compareTo(Combination otherCombination){
        if(this.hashCode() == otherCombination.hashCode()){
            return 0;
        }
        if(this.hashCode() < otherCombination.hashCode()){
            return -1;
        }
        else{
            return 1;
        }
    }


}
