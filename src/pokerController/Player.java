package pokerController;

import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private int stack;
    

    public Player(String name, List<Card> hand, int stack){
        this.hand = hand;
        this.name = name;
        this.stack = stack;
    }

    public List<Card> getHand(){
        return this.hand;
    }

    public int getStack(){
        return this.stack;
    } 
    
    public String getName(){
        return this.name;
    }
    
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public String handToString(){
        String str = this.getName() + "'s hand : [";
        for (Card card : hand) {
            str = str + card.cardToString() + ", ";
        }
        str = str.substring(0, str.length()-2);
        str += "]";
        return str;
    }
}
