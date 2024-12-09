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

    
}
