package pokerController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck implements Iterable<Card>{
    
    private List<Card> deck;

    public Deck(boolean shuffled) throws FileNotFoundException, IOException{

        List<Card> deck = new ArrayList<Card>();

        BufferedReader in =  new BufferedReader(new FileReader("data/cardData.txt"));
        while(in.ready()){
            String str = in.readLine();
            String[] inter = str.split(" ");
            Card card = new Card(inter[0].trim(), inter[1].trim());
            deck.add(card);
        }
        in.close();

        if(shuffled){
            Collections.shuffle(deck);
        }
        this.deck = deck;
    }

    public Iterator<Card> iterator(){
        return deck.iterator();
    }

    public Card getFirst(){
        return deck.getFirst();
    }

    public void removeFirst(){
        deck.removeFirst();
    }
    
    public List<Card> getDeck(){
        return this.deck;
    }
}
