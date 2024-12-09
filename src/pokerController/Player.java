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

<<<<<<< HEAD
    public List<Card> getHand(){
        return this.hand;
    }
=======

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }


    public void setStack(int stack) {
        this.stack = stack;
    }

    
>>>>>>> f74ab13 (method of the differents combination possible)
    
}
