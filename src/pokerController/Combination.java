package pokerController;

import java.util.Collections;
import java.util.List;

public class Combination {
    private List<Card> combinationPlayer;
    
    public Combination(List<Card> combinationPlayer){
        this.combinationPlayer = combinationPlayer;
        Collections.sort(combinationPlayer);
    }

    public String[] pair(){
        String[] res = new String[2];
        res[0] = "N";
        String[] quad = this.quad();
        String[] set = this.set();
        for(int i = 0; i < this.combinationPlayer.size() - 1; i++){
            if(this.combinationPlayer.get(i).getValue() == this.combinationPlayer.get(i + 1).getValue()){
                if((quad[0] == "N" || quad[1] != this.combinationPlayer.get(i).getValue()) && (set[0] == "N" || set[1] != this.combinationPlayer.get(i).getValue())){
                    res[0] = "Y";
                    res[1] = this.combinationPlayer.get(i).getValue();
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
        String[] res = new String[2];
        res[0] = "Y";
        String color = this.combinationPlayer.get(0).getColor();
        res[1] = color;
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
            if(this.combinationPlayer.get(i).hashCode() != this.combinationPlayer.get(i + 1).hashCode()){
                res[0] = "N";
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
