package pokerController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CombinationBis implements Iterable<Card>{
    private List<Card> combinationPlayer;
    
    public CombinationBis(List<Card> combinationPlayer){
        this.combinationPlayer = combinationPlayer;
        Collections.sort(combinationPlayer);
    }

    // Allows to iterate through a combination (foreach).
    public Iterator<Card> iterator(){
        return combinationPlayer.iterator();
    }

    public String[] pair(){
        String[] res = new String[4];
        res[0] = "N";
        String[] quad = this.quad();
        String[] set = this.set();
        int count = 0;
        for(int i = 0; i < this.combinationPlayer.size() - 1; i++){
            if(this.combinationPlayer.get(i).getValue() == this.combinationPlayer.get(i + 1).getValue()){
                if((quad[0] == "N" || quad[1] != this.combinationPlayer.get(i).getValue()) && (set[0] == "N" || set[1] != this.combinationPlayer.get(i).getValue())){
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

    public String[] set(){
        String[] res = new String[2];
        res[0] = "N";
        String[] quad = this.quad();
        for(int i = 0; i < this.combinationPlayer.size() - 2; i++){
            if(this.combinationPlayer.get(i).getValue() == this.combinationPlayer.get(i + 1).getValue() && this.combinationPlayer.get(i).getValue() == this.combinationPlayer.get(i + 2).getValue()){
                if(quad[0] == "N" || quad[1] != this.combinationPlayer.get(i).getValue()){
                    res[0] = "Y";
                    res[1] = this.combinationPlayer.get(i).getValue();
                }
            }
        }
        return res;
    }

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

    public String[] flush(){
        String[] res = new String[3];
        res[0] = "Y";
        String color = this.combinationPlayer.get(0).getColor();
        res[1] = color;
        String value = this.combinationPlayer.getLast().getValue();
        res[2] = value;
        for (Card card : combinationPlayer) {
            if(card.getColor() != color){
                res[0] = "N";
            }
        }
        return res;
    }

    public String[] fullHouse(){
        String[] res = new String[3];
        res[0] = "N";
        String[] set = this.set();
        String[] pair = this.pair();
        if (set[0] == "Y" && pair[0] == "Y"){
            res[0] = "Y";
            res[1] = set[1];
            res[2] = pair[1];
        }
        return res;
    }

    public String[] straight(){
        String[] res = new String[2];
        res[0] = "Y";
        res[1] = combinationPlayer.getLast().getValue();
        for (int i = 0; i < this.combinationPlayer.size() - 1; i++){
            Card currentCard = this.combinationPlayer.get(i);
            Card nextCard = this.combinationPlayer.get(i + 1);
            if(currentCard.hashCode() + 1 != nextCard.hashCode()){
                res[0] = "N";
            }
        }
        if(res[0] == "N" && this.combinationPlayer.getLast().getValue() == "A"){
            res[0] = "Y";
            List<Card> newCombination = new ArrayList<>();
            newCombination = this.combinationPlayer.subList(1, this.combinationPlayer.size());
            newCombination.addFirst(this.combinationPlayer.getLast());
            res[1] = "5";
            if(this.combinationPlayer.get(1).hashCode() != 2){
                res[0] = "N";
            }
            for (int i = 1; i < this.combinationPlayer.size() - 1; i++){
                if(this.combinationPlayer.get(i).hashCode() != this.combinationPlayer.get(i + 1).hashCode() + 1){
                    res[0] = "N";
                }
            }
        }
        return res;
    }

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
}