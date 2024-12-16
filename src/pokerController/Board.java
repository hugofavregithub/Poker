package pokerController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board implements Iterable<Card>{
    
    private List<Card> board;

    public Board(){
        this.board = new ArrayList<Card>();
    }

    public void boardUpdate(int state, Deck deck){
        if(state == 0){
            throw new IllegalArgumentException("It's preflop time");
        }
        if(state == 1){
            for(int i=0; i<3; i++){
                board.add(deck.getFirst());
                deck.removeFirst();
            }
        }
        if(state == 2 || state == 3){
            board.add(deck.getFirst());
            deck.removeFirst();
        }
        if(state == 4){
            throw new IllegalArgumentException("Time to show what you got");
        }
    }

    public Iterator<Card> iterator(){
        return board.iterator();
    }

    public Card getFirst(){
        return board.getFirst();
    }

    public void removeFirst(){
        board.removeFirst();
    }

    public String boardToString(){
        String str = "Board : [";
        for (Card card : board) {
            str += card.cardToString() + ", ";
        }
        str = str.substring(0, str.length()-2);
        str += "]";
        return str;
    }
}
